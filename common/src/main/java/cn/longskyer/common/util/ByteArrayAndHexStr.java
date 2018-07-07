package cn.longskyer.common.util;

/**   
 * @ClassName:  ByteArrayAndHexStr   
 * @Description:TODO  字节数组和16进制字符串的互相转换
 * @author: 黄飞龙 2503802889@qq.com
 * @date:   2018年7月7日 上午9:01:07        
 */
public class ByteArrayAndHexStr {
	
	/**   
	 * @Title: byte2HexStr   
	 * @Description: TODO byte数组转换成16进制字符串
	 * @param: @param bytes
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String byteArray2HexStr(byte[] bytes) {
		int bytesLen = bytes.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer hexString = new StringBuffer(bytesLen * 2);
		for (int i = 0; i < bytesLen; i++) {
			// 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() < 2) {
				hexString.append(0);// 如果为1位 前面补个0
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	/**   
	 * @Title: hexStr2Bytes   
	 * @Description: TODO 16进制字符串转换成字节数组
	 * @param: @param strIn
	 * @param: @return      
	 * @return: byte[]      
	 * @throws   
	 */
	public static byte[] hexStr2ByteArray(String strIn) {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
 
		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

}
