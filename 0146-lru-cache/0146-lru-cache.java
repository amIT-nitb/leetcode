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
                if(head == null){ // first entry in cache
                    this.head = node;
                    this.tail = node;
                }
                else{ // insert front of head
                    node.next = head;
                    head.prev = node;
                    head = node;
                }    
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
                node.next = head;
                head.prev = node;
                head = node;    
            }
        }
    }
    
    public void updateToHead(Node node){
        if(node == head){
            return;
        }
        else if(node == tail){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
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