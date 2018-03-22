package edu.bjtu.sse;

/**
 * 给定一个排序数组nums(无重复元素)与目标值target,如果target在nums里出现，则返回target所在下标
 * ，如果target在nums里未出现， 则返回target应该插入的位置的数组下标， 使得target插入数组nums后， 数组仍然有序
 * @author wupengfei
 *
 */
public class BinarySearchInsert {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int begin = 0;
        int end = nums.length - 1;
        while (index == -1){
        	int mid = (begin+end)/2;
        	if(target == nums[mid]){
        		return index = mid;
        	} else if(target < nums[mid]) {
        		if(mid==0 || target>nums[mid-1]){
        			index =  mid;
        		}
        		end = mid-1;
        	} else if(target > nums[mid]){
        		if(mid==nums.length-1 || target<nums[mid+1]){
        			index =  mid+1;
        		}
        		begin = mid + 1;
        	}
        }
    	return index;
    }
    
    
	public static void main(String[] args) {
		BinarySearchInsert bsi = new BinarySearchInsert();
		int[] nums = {
				1,3,5,6
		};
		for (int i = 0; i < 8; i++) {
			System.out.println("i="+i + " index=" + bsi.searchInsert(nums, i));
		}
		 
	}

}
