package Lab3;
import java.util.ArrayList;
import java.util.Objects;

public class HashTableImprove<K,V> {
    private ArrayList<hashPosition<K,V>> bucketArray;
    private int numBucket;
    private int size;
    public HashTableImprove(){
        bucketArray = new ArrayList<>();
        this.numBucket = 10;
        this.size = 0;
        for (int i = 0; i < numBucket; i++) {
            bucketArray.add(null);
        }
    }
    public int size(){ return this.size;}
    public boolean isEmpty(){return size==0;}

    private final int hashPosition (K key){return Objects.hashCode(key);}

    private int getBucketIndex(K key){
        int hashPosition = hashPosition(key);
        int pos = hashPosition % numBucket;
        pos = pos < 0 ? pos * (-1): pos;
        return pos;
    }
    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        int hashPosition = hashPosition(key);
        hashPosition<K,V> head = bucketArray.get(bucketIndex);
        hashPosition<K,V> prev = null;
        while (head != null){
            if (head.Key.equals(key) && hashPosition == head.hashCode){break;}
            prev = head;
            head = head.next;
        }
        if(head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);
        return head.Value;
    }
    public V get(K key)
    {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashPosition(key);

        hashPosition<K,V> head = bucketArray.get(bucketIndex);
        while (head != null){
            if (head.Key.equals(key) && head.hashCode == hashCode)
                return head.Value;
            head = head.next;
        }
        return null;
    }
    public void add(K key, V value){
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashPosition(key);
        hashPosition<K, V> head = bucketArray.get(bucketIndex);
        while (head != null){
            if (head.Key.equals(key) && head.hashCode == hashCode){head.Value = value; return;}
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        hashPosition<K,V> newNode = new hashPosition<K, V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex,newNode);
        if((1.0 * size)/ numBucket >= 0.7){
            ArrayList<hashPosition<K,V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBucket = 2 * numBucket;
            size = 0;
            for (int i = 0; i < numBucket; i++) {
                bucketArray.add(null);
            }
            for (hashPosition<K,V> headNode : temp){
                while (headNode != null){
                    add(headNode.Key, headNode.Value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
