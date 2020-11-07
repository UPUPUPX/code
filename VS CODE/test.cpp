#include<iostream>
#include<cmath>
#include<cstdio>
using namespace std;
#define MAX 1024
void InitTree(char tree[])
{
	for(int i=0;i<MAX;i++)
	{
		tree[i]='\n';
	}
	
}

int CreatSeqTree(char tree[] )
{
	int count=0;
	for(int i=1;i<MAX;i++)
	{
		if((tree[i]=getchar())=='\n')
		{
			break;
		}
		count++;
	}
	return count;
}
bool TreeEmpty(char tree[])
{
	if(tree[1]=='\n'||tree[1]=='^') return 1;
	return 0;
}

int Depth(char tree[],int count)
{	
	if(TreeEmpty(tree)) return 0;
	else return log2(count)+1;
} 

void Root (char tree[])
{
	if(TreeEmpty) cout<<tree[1]<<endl;
	else cout<<"树为空，无根节点"<<endl;
}
void pre(char tree[],int j)
{
	for (int i = 0;  ; i++)
	{
		if (tree[i]!='0')
		{
			printf("%c",tree[i])
			pre(char tree[],j);
		}
	}			
}
// void  DLROrder(PBinTree bintree,int i){
//     if(bintree->Data[i]!='0')
//     {
//         cout<<bintree->Data[i]<<endl;
//         DLROrder(bintree,i*2+1);
//         DLROrder(bintree,i*2+2);
//     }
// }
int main()
{
	int count;
	char tree[MAX];
	InitTree(tree);
	count=CreatSeqTree(tree);
	cout<<"count="<<count<<endl;
	cout<<TreeEmpty(tree)<<endl;
	cout<<Depth(tree,count)<<endl;
	Root(tree);
	pre(tree,0);
	return 0;
}