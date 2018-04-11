package edu.bjtu.dp;

/**
 * 53. Maximum Subarray
 * @author wupengfei
 *
 */
public class MaximumSubarray {

	/**
	 * 
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			if(dp[i] > max){
				max = dp[i];
			}
		}
    	return max;
    }
    
	public static void main(String[] args) {
		int[] nums = {
			-2,1,-3,4,-1,2,1,-5,4
		};
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(nums));
		
	}

}
