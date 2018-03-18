#include <stdio.h>
#include <iostream.h>
#include <vector>
#include <set>

/*
*已知一个数组（其中有重复元素）， 求这个数组可以组成的所有自己， 结果中无重复的子集 
*/
class Solution{
	public:
		std::vector<std::vector<int> > subsetsWithDup(std::vector<int>& nums){
			std::vector<std::vector<int> >  result;
			std::vector<int>  item;
			std::set<std::vector<int> >  no_res_set;
			
			std::sort(nums.begin(),nums.end());
			result.push_back(item);
			generate(0,nums,result,item,no_res_set);
			return result;
		}
	private:
		void generate(int i,std::vector<int>& nums,std::vector<std::vector<int> > &result,std::vector<int>& item,
			std::set<std::vector<int> > &no_res_set){
				if(i >= nums.size()){
					return ;
				}
				item.push_back(nums[i]);
				if(no_res_set.find(item) == no_res_set.end()){
					result.push_back(item);
					no_res_set.insert(item);
				}
				generate(i+1,nums,result,item,no_res_set);
				item.pop_back();
				generate(i+1,nums,result,item,no_res_set);
			
		}
};


int main(){
	std::vector<int> nums;
	nums.push_back(2);
	nums.push_back(1);
	nums.push_back(2);
	nums.push_back(2);
	Solution solve;
	std::vector<std::vector<int> >  result;
	result = solve.subsetsWithDup(nums);
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

