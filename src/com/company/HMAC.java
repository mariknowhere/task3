package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class HMAC {
    static public byte[] calcHmacSha256(byte[] secretKey, byte[] message) {
        byte[] hmacSha256 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return hmacSha256;
    }

    static public void generateKey() {
        try {
            byte[] hmacSha256 = HMAC.calcHmacSha256("secret123".getBytes("UTF-8"), "hello world".getBytes("UTF-8"));
            System.out.println(String.format("HMAC: %032x", new BigInteger(1, hmacSha256)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
