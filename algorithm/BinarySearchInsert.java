package edu.bjtu.sse;

/**
 * ����һ����������nums(���ظ�Ԫ��)��Ŀ��ֵtarget,���target��nums����֣��򷵻�target�����±�
 * �����target��nums��δ���֣� �򷵻�targetӦ�ò����λ�õ������±꣬ ʹ��target��������nums�� ������Ȼ����
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
