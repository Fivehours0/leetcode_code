# 19.删除链表倒数第n个节点
## 知识点

1. 链表

2. 双指针

3. 虚拟节点

## 解题思路

| 知识点 | 使用原因 |
| :----: | :----: |
| 虚拟节点 | 头结点可能会被删除，头节点删除后，可返回虚拟节点->next,即为nullptr |
| 双指针 | 使用单指针需要遍历2遍，第一遍确定链表长度，第二遍搜索倒数第n个节点 |

![Alt Text](https://media.giphy.com/media/chbTvTzZDmBzFpyFgi/giphy.gif)

当q指针指向NULL时，p指针所指向的节点即为倒数第n个节点。
```c++
#include<iostream>
#include "ListNode.hpp"

ListNode* removeNthFromEnd(ListNode* head, int n) {
	//创建一个虚拟节点指向head，因为head可能被删除
	ListNode* dummyHead = new ListNode(0);
	dummyHead->next = head;

	ListNode* first = dummyHead;//双指针
	ListNode* second = dummyHead;
	for(int i=0; i<n+1; i++)
		second = second->next;
	while(second){
		first = first->next;
		second = second->next;
	}
	ListNode* deleteNode = first->next;
	//若输入为一个值的链表，deleteNode->next指向的是nullptr；
	first->next = deleteNode->next;
	delete deleteNode;
	//不返回head的原因是head可能被删除，返回dummyHead->next时，若head被删除，则返回nullptr
	ListNode* retNode = dummyHead->next;
	delete dummyHead;
	return retNode;
}

int main(){
	ListNode* head = new ListNode(0);
	head = CreateList(head);
	PrintList(head);
	head = removeNthFromEnd(head, 2);
	PrintList(head);
	DeleteList(head);
}
```
