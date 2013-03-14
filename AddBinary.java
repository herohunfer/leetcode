import java.math.BigInteger;
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        BigInteger i = new BigInteger(a, 2);
        BigInteger j = new BigInteger(b, 2);
        return i.add(j).toString(2);
    }
}
