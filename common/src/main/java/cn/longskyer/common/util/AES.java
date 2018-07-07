package cn.longskyer.common.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	
	/**   
	 * @Title: getKey   
	 * @Description: TODO 从指定字符串生成密钥
	 * @param: @param password 构成该秘钥的字符串
	 * @param: @return 生成的密钥
	 * @param: @throws NoSuchAlgorithmException      
	 * @return: Key      
	 * @throws   
	 */
	private static Key getKey(String password) throws NoSuchAlgorithmException {
		SecureRandom secureRandom = new SecureRandom(password.getBytes());
		// 生成KEY
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, secureRandom);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		// 转换KEY
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		return key;
	}

	/**   
	 * @Title: AESAtByteArray   
	 * @Description: TODO AES加密
	 * @param: @param content 要加密的内容
	 * @param: @param password 加密密钥
	 * @param: @return 加密后的字节数组  
	 * @return: byte[]      
	 * @throws   
	 */
	public static byte[] AESAtByteArray(byte[] content, String password) {
		try {
			Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
			encryptCipher.init(Cipher.ENCRYPT_MODE, getKey(password));// 初始化
			byte[] result = encryptCipher.doFinal(content);
			return result; // 加密
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**   
	 * @Title: UnAESAtByteArray   
	 * @Description: TODO AES解密
	 * @param: @param content 加密的字节数组
	 * @param: @param password 解密密钥
	 * @param: @return 解密后的字节数组    
	 * @return: byte[]      
	 * @throws   
	 */
	public static byte[] UnAESAtByteArray(byte[] content, String password) {
		try {
			Cipher decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
			decryptCipher.init(Cipher.DECRYPT_MODE, getKey(password));// 初始化
			byte[] result = decryptCipher.doFinal(content);
			return result; // 加密结果
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**   
	 * @Title: encrypt   
	 * @Description: TODO AES算法加密
	 * @param: @param content 要加密的字符串
	 * @param: @param password 加密密钥
	 * @param: @return  加密后的密文字符串    
	 * @return: String      
	 * @throws   
	 */
	public static String encrypt(String content, String password) {
		return ByteArrayAndHexStr.byteArray2HexStr(AESAtByteArray(content.getBytes(), password));
	}

	/**   
	 * @Title: decrypt   
	 * @Description: TODO AES算法解密 
	 * @param: @param content 加密的密文
	 * @param: @param password 解密密钥
	 * @param: @return  解密后的字符串   
	 * @return: String      
	 * @throws   
	 */
	public static String decrypt(String content, String password) {
		return new String(UnAESAtByteArray(ByteArrayAndHexStr.hexStr2ByteArray(content), password));
	}




}
