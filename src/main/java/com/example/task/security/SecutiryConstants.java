package com.example.task.security;

import com.example.task.SpringApplicationContext;

public class SecutiryConstants {

    public static final long EXPIRATION_TIME= 86400000; //10days
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING= "Authorization";
    public static final String SIGN_UP_URL  = "/todo/create";
    public static final String TOKEN_SECRET="jf9i4jgu83nfl0jfu57ejf7";



    public static String getTokenSecret(){
        AppProperties appProperties= (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
