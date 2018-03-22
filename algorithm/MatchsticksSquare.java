package edu.bjtu.sse;

import java.util.Arrays;

/**
 * 
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, 
 * please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, 
 * and each matchstick must be used exactly one time.
	Your input will be several matchsticks the girl has, represented with their stick length. 
	Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * @author wupengfei
 *
 */
public class MatchsticksSquare {

	/**
	 * makesquare
	 * @param nums
	 * @return
	 */
    public boolean makesquare(int[] nums) {
    	int sum = 0;
    	if(nums.length < 4){
    		return false;
    	}
    	for (int value : nums) {
			sum += value;
		}
    	if(sum%4 != 0) { 
    		return false;
    	}
    	
    	Arrays.sort(nums);
    	for (int i = 0,j=nums.length-1; i < nums.length/2; i++,j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
    	int[] bucket = new int[4];
        return produce(0,nums,sum/4,bucket);
    }
	
	public boolean produce(int i, int[] nums, int target, int[] bucket) {
		if(i >= nums.length){
			return bucket[0] == target && bucket[1] == target && bucket[2] == target && bucket[3] == target;
		}
		for(int j=0; j<4; j++){
			if(bucket[j]+nums[i] > target){
				continue;
			}
			bucket[j] += nums[i];
			if(produce(i+1,nums,target,bucket)){
				return true;
			}  
			bucket[j] -= nums[i];
		}
		return false;
	}

	public static void main(String[] args) {
		MatchsticksSquare ms = new MatchsticksSquare();
		int[] nums = {
			1,1,2,4,3,2,3
		};
		System.out.println(ms.makesquare(nums));

	}

}
