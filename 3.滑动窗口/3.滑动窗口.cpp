/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
#include<iostream>
#include<unordered_set>
using namespace std;

int lengthOfLongestSubstring(string s) {
    int maxStr = 0;
	int left = 0;
	int s_size = s.size();
    unordered_set<char> lookup;
	if(s_size==0) return 0;
	for(int i=0; i<s_size; i++){
		while(lookup.find(s[i])!=lookup.end()){
			cout << s[i] << "  " << s[left] << endl;
			lookup.erase(s[left]);
			left++;
		}
		cout << left << endl;
		lookup.insert(s[i]);
		maxStr = maxStr>(i-left+1)? maxStr: (i-left+1);
	}
	return maxStr;
}

int main()
{
	string s;
	cin >> s;
	cout << lengthOfLongestSubstring(s);
	return 0;
}
