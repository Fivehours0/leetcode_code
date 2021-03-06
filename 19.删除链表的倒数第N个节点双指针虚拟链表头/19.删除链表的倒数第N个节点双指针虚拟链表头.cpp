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
