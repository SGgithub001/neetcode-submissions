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
        Map<Integer, Integer> map = new HashMap<>();
        // build events
        for (Interval in : intervals) {
            map.put(in.start, map.getOrDefault(in.start, 0) + 1);
            map.put(in.end, map.getOrDefault(in.end, 0) - 1);
        }
        // sort time points
        List<Integer> times = new ArrayList<>(map.keySet());
        Collections.sort(times);
        // sweep
        int curr = 0;
        int max = 0;
        for (int t : times) {
            curr += map.get(t);
            max = Math.max(max, curr);
        }
        return max;
    }
}
