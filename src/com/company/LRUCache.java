package com.company;
// Design
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should
     * support the following operations: get and put.

     get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     put(key, value) - Set or insert the value if the key is not already present. When the
     cache reached its capacity, it should invalidate the least recently used item before
     inserting a new item.

     Follow up:
     Could you do both operations in O(1) time complexity?

     Example:

     LRUCache cache = new LRUCache( 2 )
     **/
    private Map<Integer, Item> map = null;
    private int capacity = 0;
    private Item head = null;
    private Item tail = null;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new Item(0, 0);
        this.tail = new Item(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        moveToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        Item entry = map.get(key);
        if (entry == null ){
            entry = new Item(key, value);
            if (this.map.size() == this.capacity){
                Item end = tail.prev;
                Item endPre = end.prev;
                this.map.remove(end.key);
                endPre.next = entry;
                entry.prev = endPre;
                entry.next = tail;
                tail.prev = entry;
            }
            map.put(key, entry);
        }
        else {
            entry.value = value;
        }
        moveToHead(entry);
    }
    public void moveToHead(Item item){
        Item begin = head.next;
        if (begin.equals(item) || item==null) return;
        Item pre = item.prev;
        Item nex = item.next;
        if (nex!=null){
            nex.prev=pre;
        }
        if (pre!=null){
            pre.next = nex;
        }
        this.head.next = item;
        item.next = begin;
        item.prev = this.head;
        begin.prev = item;
    }
    class Item {
        private int key = 0;
        private int value = 0;
        private Item prev;
        private Item next;
        public Item(int key, int value){
            this.key = key;
            this.value = value;
        }
        @Override
        public int hashCode(){
            return Objects.hash(this.key);
        }
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o==null || this.getClass() != o.getClass()) return false;
            Item other = (Item)o;
            return Objects.equals(this.key, other.key);
        }
    }
}
