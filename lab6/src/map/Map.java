package map;
public interface Map<K, V> {
    static interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
    }
    V get(Object arg0);
    boolean isEmpty();
    V put(K arg0, V arg1);
    V remove(Object arg0);
    int size();
}