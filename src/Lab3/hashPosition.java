package Lab3;

class hashPosition<K,V> {
    K Key;
    V Value;
    final int hashCode;
    hashPosition<K,V> next;

    public K getKey() {
        return Key;
    }
    public V getValue() {
        return Value;
    }
    public int getHashCode() {
        return hashCode;
    }

    public hashPosition(K key, V value, int hashCode){
        this.Key = key;
        this.Value = value;
        this.hashCode = hashCode;
    }
}
