package edu.bjtu.sse;

/**
 * ����һ����������nums(nums�������ظ�Ԫ��)����nums������ĳ��δ֪�±���ת������Ŀ��ֵtarget����
 * target�Ƿ���Ŀ��ֵ�г��֣������ַ����±꣬δ�����򷵻�-1
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
    		} else if(target < nums[mid]){ //target С���м�ֵ
    			if(nums[begin] < nums[mid]) {//begin-mid Ϊ�������䣬mid+1~end Ϊ��ת����
    				if(target >= nums[begin]){
    					end = mid -1;
    				} else {
    					begin = mid +1;
    				}
    			} else if(nums[begin] > nums[mid]){ //begin-mid Ϊ��ת���䣬mid+1~end Ϊ��������
    				end = mid -1;
    			} else if(nums[begin] == nums[mid]){
    				begin = mid +1;
    			}
    		} else if(target > nums[mid]){
    			if(nums[begin] < nums[mid]){
    				begin = mid +1;
    			} else if(nums[begin] > nums[mid]){ // target > �м�ֵ, begin-mid Ϊ��ת���䣬mid+1~end Ϊ��������
    				if(target >= nums[begin]) { //��ת���������� �϶�ҪС��begin
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
