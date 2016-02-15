package org.self.learn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class JavaIODriver {

	public static void main(String[] args) throws IOException {
		System.out.println("I am in main()");
		//byteStreamIO();
		//byteBufferedStreamIO();
		//fileReaderFileWriter();
		//bufferedIO();
		//bufferedIOFlush();
		//bufferedIOFlushnScanner();
		bufferedIOFlushnScannerAppend();
	}
	
	/**creates byte stream  Any text you write has to be encoded as
	 bytes using some encoding (most commonly ISO-8859-1 or UTF-8)**/
	public static void byteStreamIO() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		 
		try{
			in = new FileInputStream(source);
			out = new FileOutputStream(destination);
			int c;
			
			while((c=in.read())!=-1){
				out.write(c);
			}
		} finally {
			if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
		}
	}
	
	/**
	 * With a BufferedInputStream, the method delegates to an
	 * overloaded read() method that reads 8192 amount of
	 * bytes and buffers them until they are needed.
	 **/
	public static void byteBufferedStreamIO() throws IOException {
		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try {
			inputStream = new BufferedInputStream(new FileInputStream(source));
			outputStream = new BufferedOutputStream(new FileOutputStream(destination));
			int i;
			
			while((i=inputStream.read())!=-1) {
				outputStream.write(i);
			}
		} finally {
			if(inputStream!=null){inputStream.close();}
			if(outputStream!=null){outputStream.close();}
		}
	}
	
	public static void fileReaderFileWriter() throws IOException {
		FileReader reader = null;
		FileWriter writer = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try{
			reader = new FileReader(source);
			writer = new FileWriter(destination);
			
			while (reader.ready()){
				writer.write(reader.read());
			}
		} finally {
			if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
		}
	}
	
	public static void lineOrientedIOPrintWriter() throws IOException {
		BufferedReader reader = null;
		PrintWriter writer = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try{
			reader = new BufferedReader(new FileReader(source));
			writer = new PrintWriter(new FileWriter(destination));
			String str = null;
			
			while((str=reader.readLine())!=null){
				writer.println(str);
			}
		} finally {
			if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
		}
	}
	
	public static void bufferedIO() throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try{
			reader = new BufferedReader(new FileReader(source));
			writer = new BufferedWriter(new FileWriter(destination));
			String str = null;
			
			while((str=reader.readLine())!=null){
				writer.write(str);
				writer.newLine();
			}
		} finally {
			if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
		}
	}
	
	//Uses reader.ready() instead of reading line
	public static void bufferedIOFlush() throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try{
			reader = new BufferedReader(new FileReader(source));
			writer = new BufferedWriter(new FileWriter(destination));
			
			while(reader.ready()){
				writer.append(reader.readLine());
				writer.newLine();
			}
			writer.flush();
		} finally {
			if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
		}
	}
	
	//Uses reader.ready() instead of reading line
	public static void bufferedIOFlushnScanner() throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		Scanner sc = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try{
			reader = new BufferedReader(new FileReader(source));
			sc = new Scanner(reader);
			writer = new BufferedWriter(new FileWriter(destination));
			
			while(sc.hasNextLine()){
				writer.append(sc.nextLine());
				writer.newLine();
			}
			writer.flush();
		} finally {
			if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (sc!=null) {
            	sc.close();
            }
		}
	}
	
	//Uses reader.ready() instead of reading line
	public static void bufferedIOFlushnScannerAppend() throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		Scanner sc = null;
		File source = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\source.txt");
		File destination = new File("C:\\Workspace\\JavaIO\\java-io-showcase\\resource\\destination.txt");
		
		try{
			reader = new BufferedReader(new FileReader(source));
			sc = new Scanner(reader);
			writer = new BufferedWriter(new FileWriter(destination, true));
			
			while(sc.hasNextLine()){
				writer.append(sc.nextLine());
				writer.newLine();
			}
			writer.flush();
		} finally {
			if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (sc!=null) {
            	sc.close();
            }
		}
	}
}
