package com.drive.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class Crypto {

    @Value("${jwt.secret}")
    private static String secret;
    
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private static SecretKeySpec getSecretKeySpec() {
        byte[] keyBytes = secret.getBytes();
        return new SecretKeySpec(keyBytes, 0, Math.min(keyBytes.length, 16), ALGORITHM);
    }

    private static IvParameterSpec getIvParameterSpec() {
        byte[] keyBytes = secret.getBytes();
        return new IvParameterSpec(keyBytes, 0, 16);  // Using first 16 bytes of the key as IV
    }

    public static String encrypt(String input) {
        try {
            SecretKeySpec secretKeySpec = getSecretKeySpec();
            IvParameterSpec ivParameterSpec = getIvParameterSpec();
    
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String decrypt(String hash) {
        try {
            SecretKeySpec secretKeySpec = getSecretKeySpec();
            IvParameterSpec ivParameterSpec = getIvParameterSpec();
    
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decodedBytes = Base64.getDecoder().decode(hash);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
