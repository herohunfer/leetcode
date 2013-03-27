public class Solution {
    public void getArray(ArrayList<ArrayList<String>> result, int current,
                                ArrayList<String> res, ArrayList<ArrayList<Integer>> path, ArrayList<String> que) {
        if (current == -1) {
            result.add(new ArrayList<String>(res));
            return;
        }
        else {
            for (int i: path.get(current)) {
                res.add(0, que.get(current));
                getArray(result, i, res, path, que);
                res.remove(0);
            }
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end,  HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        ArrayList<String> que = new ArrayList<String>();
        int [] step = new int[dict.size()+5];
        HashMap<String, Integer> checkList = new HashMap<String, Integer>();
        if (start.equals(end)) {result.add(new ArrayList(Arrays.asList(new String[] {start, end}))); return result;}
        if (dict.isEmpty()) return result;
        path.add(new ArrayList<Integer>());
        //set sentinel
        path.get(0).add(-1);
        dict.remove(start);
        step[0] = 1;
        checkList.put(start, 0);
        que.add(start);

        int bestStep = -1;
        int currentStep = -1;
        int pos = 0;
        //HashSet<String> dict2 = new HashSet<String>(dict);
        while (pos < que.size()) {
            String now = que.get(pos);
            currentStep = step[pos];
            if (bestStep > 0 && bestStep != currentStep) break;
            f1:
            for (int i = 0; i < now.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == now.charAt(i)) continue;
                    String t = now.substring(0,i)+ c + now.substring(i+1);
                    if (t.equals(end)) {
                        bestStep = currentStep;
                        ArrayList<String> res = new ArrayList<String>();
                        res.add(t);
                        getArray(result, pos, res, path, que);
                        break f1;
                    }
                    else if (dict.contains(t)) {
                        if (!checkList.containsKey(t)) {
                            que.add(t);
                            step[que.size()-1] = currentStep+1;
                            path.add(new ArrayList<Integer>());
                            path.get(path.size()-1).add(pos);
                            checkList.put(t,path.size()-1);
                        }
                        else if (step[checkList.get(t)] == currentStep+1) {
                            path.get(checkList.get(t)).add(pos);
                        }
                    }
                }
            }
            pos++;
            //System.out.println(result+"-----------------------------------\n");

        }
        return result;
    }
}
