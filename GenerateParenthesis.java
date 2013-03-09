public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        generate(result, "", n, 0);
        return result;
    }
    public void generate(ArrayList<String> result, String s, int left, int c) {
        if (left == 0) {
            String temp = s;
            while (c>0) { temp+=")"; c--;}
            result.add(temp);
            return;
        }
        else generate(result, s+"(", left-1, c+1);
        if (c > 0) generate(result, s+")", left, c-1);
    }
}
