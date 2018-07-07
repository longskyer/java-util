package cn.longskyer.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	/**   
	 * @Title: MD5AtByteArray   
	 * @Description: TODO MD5加密byte数组，返回加密后的byte数组
	 * @param: @param source
	 * @param: @return      
	 * @return: byte[]      
	 * @throws   
	 */
	public static byte[] MD5AtByteArray(byte[] source) {
		try {
			// 获得MD5摘要算法的 MessageDigest对象
			MessageDigest md5Digest = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			md5Digest.update(source);
			// 获得密文
			return md5Digest.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**   
	 * @Title: encrypt   
	 * @Description: TODO MD5加密字符串，返回加密后的字符串，32位长
	 * @param: @param source
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String encrypt(String source) {
		return ByteArrayAndHexStr.byteArray2HexStr(MD5AtByteArray(source.getBytes()));
	}



}
