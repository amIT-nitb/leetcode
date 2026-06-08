/*
 * 621. Task Scheduler  (Medium)
 *
 * Approach: counting + math (no heap needed).
 *   - Let maxFreq = highest task count and tied = #tasks with that max.
 *   - The most-frequent tasks define a skeleton of (maxFreq - 1) full
 *     "frames" of width (n + 1), followed by a final partial row holding
 *     just the `tied` peak tasks.
 *   - Frame layout (n cooldown means each frame has 1 hot slot + n cool slots):
 *
 *       frame 0 : [A . . . ]   <- A is the hot task; '.' = cool slot or idle
 *       frame 1 : [A . . . ]
 *       ...
 *       frame maxFreq-2 : [A . . . ]
 *       last row: [A B C ...]  <- only the tied-peak tasks
 *
 *   - Capacity = (maxFreq - 1) * (n + 1) + tied.
 *   - If total tasks exceed capacity, the schedule has no idles → answer is
 *     tasks.size. Otherwise capacity (with idles baked in) wins.
 *
 * Time: O(N)   Space: O(1)
 */
class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        for (c in tasks) freq[c - 'A']++

        val maxFreq = freq.max()!!  // tasks is non-empty per constraints

        // count tasks tied at the peak — they fill the partial last row
        val tied = freq.count { it == maxFreq }

        val capacity = (maxFreq - 1) * (n + 1) + tied
        // if tasks fit without idles, size wins; else the skeleton wins
        return maxOf(capacity, tasks.size)
    }
}
