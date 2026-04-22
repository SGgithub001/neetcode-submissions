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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval meeting : intervals) {
            if (!heap.isEmpty() && heap.peek() <= meeting.start) {
                heap.poll();
            }
            heap.add(meeting.end);
        }
        return heap.size();
    }
}
