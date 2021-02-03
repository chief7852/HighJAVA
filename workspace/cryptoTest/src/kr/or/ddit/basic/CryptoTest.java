package kr.or.ddit.basic;

import java.security.NoSuchAlgorithmException;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		//암호화 할 데이터
		String plainText = "Hello, Worlsdsf 가나해 123545($&!";
		
		System.out.println("MD5 : "+CryptoUtil.md5(plainText));
		System.out.println("SHA-256 : "+CryptoUtil.sha256(plainText));
		System.out.println("SHA-512 : "+CryptoUtil.sha512(plainText));
		System.out.println("-------------------------------------------------\n");
		System.out.println(CryptoUtil.sha256(plainText).length());
	}

	
	
}
