package ca.foc.secure;

/**
 * Constants - ca.foc.secure.Constants
 * ============ THIS FILE IS CONFIDENTIAL. IT MUST REMAIN PRIVATE AND MUST BE KEPT OFF PUBLIC. ===================
 * ============ IF THIS BECOMES PUBLIC OR FOR CONCERNS, CONTACT foodsofcanada@gmail.com ===================
 */
public class Constants {
    public static transient final String SECRET = "Christian";
    public static transient final long EXPIRATION_TIME = 1_210_000_000; // 10 days
    public static transient final String TOKEN_PREFIX = "Bearer ";
    public static transient final String HEADER_STRING = "Authorization";
    public static transient final String SIGN_UP_URL = "/member/signup";
}
