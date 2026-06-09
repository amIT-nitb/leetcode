/*
 * 146. LRU Cache  (Medium)
 *
 * Approach: HashMap + doubly linked list (DIY, no LinkedHashMap).
 *   - HashMap<key, Node> -> O(1) lookup of any node by key.
 *   - Doubly-linked list ordered by recency: head = most-recent, tail = least-recent.
 *   - get(key):  if hit, move node to head; return val. miss -> -1.
 *   - put(key,v): if hit, update val + move to head.
 *                 else create node, insert at head. If at capacity, evict tail
 *                 (remove from map AND from list) before inserting.
 *
 *   Doubly-linked is required because eviction-from-tail and move-from-middle
 *   both need O(1) unlink, which a singly-linked list can't give without an
 *   extra hop.
 *
 *      head <-> n1 <-> n2 <-> ... <-> tail        (most recent ... least recent)
 *           access n2  ->  unlink n2, push at head
 *           overflow   ->  drop tail, push new at head
 *
 *   Edge cases the code handles:
 *     - capacity == 1: when evicting, tail.prev is null; new node becomes both
 *       head and tail.
 *     - first insertion: head and tail both null until the first put creates
 *       a node, then both point to it.
 *
 * Time: O(1) per get/put   Space: O(capacity)
 */
class LRUCache {

   int capacity;
   int size;
   Node head;
   Node tail;
   HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
      cache = new HashMap<>();
      this.capacity = capacity;
      this.size = 0;
      this.head = null;
      this.tail = null;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node =cache.get(key);
            updateToHead(node);
            return node.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
            if(cache.containsKey(key)){ // update value at cache
             Node node = cache.get(key);
             node.val = value;
             updateToHead(node);
        }
        else{ // new addition to cache
            Node node = new Node(key,value);
            cache.put(key, node);
            if(size<capacity){ // this might be optimized   
                size++;
            }
            else{ //at capacity need to evict
                    cache.remove(tail.key);
                    if(tail.prev == null){ // capacity is 1 
                        tail = node;
                        head = node;
                    }
                    else{ 
                        tail.prev.next =null;
                        tail = tail.prev;
                    }
            }           
            if(head == null){ // first entry in cache
                    this.head = node;
                    this.tail = node;
                }
            else{ // insert front of head
                    node.next = head;
                    head.prev = node;
                    head = node;
                } 
        }
    }
    
    public void updateToHead(Node node){
        // already most-recent: nothing to do
        if(node == head){
            return;
        }
        // unlinking the tail: hoist tail back one step
        else if(node == tail){
            tail = tail.prev;
            tail.next = null;
        }
        // middle of list: stitch neighbors together to remove `node`
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
            // re-attach `node` at the head
            node.next = head;
            head.prev = node;
            head = node;
            node.prev = null;
    }
    
    class Node {
       int key;
       int val;
       Node prev;
       Node next;
   
       public Node(int key, int val) {
           this.key = key;
           this.val = val;
       }
   }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */