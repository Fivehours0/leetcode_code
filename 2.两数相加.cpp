#include<iostream>
using namespace std;

struct ListNode{
	int val;
	ListNode* next;
};

void CreateList(ListNode* phead)
{
	ListNode* p = phead;
	for(int i=0; i<10; i++)
	{
		p->val = i;
		if(i!=9){
			ListNode* NewNode = new ListNode;
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

int main(){
	ListNode* phead = new ListNode;
	CreateList(phead);
	PrintList(phead);
	DeleteList(phead);
}
