#include<iostream>
using namespace std;

struct ListNode{
	int val;
	ListNode* next;
	ListNode(int val_i):val(val_i), next(nullptr) {}
};

void CreateList(ListNode* phead)
{
	ListNode* p = phead;
	for(int i=0; i<10; i++)
	{
		p->val = i;
		if(i!=9){
			ListNode* NewNode = new ListNode(0);
			NewNode->next = nullptr;
			p->next = NewNode;
			p = NewNode;
		}
		else
			p->next = nullptr;
	}
}

void PrintList(ListNode* phead){
	cout << "start print" << endl;
	ListNode* temp = phead;
	if(nullptr == phead)
		cout << "it is a nullptr" << endl;
	while(temp){
		cout << temp->val << endl;
		temp = temp->next;
	}
}

void DeleteList(ListNode* phead){
	ListNode* temp = phead;
	while(nullptr == phead)
		cout << "it is empty" << endl;
	while(temp){
		temp = temp->next;
		delete phead;
		phead = temp;
	}
	cout << "delete complete" << endl;
	delete temp;
}

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
	int flag = 0;
	int add_value = 0;
	ListNode* p1 = new ListNode(0);
	ListNode* head = new ListNode(0);
	head = p1;
	while(l1||l2)
	{
		if(l1==nullptr)
		{
			add_value = l2->val + flag;
			 l2 = l2->next;

		}
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
		if(l1||l2) 
		{
			ListNode* p2 = new ListNode(0);
			p1->next = p2;
			p1 = p2;
		}
	}
	
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
}
