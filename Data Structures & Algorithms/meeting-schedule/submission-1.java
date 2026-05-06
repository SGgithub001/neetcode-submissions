class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Start time ke basis par sort karo
        Collections.sort(intervals,
                (a, b) -> a.start - b.start);
        // Adjacent meetings check karo
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);
            // Overlap condition
            if (curr.start < prev.end) {
                return false;
            }
        }
        // Koi overlap nahi mila
        return true;
    }
}