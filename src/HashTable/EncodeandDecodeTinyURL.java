package HashTable;
// TAG: HashTable, Design
import java.util.HashMap;
import java.util.Random;

public class EncodeandDecodeTinyURL {
    /**
     * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
     * and it returns a short URL such as http://tinyurl.com/4e9iAk.

     Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
     algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
     decoded to the original URL.
     */
    private HashMap<String, String> longToShort = new HashMap<>();
    private HashMap<String, String> shortToLong = new HashMap<>();
    private static final String BASE = "http://tinyurl.com/";
    private static final String SET  = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) return BASE+longToShort.get(longUrl);
        String key = "";
        do {
            StringBuilder sb = new StringBuilder();
            Random r = new Random();
            for (int i=0; i<6; i++){
                sb.append(SET.charAt(r.nextInt(SET.length())));
            }
            key=sb.toString();

        } while (shortToLong.containsKey(key));

        longToShort.put(longUrl, key);
        shortToLong.put(key, longUrl);
        return BASE+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE, "");
        if (!shortToLong.containsKey(key)) return "";
        return shortToLong.get(key);
    }
}
