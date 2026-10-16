/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    /*

    (0, 3), (3, 6), (5, 10)


    */

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(i + 1);
            if (second.start < first.end) return false;
        }
        return true;
    }
}
