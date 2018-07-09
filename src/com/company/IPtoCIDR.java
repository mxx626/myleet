package com.company;
// Bit
import java.util.ArrayList;
import java.util.List;

/**
 * 751. IP to CIDR

 Given a start IP address ip and a number of ips we need to cover n,
 return a representation of the range as a list (of smallest possible
 length) of CIDR blocks.

 A CIDR block is a string consisting of an IP, followed by a slash,
 and then the prefix length. For example: "123.45.67.89/20". That prefix
 length "20" represents the number of common prefix bits in the specified
 range.

 Example 1:
 Input: ip = "255.0.0.7", n = 10
 Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
 Explanation:
 The initial ip address, when converted to binary, looks like this (spaces added for clarity):
 255.0.0.7 -> 11111111 00000000 00000000 00000111
 The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
 ie. just this one address.

 The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
 255.0.0.8 -> 11111111 00000000 00000000 00001000
 Addresses with common prefix of 29 bits are:
 11111111 00000000 00000000 00001000
 11111111 00000000 00000000 00001001
 11111111 00000000 00000000 00001010
 11111111 00000000 00000000 00001011
 11111111 00000000 00000000 00001100
 11111111 00000000 00000000 00001101
 11111111 00000000 00000000 00001110
 11111111 00000000 00000000 00001111

 The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
 ie. just 11111111 00000000 00000000 00010000.

 In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .

 There were other representations, such as:
 ["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
 but our answer was the shortest possible.

 Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
 because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100
 that are outside the specified range.
 Note:
 ip will be a valid IPv4 address.
 Every implied address ip + x (for x < n) will be a valid IPv4 address.
 n will be an integer in the range [1, 1000].

 */
public class IPtoCIDR {
    public List<String> ipToCIDR(String ip, int n) {
        long x=0;
        String[] arr = ip.split("\\.");
        for (String s : arr){
            x = Integer.parseInt(s) + x*256;
        }
        List<String> res = new ArrayList<>();
        while(n>0){
            long step = x & -x;
            while (step > n) step /= 2;
            res.add(longToIP(x, (int)step));
            x += step;
            n -= step;
        }
        return res;
    }
    private String longToIP (long x, int step){
        int[] res = new int[4];
        res[0] = (int)(x & 255); x >>= 8;
        res[1] = (int)(x & 255); x >>= 8;
        res[2] = (int)(x & 255); x >>= 8;
        res[3] = (int) x;
        int len = 33;
        while (step>0){
            len--;
            step /= 2;
        }
        return res[3]+"."+res[2]+"."+res[1]+"."+res[0]+"/"+len;
    }
}
