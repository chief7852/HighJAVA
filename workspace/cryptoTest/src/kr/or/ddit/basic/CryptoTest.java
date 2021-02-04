package kr.or.ddit.basic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {
	private static final String key = "asfasfascasdsafgsaf451422422";
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
			
		
		
		//암호화 할 데이터
		String plainText = "Hello, Worlsdsf 가나해 123545($&!";
		
		System.out.println("MD5 : "+CryptoUtil.md5(plainText));
		System.out.println("SHA-256 : "+CryptoUtil.sha256(plainText));
		System.out.println("SHA-512 : "+CryptoUtil.sha512(plainText));
		
		System.out.println("-------------------------------------------------\n");
		System.out.println(CryptoUtil.sha256(plainText).length());
		System.out.println("-------------------------------------------------\n");
		String result = CryptoUtil.encrtptAES256(plainText, key);
		String result2 = CryptoUtil.decryptAES256(result, key);
		System.out.println("원본 데이터 : " + plainText);
		System.out.println("암호화 된 데이터 : "+result);
		System.out.println("복호화 된 데이터 : "+result2);
	}

	
	
	
}
