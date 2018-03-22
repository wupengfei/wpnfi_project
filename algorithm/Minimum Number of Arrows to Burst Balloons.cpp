#include <iostream.h> 
#include <algorithm>
#include <vector>

bool cmp(const std::pair<int,int> &a,const std::pair<int,int> &b)
{
	return a.first< b.first; // 没有必要考虑左端点相同的情况 
}

class Solution{
	public:
		int findMinArrowShosts(std::vector<std::pair<int,int> > points){
			if(points.size() == 0){
				return 0;
			}
			std::sort(points.begin(),points.end(),cmp); //对气球按照左端点从小到大排序 
			int shoot_num = 1;
			int shoot_begin = points[0].first; //初始化射击区间 
			int shoot_end = points[0].second;
			std::vector<std::pair<int,int> > direct;
			
			for(int i=1; i<points.size(); i++){
				if(shoot_end >= points[i].first){
					shoot_begin = points[i].first;
					
					if(shoot_end > points[i].second) {
						shoot_end = points[i].second;
					}
					cout<<"["<<shoot_begin<<"-"<<shoot_end<<"]"<<endl;
				} else { // 添加射击区间 
					shoot_num ++;
					shoot_begin = points[i].first;
					shoot_end = points[i].second;
				}
			}
			return shoot_num;
		}
};
/*
主方法 
*/
int main()
{
	std::vector<std::pair<int,int> > points;
	points.push_back(std::make_pair(10,16));
	points.push_back(std::make_pair(2,8));
	points.push_back(std::make_pair(1,6));
	points.push_back(std::make_pair(7,12));
	
	Solution solve;
	cout<<"射击区间的个数为:"<<solve.findMinArrowShosts(points)<<endl;
	
    cout<<"Hello World!"<<endl;
    
    
    return 0;
}