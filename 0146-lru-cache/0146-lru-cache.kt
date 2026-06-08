/*
 * 146. LRU Cache  (Medium)
 *
 * Approach: HashMap + doubly linked list (DIY, no LinkedHashMap).
 *   HashMap<Int, Node>    -> O(1) lookup
 *   doubly-linked list    -> head = most-recent, tail = least-recent
 *
 *   get(k): hit -> move node to head, return val. miss -> -1.
 *   put(k,v): hit -> update + move to head.
 *             miss -> insert new at head. If full, evict tail (remove from
 *                     both map AND list) before insert.
 *
 *      head <-> n1 <-> n2 <-> ... <-> tail
 *           access n2: unlink + push to head
 *           overflow:  drop tail, push new at head
 *
 *   Doubly-linked because eviction-from-tail and move-from-middle both need
 *   O(1) unlink.
 *
 * Time: O(1) per op   Space: O(capacity)
 */
class LRUCache(private val capacity: Int) {

    private class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val cache = HashMap<Int, Node>()
    private var head: Node? = null
    private var tail: Node? = null

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val existing = cache[key]
        if (existing != null) {
            existing.value = value
            moveToHead(existing)
            return
        }
        if (cache.size == capacity) {
            // evict LRU: drop tail from map and from list
            val lru = tail!!
            cache.remove(lru.key)
            tail = lru.prev
            tail?.next = null
            if (tail == null) head = null    // capacity==1 edge case: list empties
        }
        val node = Node(key, value)
        cache[key] = node
        if (head == null) {
            head = node
            tail = node
        } else {
            node.next = head
            head!!.prev = node
            head = node
        }
    }

    private fun moveToHead(node: Node) {
        if (node === head) return
        if (node === tail) {
            // hoist tail back one step before relocating
            tail = node.prev
            tail?.next = null
        } else {
            // middle: stitch neighbors together
            node.prev?.next = node.next
            node.next?.prev = node.prev
        }
        node.prev = null
        node.next = head
        head?.prev = node
        head = node
    }
}
