package com.message.common;


import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;

public class AESUtil {
	public static String encrypt(String data, String key) throws Exception {
		String iv = key;
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		int blockSize = cipher.getBlockSize();

		byte[] dataBytes = data.getBytes();
		int plaintextLength = dataBytes.length;
		if (plaintextLength % blockSize != 0) {
			plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
		}

		byte[] plaintext = new byte[plaintextLength];
		System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

		SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

		cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
		byte[] encrypted = cipher.doFinal(plaintext);

		return new Base64().encodeToString(encrypted);

	}

	public static String decrypt(String data, String key) throws Exception {
		String iv = key;
		byte[] encrypted1 = new Base64().decode(data);

		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

		cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

		byte[] original = cipher.doFinal(encrypted1);
		String originalString = new String(original);
		return originalString.trim();
	
	}

	public static void main(String[] args) throws Exception {
		// c9776f230f2d60b96529c71fc5f2e9e92a351687992419433aed362da5299e826ad38b5b3bc96ae0e7b0aff5f2af23af5f28f8a26a4e01c99360b3c2887164d755766b8cbc6ddedcde8602f069daab6d4751e8f70bcbeb70a6a3a917313c2fc7
		// BEE8A5F663000360E3B7AE889DE438EF89592208677302D116A1B4855C712B6A16AEB7ECD673FC46D3A44B9FE515E5A77AA1EA2D14881F5186DF5E9ED360EF48
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("empNo", "10048");
		pMap.put("queryDate", "2016-11-17 16:01:01");
		String pStr = JSON.toJSONString(pMap);
		String param = encrypt(pStr, "zhongliang123456");
		System.out.println(param);
		// DBA4D3F7EC5A443F5C445D3E65684E9DB9D5D1AC9294E4B02F4A5E558448305B
		System.out.println(decrypt(param, "zhongliang123456"));

		// String content = "test";
		// String password = "12345678";
		// //加密
		// System.out.println("加密前：" + content);
		// String encryptResultStr = encrypt(content, password);
		// System.out.println("加密后：" + encryptResultStr);
		// //解密
		// String decryptResult = decrypt(encryptResultStr,password);
		// System.out.println("解密后：" + decryptResult);
	}
}
