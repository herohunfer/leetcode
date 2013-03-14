public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String [] a = path.split("/");
        ArrayList<String> result = new ArrayList<String>();
        for (String s: a) {
            if (s.equals(".") || s.equals("")) continue;
            else if (s.equals(".."))
                    if (!result.isEmpty()) result.remove(result.size()-1);
                    else continue;
                 else result.add(s);
        }
        String output = "";
        for (String s: result) {
            output += "/" + s;
        }
        if (output.length() == 0) return "/";
        else return output;
    }
}
