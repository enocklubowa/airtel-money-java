package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.configuration.Properties;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PinEncoder {

    protected static String DEFAULT_ENCRYPTION_ALGORITHM = "RSA";
    protected static String DEFAULT_TRANSFORMATION = "RSA/ECB/PKCS1Padding";

    public static String encode(String pin) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String encryptData = encrypt(pin, Properties.airtel_public_key);
        System.out.println("Encrypted String-" + encryptData);
        return pin;
    }


    private static String encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException,
            InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(
                    Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance(DEFAULT_ENCRYPTION_ALGORITHM);
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

}
