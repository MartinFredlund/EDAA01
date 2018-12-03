package map;

import java.util.Vector;

public class SimpleHashMap<K, V> implements Map {
	Vector<Entry<K,V>> table = new Vector<Entry<K,V>>();

	@Override
	public Object get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object put(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return this.value;
		}
		@Override
		public String toString() {
			return this.key + " = " + this.value; 
		}

	}

}
