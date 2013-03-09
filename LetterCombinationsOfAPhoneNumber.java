public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        char [] digitChars = digits.toCharArray();
        for (char i: digitChars) {
            if (i == '1') continue;
            else if (i == '2') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "a");
                    newR.add(j + "b");
                    newR.add(j + "c");
                }
                result = new ArrayList<String>(newR);
            
            }
            else if (i == '3') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "d");
                    newR.add(j + "e");
                    newR.add(j + "f");
                }
                result = new ArrayList<String>(newR);
        
            }
            else if (i == '4') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "g");
                    newR.add(j + "h");
                    newR.add(j + "i");
                }
                result = new ArrayList<String>(newR);
            
            }
            else if (i == '5') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "j");
                    newR.add(j + "k");
                    newR.add(j + "l");
                }
                result = new ArrayList<String>(newR);
            
            }
            else if (i == '6') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "m");
                    newR.add(j + "n");
                    newR.add(j + "o");
                }
                result = new ArrayList<String>(newR);
            
            }
            else if (i == '7') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "p");
                    newR.add(j + "q");
                    newR.add(j + "r");
                    newR.add(j + "s");
                }
                result = new ArrayList<String>(newR);
            
            }
            else if (i == '8') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "t");
                    newR.add(j + "u");
                    newR.add(j + "v");
                }
                result = new ArrayList<String>(newR);
            
            }
            else if (i == '9') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + "w");
                    newR.add(j + "x");
                    newR.add(j + "y");
                    newR.add(j + "z");
                    
                }
                result = new ArrayList<String>(newR);
            }
            else if (i == '0') {
                ArrayList<String> newR = new ArrayList<String>();
                for (String j: result) {
                    newR.add(j + " ");
                    
                }
                result = new ArrayList<String>(newR);
            }
            else return result;
        }
        return result;
    }
}
