package edu.bjtu.sse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 求逆序数，已知数组nums，求新数组count，count[i]代表了在 nums[i]右侧且比nums[i]小的元素个数
 * @author wupengfei
 *
 */
public class NumbersAfterSelf {

	
	/**
	 * 
	 * @param nums
	 * @return
	 */
    public List<Integer> countSmaller(int[] nums) {
    	List<HashMap<Integer,Integer>> vec = new ArrayList<>();
    	List<Integer> count =  new ArrayList<>();
    	int[] counts = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    		hm.put(nums[i], i);
			vec.add(hm);
		}
    	this.mergeSort(vec,counts);
    	for (int i = 0; i < counts.length; i++) {
			count.add(counts[i]);
		}
    	return count;
    }
    /**
	 * 
	 * @param sv1
	 * @param sv2
	 * @param v
	 */
	public void merageSortTwoVec(List<HashMap<Integer,Integer>> vec1,
			List<HashMap<Integer,Integer>> vec2,
			List<HashMap<Integer,Integer>> vector,
			int[] counts){
		int i = 0;
		int j = 0;
		int v1size = vec1.size();
		int v2size = vec2.size();
		while(i<v1size && j<v2size){
			HashMap<Integer,Integer> map1 = vec1.get(i);
			HashMap<Integer,Integer> map2 = vec2.get(j);
			
			Set<Integer> s = map1.keySet();
			Iterator<Integer> iterator = s.iterator();
			Integer mi1 = iterator.next();
			Integer value = map1.get(mi1);
			
			Set<Integer> s2 = map2.keySet();
			Iterator<Integer> iterator2 = s2.iterator();
			Integer mi2 = iterator2.next();
			
			if(mi1 <= mi2){
				counts[value] += j;
				vector.add(map1);
				i++;
			} else {
				vector.add(map2);
				j++;
			}
		}
		for (;i<v1size; i++) {
			HashMap<Integer,Integer> map1 = vec1.get(i);
			Set<Integer> s = map1.keySet();
			Iterator<Integer> iterator = s.iterator();
			Integer mi1 = iterator.next();
			Integer value = map1.get(mi1);
			counts[value] += j;
			vector.add(vec1.get(i));
		}
		for(;j<v2size;j++){
			vector.add(vec2.get(j));
		}
	}
	
	/**
	 * 拆成最小可归并的子单元
	 * @param vector
	 */
	public void mergeSort(List<HashMap<Integer,Integer>> vector,int[] counts){
		if(vector.size() < 2){
			return ; 
		}
		int mid = vector.size()/2; 
		List<HashMap<Integer,Integer>> vec1 = new ArrayList<HashMap<Integer,Integer>>();
		List<HashMap<Integer,Integer>> vec2 = new ArrayList<HashMap<Integer,Integer>>();
		
		for (int i = 0; i < mid; i++) {
			vec1.add(vector.get(i));
		}
		for (int i = mid; i < vector.size(); i++) {
			vec2.add(vector.get(i));
		}
		this.mergeSort(vec1,counts);
		this.mergeSort(vec2,counts);
		vector.clear();
		this.merageSortTwoVec(vec1, vec2, vector,counts);
		
	}
    
	public static void main(String[] args) {
		/*HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(5, 4);
		
		Set<Integer> s = hm.keySet();
		Iterator<Integer> iterator = s.iterator();
		Integer d = iterator.next();*/
		int[] test = {
				5,-7,9,1,3,5,-2,1
		};
		NumbersAfterSelf nas = new NumbersAfterSelf();
		List<Integer>  list = nas.countSmaller(test);
		System.out.println(list.toString());
	}

}
