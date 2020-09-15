package com.xiaoqi.cloudss.utils;

import java.security.MessageDigest;
import java.util.Locale;

public class Md5Util {
    public static String getMD5Str(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] byteArray = messageDigest.digest();
            StringBuilder md5StrBuff = new StringBuilder();
            for (byte aByteArray : byteArray) {
                if (Integer.toHexString(0xFF & aByteArray).length() == 1)
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & aByteArray));
                else
                    md5StrBuff.append(Integer.toHexString(0xFF & aByteArray));
            }
            return md5StrBuff.toString().toLowerCase(Locale.getDefault());
        } catch (Exception ex) {
            return "";
        }
    }
}
