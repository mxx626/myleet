package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    /**
     * TinyURL is a URL shortening service where you enter a URL such as
     * https://leetcode.com/problems/design-tinyurl and it returns a short
     * URL such as http://tinyurl.com/4e9iAk.
     * Design the encode and decode methods for the TinyURL service. There
     * is no restriction on how your encode/decode algorithm should work.
     * You just need to ensure that a URL can be encoded to a tiny URL and
     * the tiny URL can be decoded to the original URL.
     */
    // Encodes a URL to a shortened URL.
    private Map<String, String> HashToUrl = new HashMap<>();
    private Map<String, String> UrlToHash = new HashMap<>();
    private String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private String baseUrl = "http://www.tinyurl.com/";
    private Random random = new Random();
    public String encode(String longUrl) {
        if (UrlToHash.containsKey(longUrl)){
            return UrlToHash.get(longUrl);
        }
        StringBuilder hash = new StringBuilder();
        do{
            hash = new StringBuilder();
            for (int i=0; i<6; ++i){
                hash.append(characters.charAt(random.nextInt(characters.length())));
            }
        }while(HashToUrl.containsKey(hash.toString()));
        UrlToHash.put(longUrl, hash.toString());
        HashToUrl.put(hash.toString(), longUrl);
        return baseUrl+hash.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return HashToUrl.get(shortUrl.substring(baseUrl.length()));
    }
}
