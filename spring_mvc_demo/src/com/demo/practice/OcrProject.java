package com.demo.practice;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OcrProject {

	public static void main(String[] args) {
		System.out.println("Abhay Bhai");
		 Tesseract tesseract = new Tesseract();
	        try {
	  
	            tesseract.setDatapath("C:\\Users\\Abhay Kumar\\Downloads\\Tess4J\\tessdata");
	  
	            // the path of your tess data folder
	            // inside the extracted file
	            String text
	                = tesseract.doOCR(new File("C:\\Users\\Abhay Kumar\\Downloads\\Tess4J\\abc.png"));
	            
	            String text1
                = tesseract.doOCR(new File("C:\\Users\\Abhay Kumar\\Downloads\\Tess4J\\testocr.png"));
            
	  
	            // path of your image file
	            System.out.print(text);
	            System.out.println();
	            System.out.println(text1);
	        }
	        catch (TesseractException e) {
	            e.printStackTrace();
	        }
	}
}
