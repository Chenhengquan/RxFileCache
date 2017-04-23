package com.chan.rxcache;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者： fangguiliang  时间： 16/7/6.
 * 功能：
 * 修改：
 */

public class StringUtil {
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value.trim());
    }


    public static String getUrlValue(String url, String key) {
        int start = url.indexOf(key) + key.length();
        int i = url.indexOf("&", start);
        return url.substring(start, i == -1 ? url.length() : i);
    }

    /*首字母大写*/
    public static String capitalize(String value) {
        if (isEmpty(value)) return "";
        String first = value.substring(0, 1).toUpperCase();
        return value.length() == 1 ? first : first + value.substring(1);
    }

    public static boolean checkPassword(String password) {
        if (isEmpty(password)) {
            return false;
        }
        final String passwordRegular = "^[a-zA-Z0-9]{6,15}";
        Pattern p = Pattern.compile(passwordRegular);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        CharSequence inputStr = phoneNumber;
        //正则表达式
        String phone = "^1[34578]\\d{9}$";
        Pattern pattern = Pattern.compile(phone);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

//    public static String parseObjectToJsonString(Object object) {
//        return NetworkUtil.generateCustomGson().toJson(object);
//    }
//
//    public static <T> T parseJsonStringToObject(String jsonString, Class<T> clazz) {
//        if (isEmpty(jsonString)) {
//            return null;
//        }
//        return new Gson().fromJson(jsonString, clazz);
//    }
}
