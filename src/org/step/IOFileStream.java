package org.step;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class IOFileStream {
    private byte[] bytes;
    private String path;

    public IOFileStream(String filePath) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            this.bytes = new byte[fileInputStream.readAllBytes().length];
            this.path=filePath;
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
            this.path="";
        }finally {
            fileInputStream.close();
        }
    }

    public StringBuilder readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(this.path);
            Scanner reader = new Scanner(fileInputStream);
            int line = 0;
            while (reader.hasNextLine()) {
                line++;
                String data = reader.nextLine();
                int poz =0;
                for(String str : data.split(" ")) {
                    Scanner scan = new Scanner(str);
                    if (scan.hasNextInt())
                        System.out.printf("Найден integer: срока - %d, позиция - %d\n", line,poz);
                    else if (scan.hasNextDouble())
                        System.out.printf("Найден double: срока - %d, позиция - %d\n", line,poz);
                    else if (scan.hasNext())
                        System.out.printf("Найден string: срока - %d, позиция - %d\n", line,poz);
                    poz+=str.length();
                }
                sb.append(data+"\n");
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
            this.path="";
        }finally {
            fileInputStream.close();
        }
        return sb;
    }

    public void Copy(String path) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(this.readFile().toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("Файл успешно скопирован");
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
        }
        fileOutputStream.close();
    }

}
