// Good example of implementing Comparator.
// ArrayList manipulation is always more complex than simple integer manipulation.
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class CustomComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return (o1.start-o2.start);
    }
}

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals.isEmpty()) return result;
        Collections.sort(intervals, new CustomComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval i : intervals) {
            if (end < i.start) {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
            else end = Math.max(i.end, end);
        }
        result.add(new Interval(start, end));
        
        return result;
    }
}
