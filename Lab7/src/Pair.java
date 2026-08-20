public class Pair<K,V> {
    private K key = null;
    private V value = null;

    public Pair(K param1, V param2){
        this.key = param1;
        this.value = param2;
    }
    public void setKey(K param) {
        this.key = param;
    }
    public void setValue(V param) {
        this.value = param;
    }
    public K getKey(){
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
}
