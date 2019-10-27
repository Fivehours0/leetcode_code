#include<iostream>
using std::cout;
using std::endl;

// the node of list
struct ListNode{
	int val;
	ListNode* next;
	ListNode(int val_i): val(val_i), next(nullptr) {}
};

//Summary: create a list
//Parameters:
//    head: the head pointer of list 
//Return : the head pointer of list
ListNode* CreateList(ListNode* head){
	ListNode* p1 = new ListNode(0);
	p1 = head;
	for(int i=0; i<5; i++){
		p1->val = i;
		//因为开始时已经创建了一个节点，防止在i=4时多创建一个节点，导致产生6个节点
		if(i!=4){ 
			ListNode* p2 = new ListNode(0);
			p1->next = p2;
			p1 = p2;
		}
	}
	return head;
}

//Summary: print a list
//Parameters:
//    head: the head pointer of list 
//Return : none
void PrintList(ListNode* head){
	if(head == nullptr)
		cout << "it is a nullptr" << endl;
	cout << "start print" << endl;
	while(head){
		cout << head->val << " ";
		head = head->next;
	}
}

//Summary: delete a list
//Parameters:
//    head: the head pointer of list 
//Return : none
void DeleteList(ListNode* head){
	if(head == nullptr)
		cout << "it is a list" << endl;
	ListNode* temp = new ListNode(0);
	while(head){
		temp = head;
		head = head->next;
		delete(temp);
	}
	cout << "delete complete" << endl;
}
