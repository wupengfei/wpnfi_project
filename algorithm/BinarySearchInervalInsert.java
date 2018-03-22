package edu.bjtu.sse;

/**
 * ����һ����������nums(nums�����ظ�Ԫ��)��Ŀ��ֵtarget�����target��nums����֣��򷵻�target������������Ҷ˵��±꣬[��˵㣬�Ҷ˵�]�����target��nums��δ����
 * ���򷵻�[-1,-1]
 * @author wupengfei
 *
 */
public class BinarySearchInervalInsert {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] searchRange(int[] nums, int target) {
    	int[] result = new int[2];
    	result[0] = this.leftBoud(nums, target);
    	result[1] = this.rightBoud(nums, target);
    	return result;
    }
    
    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public int leftBoud(int[] nums,int target){
    	int begin = 0;
    	int end = nums.length - 1;
    	while(begin <= end){
    		int mid = (begin+end)/2;
    		if(target == nums[mid]){ //���ظ���Ԫ��ҲҪ��������  ֻҪmid������˵�λ��
    			if(mid==0 || target>nums[mid-1]){
    				return mid;
    			}
    			end = mid - 1;
    		} else if(target < nums[mid]) {
    			end = mid -1;
    		} else if(target > nums[mid]){
    			
    			begin = mid + 1;
    		}
    	}
    	return -1;
    }
    
    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public int rightBoud(int[] nums,int target) {
    	int begin = 0;
    	int end = nums.length - 1;
    	while(begin <= end){
    		int mid = (begin+end)/2;
    		if(target == nums[mid]){
    			if(mid == nums.length-1 || target<nums[mid+1]){
    				return mid;
    			} 
    			begin = mid + 1;
    		} else if(target < nums[mid]){
    			end = mid -1;
    		} else if(target > nums[mid]){
    			begin = mid + 1;
    		}
    	}
    	return -1;
    }
	
	public static void main(String[] args) {
		BinarySearchInervalInsert bsii = new BinarySearchInervalInsert();
		int[]  nums = {
				2,2
		};
		int[] result = bsii.searchRange(nums, 2);
		System.out.println(" left=" + result[0] + " right=" + result[1]);
		
		/*int nums[] = {5, 7, 7, 8, 8, 8, 8, 10};
		for (int i = 0; i < 12; i++) {
			int[] result = bsii.searchRange(nums, i);
			int left = bsii.leftBoud(nums, i);
			int right = bsii.rightBoud(nums, i);
			System.out.println("i="+i + " left=" + result[0] + " right=" + result[1]);
		}*/
		
	}

}
