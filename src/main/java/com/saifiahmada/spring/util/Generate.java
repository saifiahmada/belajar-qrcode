package com.saifiahmada.spring.util;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Generate {

	public static void createQRCode(String [] text) {
		
		String textInput = text[0];
		String namaFile = text[1];
		
	    Charset charset = Charset.forName("ISO-8859-1");
	    CharsetEncoder encoder = charset.newEncoder();
	    byte[] b = null;
	    try {
	        // Convert a string to ISO-8859-1 bytes in a ByteBuffer
	        ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(textInput));
	        b = bbuf.array();
	    } catch (CharacterCodingException e) {
	        System.out.println(e.getMessage());
	    }

	    String data = null;
	    try {
	        data = new String(b, "ISO-8859-1");
	    } catch (UnsupportedEncodingException e) {
	        System.out.println(e.getMessage());
	    }

	    // get a byte matrix for the data
	    BitMatrix matrix = null;
	    int h = 100;
	    int w = 100;
	    com.google.zxing.Writer writer = new QRCodeWriter();
	    try {
	        matrix = writer.encode(data, 
	        com.google.zxing.BarcodeFormat.QR_CODE, w, h);
	    } catch (com.google.zxing.WriterException e) {
	        System.out.println(e.getMessage());
	    }
	    
	    Path path = Paths.get("/home/saifi/GAZA/QRCODE/"+ namaFile + ".PNG");
	    
	    try {
	        MatrixToImageWriter.writeToPath(matrix, "PNG", path); 
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	    
	}

}
