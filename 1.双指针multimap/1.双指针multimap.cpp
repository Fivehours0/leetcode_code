/*题目描述:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那
 * 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]*/
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
	multimap<int, int> items;//保存排序之前的index和value
	int count = 0;
	//插入items之后,数据已经排序
	for(auto i: nums)//将index和value插入items中
	{ 
		items.insert(pair<int, int>(i, count)); 
		count++; 
	}
	auto i = items.begin();//头指针
	auto j = --items.end();//尾指针
	while(1)
	{
		//如果两数之和大于target,尾指针向左移
		if((*i).first + (*j).first > target)
			j--;
		//如果两数之和小于target,头指针向右移
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
