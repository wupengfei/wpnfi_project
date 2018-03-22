#include <iostream.h> 
#include <algorithm>
#include <vector>

bool cmp(const std::pair<int,int> &a,const std::pair<int,int> &b)
{
	return a.first< b.first; // û�б�Ҫ������˵���ͬ����� 
}

class Solution{
	public:
		int findMinArrowShosts(std::vector<std::pair<int,int> > points){
			if(points.size() == 0){
				return 0;
			}
			std::sort(points.begin(),points.end(),cmp); //����������˵��С�������� 
			int shoot_num = 1;
			int shoot_begin = points[0].first; //��ʼ��������� 
			int shoot_end = points[0].second;
			std::vector<std::pair<int,int> > direct;
			
			for(int i=1; i<points.size(); i++){
				if(shoot_end >= points[i].first){
					shoot_begin = points[i].first;
					
					if(shoot_end > points[i].second) {
						shoot_end = points[i].second;
					}
					cout<<"["<<shoot_begin<<"-"<<shoot_end<<"]"<<endl;
				} else { // ���������� 
					shoot_num ++;
					shoot_begin = points[i].first;
					shoot_end = points[i].second;
				}
			}
			return shoot_num;
		}
};
/*
������ 
*/
int main()
{
	std::vector<std::pair<int,int> > points;
	points.push_back(std::make_pair(10,16));
	points.push_back(std::make_pair(2,8));
	points.push_back(std::make_pair(1,6));
	points.push_back(std::make_pair(7,12));
	
	Solution solve;
	cout<<"�������ĸ���Ϊ:"<<solve.findMinArrowShosts(points)<<endl;
	
    cout<<"Hello World!"<<endl;
    
    
    return 0;
}