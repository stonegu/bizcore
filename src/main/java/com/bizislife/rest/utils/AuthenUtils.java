package com.bizislife.rest.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

public class AuthenUtils {

    public static String createSecureHeader(String clientName, String secret) throws UnsupportedEncodingException {
        return "Basic " + Base64.encodeBase64String((clientName + ':' + secret).getBytes(StandardCharsets.UTF_8));
    }
}
