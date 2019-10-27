/* 问题描述:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 
 * 方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807*/
#include<iostream>
#include"ListNode.hpp"
using namespace std;

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
	int flag = 0;//进位标志位
	int add_value = 0;
	ListNode* p1 = new ListNode(0);
	ListNode* head = new ListNode(0);
	head = p1;
	while(l1||l2)
	{
		//两个链表长度不同时,出现l1空的情况
		if(l1==nullptr)
		{
			add_value = l2->val + flag;
			 l2 = l2->next;

		}
		//两个链表长度不同时,出现l2空的情况
		else if(l2==nullptr)
		{
			add_value = l1->val + flag;
			l1 = l1->next;
		}
		else
		{
			add_value = l1->val + l2->val + flag;
			l1 = l1->next;
			l2 = l2->next;
		}
		flag = add_value / 10;
		p1->val = add_value % 10;
		if(l1||l2) //创建存储结果的链表的节点
		{
			ListNode* p2 = new ListNode(0);
			p1->next = p2;
			p1 = p2;
		}
	}
	//当l1和l2最后节点相加之后产生进位
	if (l1 == NULL && l2 == NULL && flag == 1)
		p1->next = new ListNode(1);
	return head;
}

int main(){
	ListNode* l1 = new ListNode(0);
	ListNode* l2 = new ListNode(0);
	CreateList(l1);
	CreateList(l2);
	PrintList(l1);
	PrintList(l2);
	PrintList(addTwoNumbers(l1, l2));
	ListNode* head = addTwoNumbers(l1, l2);
	PrintList(head);
	DeleteList(l1);
	DeleteList(l2);
	DeleteList(head);
}
