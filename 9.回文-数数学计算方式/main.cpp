/*问题描述:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是
 * 一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
*/
#include<iostream>
using namespace std;

//参考题解链接: https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
/*
 * 思路:输入12321, /10 和 %10 对current_number和saved_number进行比较,return 0/1
 * 12321 0
 * 1232 1
 * 123 12
 * 12 123
 */

bool isPalindrome(int x){
	int flag = 0;
	int current_number = x;
	int saved_number = 0;
	if(x<10 && x>=0)//0-9的数字一定是回文数
		return 1;
	if(x<0 || x%10==0)//排除负数和100, 500之类的数字
		return 0;
	while(current_number!=saved_number && flag!=1){
		if(current_number/10 == saved_number)//12321, 当curren_number=123, saved_number=12
			flag = 1;
		else if(current_number<saved_number)//123121, 当curren_number=12, saved_number=1213, 省略之后的两次12循环
			return 0;
		saved_number = saved_number * 10 + current_number % 10;
		current_number /= 10;
	}
	return 1;
}

int main(){
	int x = 0;
	cin >> x;
	cout << isPalindrome(x);
	return 0;
}
