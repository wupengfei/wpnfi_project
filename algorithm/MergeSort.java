package edu.bjtu.sse;

/**
 * 归并排序， 实现分治思想
 * @author wupengfei
 *
 */
public class MergeSort {
	
	/**
	 * 
	 * @param sv1
	 * @param sv2
	 * @param v
	 */
	public void merageSortTwoVec(int[] sv1,int[] sv2,int[] v){
		int i = 0;
		int j = 0;
		int index = 0;
		while(i<sv1.length && j<sv2.length){
			if(sv1[i] <= sv2[j]){
				v[index++] = sv1[i++];
			} else {
				v[index++] = sv2[j++];
			}
		}
		for(;i<sv1.length;){
			v[index++] = sv1[i++];
		}
		for(;j<sv2.length;){
			v[index++] = sv2[j++];
		}
	}
	
	/**
	 * 
	 * @param vector
	 */
	public void mergeSort(int[] vector){
		if(vector.length < 2){
			return ; //子问题足够小时求解
		}
		int mid = vector.length/2; //8 4,4 ; 7 3,4,
		int[] v1 = new int[mid];
		int[] v2 = new int[mid+(vector.length%2)];
		//对原数组进行拆分，化解问题
		for (int i = 0; i < mid; i++) {
			v1[i] = vector[i];
		}
		for(int i=mid,j=0; i<vector.length; i++,j++){
			v2[j] = vector[i];
		}
		
		this.mergeSort(v1);
		this.mergeSort(v2);
		
		this.merageSortTwoVec(v1, v2, vector);
		
	}
	
	
	
	public static void main(String[] args) {
		 int[] test = {
				 5,-7,9,8,1,4,-3,10,2,0
		 };
		 MergeSort ms = new MergeSort();
		 ms.mergeSort(test);
		 for (int i : test) {
			System.out.print(i + "  ");
		}
		
		
	}

}
