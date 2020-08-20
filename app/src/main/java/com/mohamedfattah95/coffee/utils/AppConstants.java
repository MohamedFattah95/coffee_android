

package com.mohamedfattah95.coffee.utils;


public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String ITEMS_LIMIT = String.valueOf(30);
    public static final String STATUS_CODE_FAILED = "failed";
    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    public static final String DB_NAME = "mindorks_mvp.db";
    public static final String PREF_NAME = "mindorks_pref";
    public static final long NULL_INDEX = -1L;
    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
    public static final String TOKEN_PARAM_CONTENT_TYPE = "Content-Type";
    public static String APP_LANGUAGE = "en";

    public static final String TOKEN_PARAM_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PARAM_BEARER = "Bearer ";
    public static final String TOKEN_PARAM_ACCEPT = "Accept";
    public static final String TOKEN_PARAM_LANGUAGE = "lang";
    public static final String TOKEN_PARAM_APPLICATION_JSON = "application/json";
    public static final String TOKEN_PARAM_FORM_URL_ENCODED = "application/json";




    public enum UsersType {

        Retailer("Retailer"),
        Wholesale_seller("Wholesaler");


        private final String mType;

        UsersType(String type) {
            mType = type;
        }

        public String getType() {
            return mType;
        }


    }


    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
