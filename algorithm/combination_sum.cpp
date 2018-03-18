#include <stdio.h>
#include <iostream.h>
#include <vector>
#include <set>

/*
 *已知一个数组（其中有重复元素）， 求这个数组可以组成的所有子集，子集中各个元素的和为整数target的子集， 结果中无重复子集 
 
	在回溯过程中 进行剪枝操作 
*/
class Solution{
	public:
		std::vector<std::vector<int> > combinationSum2(
										std::vector<int>& candidates,
								 		int target){
	        std::vector<std::vector<int> > result;
	    	std::vector<int> item;
	    	std::set<std::vector<int> > res_set;
	    	std::sort(candidates.begin(),candidates.end());
	    	 
			recurse(0, candidates, result, item, res_set, 0, target);
			
			return result;						 								 			
		 }
	 private:
	 	void recurse(int i, std::vector<int>& nums,
					std::vector<std::vector<int> > &result,
					std::vector<int> &item,
					std::set<std::vector<int> > &res_set,
					int sum, int target){
	 		
	 		if(i>=nums.size() || sum>target){ //剪枝操作， 如果有大于target的 则不用去递归了 
		 		return ;
		 	}
		 	sum += nums[i];
		 	item.push_back(nums[i]);
		 	if(target == sum && res_set.find(item)==res_set.end()){ //等与target时添加 result
	 			result.push_back(item);
	 			res_set.insert(item);
	 		}
	 		recurse(i + 1, nums, result, item, res_set, sum, target);
	 		sum -= nums[i]; // 回溯后， sum将nums[i]减去并从item清除 
	 		item.pop_back();
	 		recurse(i + 1, nums, result, item, res_set, sum, target);	 		
	 	}
	 
};

/*
*/
int main(){
	std::vector<int> nums;
	nums.push_back(10);
	nums.push_back(1);
	nums.push_back(2);
	nums.push_back(7);
	nums.push_back(6);
	nums.push_back(1);
	nums.push_back(5);
	std::vector<std::vector<int> > result;
	Solution solve;
	result = solve.combinationSum2(nums, 8);
	for (int i = 0; i < result.size(); i++){
		cout<<"["; 
		for (int j = 0; j < result[i].size(); j++){
			cout<<result[i][j];
		}
		cout<<"]";
		cout<<endl; 	
	}	
	return 0;
}