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

    record Point(int time, boolean start) {}

    public int minMeetingRooms(List<Interval> intervals) {
        List<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        Collections.sort(points, (a, b) -> {
            if (a.time == b.time) {
                if (a.start == b.start) return 0;
                return a.start ? 1 : -1;
            }
            else return a.time - b.time;
        });

        int max = 0;
        int count = 0;
        for (Point point : points) {
            count += (point.start ? 1 : -1);
            max = Math.max(max, count);
        }
        
        return max;
    }
}
