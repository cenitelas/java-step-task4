package org.step;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "text.txt";
        IOFileStream fileStream = new IOFileStream(fileName);
        fileStream.Copy("text2.txt");

//        byte[] bytesToWrite = new byte[]{1, 2, 3};
//        byte[] bytesRead = new byte[10];
//
//
//
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//
//        try {
//            fileOutputStream = new FileOutputStream(fileName);
//            System.out.println("File is ready for writing");
//
//            fileOutputStream.write(bytesToWrite);
//            System.out.println("Written " + bytesToWrite.length + " bytes");
//
//            fileOutputStream.close();
//            System.out.println("Stream is closed");
//
//            fileInputStream = new FileInputStream(fileName);
//            System.out.println("Available in file " + fileInputStream.available());
//
//            int read = fileInputStream.read(bytesRead, 0, fileInputStream.available());
//            System.out.println("Read " + read + " bytes");
//
//            fileInputStream.close();
//            System.out.println("Stream is closed");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            fileInputStream.close();
//        }
    }
}
