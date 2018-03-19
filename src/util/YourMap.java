package util;

public class YourMap<K, V> {

	private Entry<K, V>[] table;
	
	private int size;
	
	private int length;
	
	static final Entry<?, ?>[] EMPTY_TAB = {};
	
	public YourMap() {
		table = (Entry<K, V>[]) EMPTY_TAB;
	}

	public void put(K key, V value) {
		if (table == EMPTY_TAB) {
			initTab(16);
		}
		
		int hashCode = key.hashCode();
		int i = getItem(hashCode);
		
		if (table[i] == null) {
			Entry newEntry = new Entry(key, value, hashCode, null);
			table[i] = newEntry;
			size++;
		} else {
			Entry oldEntry = table[i];
			table[i] = new Entry(key, value, hashCode, oldEntry);
			size++;
		}
	}
	
	public V get(K key) {
		int hashCode = key.hashCode();
		int i = getItem(hashCode);
//		Entry<K, V> entry = table[i];
//		if (entry == null) {
//			return null;
//		}
		
		for (Entry<K, V> entry = table[i]; entry!=null; entry = entry.next) {
			if (hashCode == entry.getHashCode()) {
				return entry.getV();
			}
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * 初始化表格
	 */
	private void initTab(int size) {
		table = new Entry[size]; //为何这样可以
		length = size;
	}
	
	private int getItem(int hashCode) {
		return 1;
	}
	
	static class Entry<K, V> {
		private K k;
		private V v;
		private int hashCode;
		private Entry<K, V> next;
		
		public Entry(K k, V v, int hashCode, Entry<K, V> next) {
			super();
			this.k = k;
			this.v = v;
			this.hashCode = hashCode;
			this.next = next;
		}
		
		public K getK() {
			return k;
		}
		public void setK(K k) {
			this.k = k;
		}
		public V getV() {
			return v;
		}
		public void setV(V v) {
			this.v = v;
		}
		public int getHashCode() {
			return hashCode;
		}
		public void setHashCode(int hashCode) {
			this.hashCode = hashCode;
		}
		public Entry<K, V> getNext() {
			return next;
		}
		public void setNext(Entry<K, V> next) {
			this.next = next;
		}
		
		
		
	}
}
