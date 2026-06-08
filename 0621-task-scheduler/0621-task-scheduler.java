/*
 * 621. Task Scheduler  (Medium)
 *
 * Approach: counting + math (no heap needed).
 *   - Let max_freq = highest task count and tied = #tasks with that max.
 *   - The most-frequent tasks define a skeleton of (max_freq - 1) full
 *     "frames" of width (n + 1), followed by a final partial row holding
 *     just the `tied` peak tasks.
 *   - Frame layout (n cooldown means each frame has 1 hot slot + n cool slots):
 *
 *       frame 0 : [A . . . ]   <- A is the hot task; '.' = cool slot or idle
 *       frame 1 : [A . . . ]
 *       ...
 *       frame max_freq-2 : [A . . . ]
 *       last row: [A B C ...]   <- only the tied-peak tasks
 *
 *   - Capacity = (max_freq - 1) * (n + 1) + tied.
 *   - If we have more total tasks than that capacity, the schedule has no
 *     idle gaps and answer is just tasks.length. Otherwise capacity wins.
 *
 * Why this beats a PriorityQueue simulation: O(n) vs O(N log 26), and the
 * formula is the closed form the simulation would converge to anyway.
 *
 * Time: O(N)   Space: O(1)   (fixed 26-letter count array)
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        int maxFreq = 0;
        for (int f : freq) if (f > maxFreq) maxFreq = f;

        // count tasks tied at the peak — they fill the partial last row
        int tied = 0;
        for (int f : freq) if (f == maxFreq) tied++;

        int capacity = (maxFreq - 1) * (n + 1) + tied;
        // if tasks fit without idles, length wins; else the skeleton (with idles) wins
        return Math.max(capacity, tasks.length);
    }
}
