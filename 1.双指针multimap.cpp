#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;
using std::cout;

template<typename T>
void show(T element) { cout << element << " "; }

vector<int> sum(vector<int>& nums, int target)
{
	vector<int> result;
	multimap<int, int> items;
	int count = 0;
	for(auto i: nums)
	{ 
		items.insert(pair<int, int>(i, count)); 
		count++; 
	}
	auto i = items.begin();
	auto j = --items.end();
	while(1)
	{
		if((*i).first + (*j).first > target)
			j--;
		else if((*i).first + (*j).first < target)
			i++;
		else
		{
			result = {(*i).second ,(*j).second};
			return result;
		}
	}
	return {0, 0};
}

int main()
{
	vector<int> nums{3, 2, 4};
	int target = 6;
	vector<int> result = sum(nums, target);
	for(auto i=result.begin(); i!=result.end(); i++)
		cout << *i;
}
