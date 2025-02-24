package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

public class Md5Hashing {
	
	  public String getMd5(String input)
	    {
	        try {
	 
	            // Static getInstance method is called with hashing MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	 
	            // digest() method is called to calculate message digest
	            // of an input digest() return array of byte
	            byte[] messageDigest = md.digest(input.getBytes());
	 
	            // Convert byte array into sig num representation
	            BigInteger no = new BigInteger(1, messageDigest);
	 
	            // Convert message digest into hex value
	            String hashtext = no.toString(16);
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        }
	 
	        // For specifying wrong message digest algorithms
	        catch (NoSuchAlgorithmException e) {
	        	System.out.println(e.getMessage());
	        	System.out.println(e.getCause());
	        	
	            throw new RuntimeException(e);
	        }
	    }
	  
//	  public String decode(String data) throws Exception {
//	        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//	        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
//	        BASE64Decoder base64Decoder = new BASE64Decoder();
//	        //Note here that the number of bits of the parameter of doFinal() must be a multiple of 8, otherwise an error will be reported (the number of bits of the parameter of doFinal() here is not a multiple of 8, because the number of bits of the parameter of final() is not a multiple of 8, because the number of bits of the parameter can be read by encode encrypted string is 8, but it can be read by writing the file and read again)
//	        //base64Decoder must be used here, if data is used. getBytes(), the number of bytes array of the string obtained is probably not a multiple of 8, and does not correspond to the BASE64Encoder above (even if the decryption does not report an error, it will not get the correct result)
//	        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
//	        return new String(pasByte, this.charset);
//	    }
//	  
	  

}
