package cn.longskyer.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**   
 * @ClassName:  SHA1   
 * @Description:TODO sha1算法加密字符串，无法从加密字符串还原出明文
 * @author: longskyer 2503802889@qq.com
 * @date:   2018年7月7日 上午9:16:20        
 */
public class SHA1 {

	/**   
	 * @Title: SHA1ByteArray   
	 * @Description: TODO SHA1算法加密byte数组，返回加密后的byte数组
	 * @param: @param source
	 * @param: @return      
	 * @return: byte[]      
	 * @throws   
	 */
	public static byte[] SHA1AtByteArray(byte[] source) {
		try {
			MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
			sha1Digest.update(source);
			byte targetDigest[] = sha1Digest.digest();
			return targetDigest;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**   
	 * @Title: encrypt   
	 * @Description: TODO SHA1加密字符串
	 * @param: @param source 要加密的字符串
	 * @param: @return  加密后的字符串    
	 * @return: String      
	 * @throws   
	 */
	public static String encrypt(String source) {
		return ByteArrayAndHexStr.byteArray2HexStr(SHA1AtByteArray(source.getBytes()));
	}


}
