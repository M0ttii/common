package m0ttii.com.github.common.utils;

import java.security.SecureRandom;

public class RandomString {
    public static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public String generateString(SecureRandom secureRandom, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = SOURCES.charAt(secureRandom.nextInt(SOURCES.length()));
        }
        return new String(text);
    }
}
