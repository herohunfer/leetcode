// read instruction carefully.
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        int previous = 0, now = 0, remain = L;
        while (now < words.length) {
            while (now < words.length && 
            ((now == previous && words[now].length() <= remain) ||
            (now > previous && words[now].length()+1 <= remain))) {
                remain -= words[now].length();
                if (now > previous) remain--;
                now++;
            }
            int space = 0;
            if (now-previous == 1) {
                space = remain;
                remain = 0;
            }
            else if (now < words.length) {
                space = remain/(now-previous-1);
                remain = remain % (now-previous-1);
            }
            String s = "";
            for (int i = previous; i < now; i++) {
                s += words[i];
                if (i < now-1 || now-previous == 1) {
                    if (i < now-1) s+=" ";
                    for (int j = 0; j < space; j++)
                        s+=" ";
                    if (now<words.length && remain > 0) {
                        s+=" ";
                        remain--;
                    }
                }
            }
            if (remain > 0) {
                for (int i = 0; i < remain; i++)
                    s+=" ";
            }
            result.add(s);
            previous = now;
            remain = L;
        }
        return result;
    }
}
