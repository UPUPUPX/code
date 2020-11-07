#include<iostream>
#include<cmath>
using namespace std;
const int MaxElement=100;
typedef int Status;
typedef char ElementData;
typedef struct BtreeNode *PBinTree;
struct BtreeNode{
    ElementData Data[MaxElement];
    int length;
    BtreeNode(){
        length=0;
    }
};
Status InitBinTree(PBinTree bintree){
    char temp;
    while(scanf("%c",&temp)!='$')
    {
        bintree->Data[bintree->length]=temp;
        bintree->length++;
        scanf(" %c",&temp);
    }
}

void LevelOrder(PBinTree bintree)
{
    for(int i=0; i<bintree->length;i++){
        if(bintree->Data[i]!='0')
            cout<<bintree->Data[i]<<endl;
    }
}
void  DLROrder(PBinTree bintree,int i){
    if(bintree->Data[i]!='0')
    {
        cout<<bintree->Data[i]<<endl;
        DLROrder(bintree,i*2+1);
        DLROrder(bintree,i*2+2);
    }
}
void pre(char a[],int i)
{
    if (a[i]!='0')
    {
        printf("%d",a[i]);
    }
    pre(a,i*2+1);
    pre(a,i*2+2);
}
void juge(PBinTree bintree)
{
    if(bintree->length==0)
        cout<<"该树为空";
    else
    {
        cout<<"根节点为："<<bintree->Data[0]<<endl;
        cout<<"深度为：";
        cout<<(int)(log(bintree->length)/log(2)+1)<<endl;
    }
}
int main(){
    PBinTree tree=new struct BtreeNode;
    InitBinTree(tree);
    juge(tree);
    cout<<"层序遍历："<<endl;
    LevelOrder(tree);
    cout<<"先序遍历："<<endl;
    DLROrder(tree,0);
    return 0;
}