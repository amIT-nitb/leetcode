import java.util.PriorityQueue

/*
 * 218. The Skyline Problem  (Hard)
 *
 * Approach: line-sweep over building edges with a max-heap of active heights.
 *   Encode each building as TWO events with a sign trick on height:
 *     start -> store -h     end -> store +h
 *   Sort events by (x, signedHeight). The tie-break is what makes this work:
 *     - At same x, starts (negative h) come BEFORE ends (positive h) -> two
 *       buildings that touch don't emit a phantom dip to 0.
 *     - Two starts at same x: taller first (more-negative sorts first) -> only
 *       one key-point emitted.
 *     - Two ends at same x: shorter first -> no intermediate emission.
 *
 *   Maintain a max-heap of currently active heights (seeded with 0). On start,
 *   push h; on end, remove h. After each event, if peek() differs from prevMax,
 *   emit (x, peek()).
 *
 *      Skyline = the set of x's where the max active height changes.
 *
 * Time: O(n^2) worst (heap.remove)   Space: O(n)
 */
class Solution {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        val events = mutableListOf<IntArray>()
        for (b in buildings) {
            events.add(intArrayOf(b[0], -b[2]))   // start: negative height
            events.add(intArrayOf(b[1], b[2]))    // end:   positive height
        }
        events.sortWith(Comparator { a, b -> if (a[0] != b[0]) a[0] - b[0] else a[1] - b[1] })

        // max-heap of active heights; seed with 0 = ground level
        val pq = PriorityQueue<Int>(compareByDescending { it })
        pq.offer(0)

        val result = mutableListOf<List<Int>>()
        var prevMax = 0
        for (e in events) {
            if (e[1] < 0) pq.offer(-e[1])   // building start
            else pq.remove(e[1])            // building end (O(n))
            val currMax = pq.peek()
            if (currMax != prevMax) {
                result.add(listOf(e[0], currMax))
                prevMax = currMax
            }
        }
        return result
    }
}
