/*
问题描述：
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例:
输入: "()"
输出: true

算法描述：
    遇到左括号和字符个数为奇数的字符串，返回false
    遇到空字符串，返回true
    首先将括号间的对应关系存储到一个map中，如direction_chart['{'] = '}'   (即是键和值之间的对应)
    遇到左括号，则将左括号压入堆栈中，遇到右括号则检测是否与栈顶括号匹配，若匹配则pop出栈顶括号，若不匹配则返回false
    最后，若堆栈为空，返回true
*/

#include<iostream>
#include<map>
#include<stack>
using namespace std;

bool isValid(string str);

int main(){
    string str ="()";
    cout << isValid(str) << endl;
    return 0;
}

bool isValid(string str) {
    map<char, char>  direction_chart; // 将括号间的对应关系存储到一个map中
    direction_chart['{'] = '}';
    direction_chart['['] = ']';
    direction_chart['('] = ')';

    stack<char> store; // 存放左括号的队列
    if(str=="") return true; // 输入字符串为空字符的情况
    if(str.length()%2!=0) return false; //输入字符串中字符个数为奇数的情况
    if(*str.begin()=='}' || *str.begin()==']' || *str.begin()==')') return false; // 输入字符串的开头为右括号的情况

    for(auto i=str.begin(); i<str.end(); i++){
        if(*i=='{' || *i=='[' || *i=='('){ // 遇到左括号，则将左括号压入堆栈中
            store.push(*i);
        }
        else{ // 遇到右括号则检测是否与栈顶括号匹配，若匹配则pop出栈顶括号，若不匹配则返回false
            if(*i==direction_chart[store.top()]){ 
                store.pop();
            }
            else
                return false;
        }
    }
    return store.empty(); // 若堆栈为空，返回true
}