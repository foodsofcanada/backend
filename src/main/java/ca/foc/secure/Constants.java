package ca.foc.secure;


public class Constants {
    public static transient final String SECRET = "Christian";
    public static transient final long EXPIRATION_TIME = 5 * 60 * 60; // 10 days
    public static transient final String TOKEN_PREFIX = "Bearer ";
    public static transient final String HEADER_STRING = "Authorization";
    public static transient final String SIGN_UP_URL = "/member/signup";
}
