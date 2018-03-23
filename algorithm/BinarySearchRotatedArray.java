package edu.bjtu.sse;

/**
 * 给定一个排序数组nums(nums中有无重复元素)，且nums可能以某个未知下标旋转，给定目标值target，求
 * target是否在目标值中出现，若出现返回下标，未出现则返回-1
 * @author wupengfei
 *
 */
public class BinarySearchRotatedArray {
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public int search(int[] nums, int target) {
    	int begin = 0;
    	int end = nums.length-1;
    	while(begin <= end) {
    		int mid = (begin+end)/2;
    		if(target == nums[mid]) {
    			return mid;
    		} else if(target < nums[mid]){ //target 小于中间值
    			if(nums[begin] < nums[mid]) {//begin-mid 为递增区间，mid+1~end 为旋转区间
    				if(target >= nums[begin]){
    					end = mid -1;
    				} else {
    					begin = mid +1;
    				}
    			} else if(nums[begin] > nums[mid]){ //begin-mid 为旋转区间，mid+1~end 为递增区间
    				end = mid -1;
    			} else if(nums[begin] == nums[mid]){
    				begin = mid +1;
    			}
    		} else if(target > nums[mid]){
    			if(nums[begin] < nums[mid]){
    				begin = mid +1;
    			} else if(nums[begin] > nums[mid]){ // target > 中间值, begin-mid 为旋转区间，mid+1~end 为递增区间
    				if(target >= nums[begin]) { //旋转区间的情况下 肯定要小于begin
    					end = mid -1;
    				} else {
    					begin = mid + 1;
    				} 
    			} else if(nums[begin] == nums[mid]){
    					begin = mid + 1;
    			}
    		}
    		
    	}
    	return -1;
    }
    
    
	public static void main(String[] args) {
		//int nums[] = {9, 12, 15, 20, 1, 3, 6, 7};
		int nums[] = {5,1,3};
		BinarySearchRotatedArray bsra = new BinarySearchRotatedArray();
		 System.out.println(   bsra.search(nums, 3));
		
 	/*for (int i = 0; i < 20; i++) {
			System.out.println("i=" + i + "  "  + bsra.search(nums, i));
			
		} */
	}

}
