//hard problem. cannot pass large case.
public class Solution {
   public boolean isMatch(String s, String p) {
       // Start typing your Java solution below
       // DO NOT write main() function
       if (s.equals(p)) return true;
       
       int pos = 0;
       while (pos < s.length() && pos < p.length()) {
           if (s.charAt(pos) == '*') {
               int start = pos;
               while (start < s.length() && s.charAt(start) == '*')
                   start++;
                   
               for (int i = 0; pos+i <= p.length(); i++) {
                   String subS = (start >= s.length())? "":s.substring(start);
                   String subP = (pos+i == p.length())? "":p.substring(i+pos);
                   if (isMatch(subS, subP)) return true;
               }
               return false;
           }
           else if (p.charAt(pos) == '*') {
               int start = pos;
               while (start < p.length() && p.charAt(start) == '*')
                   start++;
                   
               
               for (int i = 0; pos+i <= s.length(); i++) {
                   String subS = (pos+i == s.length())? "":s.substring(i+pos);
                   String subP = (start >= p.length())? "":p.substring(start);
                   if (isMatch(subS, subP)) return true;
               }
               return false;
           }
           else if (s.charAt(pos) == '?' || p.charAt(pos) == '?') {
               pos++;
           }
           else if (s.charAt(pos) == p.charAt(pos)) pos++;
           else return false;
       }
       if (pos == s.length() && pos == p.length()) return true;
       else if (pos == s.length()) {
           while (pos < p.length() && p.charAt(pos) == '*') pos++;
           if (pos == p.length()) return true;
           else return false;
       }
       else {  // pos == p.length()
           while (pos < s.length() && s.charAt(pos) == '*') pos++;
           if (pos == s.length()) return true;
           else return false;
       }
       
   }
}
