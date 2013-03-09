c class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Character> a = new ArrayList<Character>();
        char [] sArray = s.toCharArray();
        for (char i : sArray) {
            if (i == '(' || i == '{' || i == '[')
                a.add(i);
            else if (i == ')') {
                if (a.size() == 0 || a.get(a.size()-1) != '(')
                    return false;
                else a.remove(a.size()-1);
            }
            else if (i == '}') {
                if (a.size() == 0 || a.get(a.size()-1) != '{')
                    return false;
                else a.remove(a.size()-1);
            }
            else if (i == ']') {
                if (a.size() == 0 || a.get(a.size()-1) != '[')
                    return false;
                else a.remove(a.size()-1);
            }
        }
        if (a.isEmpty()) return true;
        else return false;
    }
}
