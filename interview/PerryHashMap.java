package edu.bjtu.sse.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义HashMap 对象
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class PerryHashMap<K,V> implements PerryMap<K, V> {

	private static int defaultLength = 1<<4 ;
	
	//装载因子
	private static double defaultLoader = 0.75;
	
	private Entry<K,V>[] table = null;
	
	private static int testCount = 0;
	
	public PerryHashMap(int length,double loader) {
		super();
		defaultLength = length;
		defaultLoader = loader;
		table = new Entry[defaultLength];
	}
	 
	public PerryHashMap() {
		this(defaultLength, defaultLoader);
	}

	//数组存储元素个数
	private int size = 0;
	
	@Override
	public V put(K k, V v) {
		
		if(size >= this.defaultLength*this.defaultLoader){
			upToSize();
		}
		
		int index = this.getIndex(k);
		Entry<K, V> entry = table[index];
		if(entry == null){
			table[index] =  newEntry(k, v, entry);
			size ++;
		} else {
			//链表存储
			while(entry.next != null) {
				entry = entry.next;
			}
			entry.next = newEntry(k, v, null);
			size ++;
		}
		/*if(entry == null) {
			size ++;
		}
		table[index] = newEntry(k, v, entry);*/
		return table[index].getValue() ;
	}
	
	/**
	 * 扩容方法，每次扩容一倍
	 * 扩容后， 把旧表中的数据再次Hash(非常耗费时间)
	 * 
	 */
	private void upToSize() {
		Entry<K,V>[] newTable  = new Entry[2*this.defaultLength];
		reHash(newTable);
	}
	
	private void reHash(Entry<K,V>[] newTable) {
		List<Entry<K,V>> list = new ArrayList<Entry<K,V>>();
		
		for (Entry<K, V> entry : table) {
			if(entry == null){//数组中有可能为空
				continue;
			}
			findEntryByNext(entry, list);
		}
		//再次Hash
		if(list.size() > 0){
			defaultLength = defaultLength*2;
			size = 0;
			table = newTable;
		}
		for (Entry<K, V> entry : list) {
			if(entry.next != null){
				entry.next = null;
			}
			this.put(entry.getKey(), entry.getValue());
		}
	}
	
	private void findEntryByNext(Entry<K,V> entry,List<Entry<K,V>> list){
		if(entry != null && entry.next != null){
			list.add(entry);
			this.findEntryByNext(entry.next, list);
		} else {
			list.add(entry);
		}
	}
	
	
	private Entry<K,V> newEntry(K k,V v,Entry<K,V> next){
		return new Entry(k,v,next);
	}

	@Override
	public V get(K k) {
		int index = this.getIndex(k);
		if(table[index] == null){
			return null;
		}
		Entry<K,V> entry = table[index];
		while(entry != null) {
			
			if(k.equals(entry.getKey()) || k==entry.getKey()){
				break;
			} else {
			//	System.out.println("-------------get Hash collision-----------------");
				entry = entry.next;
			}
		}
		return entry==null?null:entry.v;
	}
	
	/**
	 * 
	 * @param k
	 * @return
	 */
	private int getIndex(K k){
		int m = defaultLength;
		//有可能是负数
		int index = k.hashCode() % m;
		return index >= 0?index:-index;
	}

	@Override
	public int size() {
		System.out.println("table.length=" + table.length);
		return size;
	}
	
	class Entry<K,V> implements PerryMap.Entry<K, V>{

		K k;
		V v;
		Entry<K,V> next;
		
		
		/*
		 * 构造函数
		 */
		public Entry(K k, V v, Entry<K, V> next) {
			super();
			this.k = k;
			this.v = v;
			this.next = next;
		}

		@Override
		public K getKey() {
			return this.k;
		}

		@Override
		public V getValue() {
			return this.v;
		}
		
	}
	

	
}
