package edu.bjtu.dp;

import java.util.Arrays;

/**
 * 
 * @author wupengfei
 *
 */
public class HouseRobber {

	/**
	 * 
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) { //找出原问题与子问题
    	if(nums.length == 0){
    		return 0;
    	}
    	if(nums.length == 1){
    		return nums[0];
    	}
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];// 找出边界状态，
    	dp[1] = Integer.max(nums[0], nums[1]);
    	int numsLength = nums.length;
    	for (int i = 2; i < numsLength; i++) { // ，确认状态，  状态转移方程
			dp[i] = Integer.max(dp[i-1], dp[i-2]+nums[i]);
		}
    	return dp[numsLength-1];
    }
    
	public static void main(String[] args) {
		int[] nums = {
				5,2,6,3,1,7
		};
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(nums));
		
	}

}
