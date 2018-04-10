package edu.bjtu.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	Note: Given n will be a positive integer. 
 * @author wupengfei
 *
 */
public class ClimbingStairs {

	/**
	 * 	
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
        int[] dp = new int[(n<3?3:n)+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n ; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
    	return dp[n];
    }
    
    
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs(4));
		
	}

}
