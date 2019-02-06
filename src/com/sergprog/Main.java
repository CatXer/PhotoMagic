package com.sergprog;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static final int sizeOfIntInHalfBytes = 8;
    private static final int numberOfBitsInAHalfByte = 4;
    private static final int halfByte = 0x0F;
    private static final char[] hexDigits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String decToHex(int dec) {
        StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
        hexBuilder.setLength(sizeOfIntInHalfBytes);
        for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i)
        {
            int j = dec & halfByte;
            hexBuilder.setCharAt(i, hexDigits[j]);
            dec >>= numberOfBitsInAHalfByte;
        }
        return hexBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("/home/serg/Изображения/icons/Test.png"));
        for (int in10 : bytes) {
            System.out.print(in10 + ",");
        }
        System.out.println("\n");
        for (int in10 : bytes) {
            System.out.print(decToHex(in10) + ",");
        }
        System.out.println("\n");
        for (int inC : bytes)
            if ((char)inC!='\n') System.out.println("[ "+(char)inC+" ],");
            else System.out.println("[ \\n ],");

            Main m = new Main();
            m.JavaWalkBufferedImageTest1();
    }



    public void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    private void marchThroughImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        System.out.println("width, height: " + w + ", " + h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getRGB(j, i);
                printPixelARGB(pixel);
                System.out.println("");
            }
        }
    }

    public void JavaWalkBufferedImageTest1() {
        try {
            // get the BufferedImage, using the ImageIO class
            BufferedImage image =
                    ImageIO.read(new File("/home/serg/Изображения/icons/Test.png"));
            marchThroughImage(image);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}
