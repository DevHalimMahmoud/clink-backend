package com.abdelhalim.egypt.clinics.utils;

public class Base64Utils {
    public static String getFileExtensionFromBase64(String base64String) {

        return base64String.split(",")[0].split("/")[1].split(";")[0];
    }
}
