package com.flyonsky.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

    public static String md5(String content){
        String result = content;
        try{
            MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(content.getBytes(Charset.forName("UTF-8")));
            StringBuilder buf=new StringBuilder();
            for(byte b:digest.digest()){
                buf.append(String.format("%02x", b&0xff) );
            }
            result = buf.toString();
        }catch (NoSuchAlgorithmException e){
            LOGGER.debug("md5 is error ", e);
        }
        return result;
    }
}
