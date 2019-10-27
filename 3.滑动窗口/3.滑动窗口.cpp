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
