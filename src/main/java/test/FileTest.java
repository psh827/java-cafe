package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	private static final String SAVE_DIR = "C:/test";
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;
		try {
			try {
				fis = new FileInputStream("C:/test/strawberryLatte.png");
				fos = new FileOutputStream("C:/test/test_copy.png");
				for(int readByte; (readByte = fis.read()) != -1;) {
					fos.write(readByte);
					totalBytes++;
				}
			} finally {
				fos.close();
				fis.close();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("전체 바이트 수: " + totalBytes + " bytes.");
	}

}
