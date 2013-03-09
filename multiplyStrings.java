//easy in Java. without bigInteger then may do it normal way :D
import java.math.BigInteger;
public class Solution {
   public String multiply(String num1, String num2) {
       // Start typing your Java solution below
       // DO NOT write main() function
       BigInteger a =  new BigInteger(num1);
       BigInteger b = new BigInteger(num2);
       a = a.multiply(b);
       return a.toString();
   }
}
