package edu.bjtu.sse.hashmap;

/**
 * 
 * @author Administrator
 *
 */
public interface PerryMap<K,V> {

	public V put(K k,V v);
	
	public V get(K k);
	
	public int size();
	
	public interface Entry<K,V>{
		public K getKey();
		public V getValue();
	}
}
