package map;

import java.util.Random;

public class OldSimpleHashMap<K, V> implements Map {
	Entry<K, V>[] table;

	/**
	 * Constructs an empty hashmap with the default initial capacity (16) and the
	 * default load factor (0.75).
	 */
	public OldSimpleHashMap() {
		table = (Entry<K, V>[]) new Entry[16];
	}

	/**
	 * Constructs an empty hashmap with the specified initial capacity and the
	 * default load factor (0.75).
	 */
	public OldSimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[capacity];
	}

	public static void main(String[] args) {
		Random rand = new Random();
		OldSimpleHashMap<Integer, Integer> test = new OldSimpleHashMap(10);
		 for (int i = 0; i < 40; i++) {
		 int rndNumb = rand.nextInt(20) - 8;
		 int rndNumb1 = rand.nextInt(20) -8;
		 test.put(rndNumb, rndNumb1);
		 }
		test.put(1, 1);
		test.put(17, 17);
		System.out.println(test.show());
		System.out.println(test.table.length);
		System.out.println(test.countElements());
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				sb.append(i + "   " + table[i].toString());
				Entry<K, V> temp = table[i];
				while (temp.next != null) {
					sb.append(" " + temp.getNext().toString());
					temp = temp.getNext();
				}
				sb.append("\n");
			} else {
				sb.append(i + "   null\n");
			}
		}
		return sb.toString();
	}

	@Override
	public Object get(Object key) {
		Entry<K, V> entry = find(index((K) key), (K) key);
		if (entry != null) {
			Entry<K, V> temp = entry;
			while (temp.next != null) {
				temp = temp.getNext();
			}
			return temp.getValue();
		}

		return null;
	}

	@Override
	public boolean isEmpty() {
		return countElements() == 0;
	}

	@Override
	public Object put(Object key, Object value) {
		int index = index((K) key);

		int endPoint = table.length - index;
		for (int i = 0; i < endPoint; i++) {
			Entry<K, V> entry = find(index + i, (K) key);
			if (entry != null && entry.getKey().equals(key)) {

				Entry<K, V> temp = entry;
				while (temp.next != null) {
					temp = temp.getNext();
				}
				V tempV = temp.getValue();
				temp.setNext(new Entry<K, V>((K) key, (V) value));

				return tempV;
			}

			else if (table[index + i] == null) {

				table[index + i] = new Entry<K, V>((K) key, (V) value);
				if (countElements() >= 0.75 * table.length) {
					rehash();
				}
				return null;
			}

			if (i == (table.length - index - 1)) {
				i = -index;
				endPoint = Math.min(index, table.length - index);
			}
		}

		show();
		return null;
	}

	@Override
	public Object remove(Object key) {
		if (!isEmpty()) {
			int index = index((K) key);
			if (table[index] != null && table[index].key.equals(key)) {
				V temp = table[index].getValue();
				table[index] = null;
				return temp;
			}

		}
		return null;
	}

	@Override
	public int size() {
		return countElements();
	}

	private int countElements() {
		int temp = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				temp++;
			}
		}
		return temp;
	}

	private void rehash() {
		Entry<K, V>[] tempTable = (Entry<K, V>[]) new Entry[table.length * 2];
		for (int i = 0; i < table.length; i++) {
			tempTable[i] = table[i];
		}
		table = tempTable;
	}

	private int index(K key) {
		return Math.abs(key.hashCode() % table.length);
	}

	private Entry<K, V> find(int index, K key) {
		int indexTemp = index;
		while (indexTemp < table.length && table[indexTemp] != null) {
			if (key.equals(table[indexTemp].getKey())) {
				return table[indexTemp];

			}
			indexTemp++;
		}
		return null;

	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public Entry<K, V> setNext(Entry<K, V> next) {
			this.next = next;
			return this.next;
		}

		public Entry<K, V> getNext() {
			return next;
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
