package com.yfy.final_tag;

import android.util.Base64;
import android.util.Xml;

import com.yfy.app.login.bean.MD5;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static byte[]  mSecretKey; // 密钥
    private static String ALGORITHM = "AES"; //加解密算法
    private static String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding"; // 加密算法/工作模式/填充方式
//    private static byte[]  iv = new byte[16]; // 用于初始化向量，必须是16位
    private static byte[]  iv = new byte[16]; // 用于初始化向量，必须是16位


    /**
     * 加密
     * @param plaintext 明文
     */
    public static String encrypt(String plaintext) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Key key = getSecretKey();
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE/*加密*/, key, new IvParameterSpec(iv)); // CBC模式需要初始化向量
        byte[] cipherTextInByte = cipher.doFinal(plaintext.getBytes());//将明文String转换为byte[]后加密， 得到byte[]

        return Base64.encodeToString(cipherTextInByte, Base64.DEFAULT); //对加密后得到的byte[]进行编码并返回String
    }

    /**
     * 解密
     * @param cipherText 密文
     */
    public  static String decrypT(String cipherText) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Key key = getSecretKey();
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE/*解密*/, key, new IvParameterSpec(iv));// CBC模式需要初始化向量
        byte[] decryptTextInByte = cipher.doFinal(Base64.decode(cipherText, Base64.DEFAULT));//对密文String解码为byte[]后解密，得到byte[]
        return new String(decryptTextInByte);//将解密后得到的byte[]转换为String
    }

    /**
     * 获取密钥
     */
    private static Key getSecretKey() throws NoSuchAlgorithmException {
        if(mSecretKey == null) {
            createSecretKey();
        }
        return new SecretKeySpec(mSecretKey, ALGORITHM);
    }

    /**
     * 生成密钥
     */
    private static void  createSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        SecretKey secretKey  = keyGenerator.generateKey();
        mSecretKey = secretKey == null? null:secretKey.getEncoded();
    }

}