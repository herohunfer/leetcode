/*
basic binary search algorithm
very complex. has many cases need to think
(1,5) <- (0,0)
(1,5) <- (0,3)
(1,5) <- (0,5)
(0,5)(9,12) <- (7,16)
(1,5)(12,18) <- (6,6)

start
    -> check if it is at the end -> means insert at size() index 
    -> check if left is in previous intervals, 
      -> otherwise wrap next interval.
end -> check if it is before start -> means insert at this position. no overlapping
    -> check if less than 0 -> means insert at 0 index


*/




/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class CustomComparator1 implements Comparator<Interval> {
    @Override
    public int compare (Interval i1, Interval i2) {
        return (i1.start - i2.start);
    }
}
class CustomComparator2 implements Comparator<Interval> {
    @Override
    public int compare (Interval i1, Interval i2) {
        return (i1.start - i2.end);
    }
}

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        int start = Collections.binarySearch(intervals, newInterval, new CustomComparator1());
        int end = Collections.binarySearch(intervals, newInterval, new CustomComparator2());
        if (start < 0) 
        {
            start = -start-1-1; //if still nagative means the start is the new head
            if (start >= 0 && intervals.get(start).end < newInterval.start) start++;
            if (start == intervals.size()) {
                intervals.add(newInterval);
                return intervals;
            }
         }
        if (end < 0) {
            end = -end-1-1;  // previous index, last element before insertion point
            if (end < 0) {
                intervals.add(0, newInterval);
                return intervals;
            }
            if (start > end) {
                intervals.add(start, newInterval);
                return intervals;
            }
        }
         
            
        int right = Math.max(newInterval.end, intervals.get(end).end);
        if (start < 0) {
            start = 0;
            intervals.get(0).start = newInterval.start;
        }
        intervals.get(start).start = Math.min(newInterval.start, intervals.get(start).start);
        intervals.get(start).end = right;
        if (start < end)
            intervals.subList(start+1, end+1).clear();
        
        return intervals;
    }
}
