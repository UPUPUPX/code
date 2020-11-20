#include<stdio.h>
#include<stdlib.h>
#include<queue>
using namespace std;
#define OK 1
#define ERROR 0
#define OVERFLOW 3

typedef int Status;  //Status是函数的类型,其值是函数结果状态代码，如OK等
typedef int Boolean; //Boolean是布尔类型,其值是TRUE或FALSE
typedef char TElemType;

//-----二叉树的二叉链表存储表示-----
typedef struct BiTNode{
    TElemType	   data;
    struct BiTNode *lchild, *rchild;	//左右孩子指针
}BiTNode, *BiTree;

//-----基本操作的函数原型说明-----
Status CreateBiTree(BiTree &T){
    //按先序次序输入二叉树中的结点的值(一个字符)，空格字符表示空树，
    //构造二叉链表表示的树T
    TElemType ch;
    scanf("%c", &ch);
    getchar();
    if(ch == ' '){
        T = NULL;
    } else {
        if( !(T=(BiTree)malloc(sizeof(BiTNode))) ){
            exit(OVERFLOW);
        };
        T->data = ch;					//生成根结点
        printf("输入%c的左子树：", ch);
        CreateBiTree(T->lchild);		//构造左子树
        printf("输入%c的右子树：", ch);
        CreateBiTree(T->rchild);		//构造右子树
    }
    return OK;
}
//先序遍历二叉树T
Status PreOrderTraverse(BiTree T, Status (* Visit)(TElemType e)){
    //采用二叉链表表示存储结构，Visit是对结点操作的应用函数。
    //先序遍历二叉树T，对每个结点调用函数Visit一次且仅一次。
    //一旦visit()失败，则操作失败。
    if(T){
        if(Visit(T->data) == OK){
            if(PreOrderTraverse(T->lchild, Visit) == OK){
                if(PreOrderTraverse(T->rchild, Visit) == OK){
                    return OK;
                }
            }
        }
        return ERROR;
    }else {
        return OK;
    }
}
//中序遍历二叉树T
Status InOrderTraverse(BiTree T, Status (* Visit)(TElemType e)){
    //采用二叉链表表示存储结构，Visit是对结点操作的应用函数。
    //中序遍历二叉树T，对每个结点调用函数Visit一次且仅一次。
    //一旦visit()失败，则操作失败。
    if(T){
        if(PreOrderTraverse(T->lchild, Visit) == OK){
            if(Visit(T->data) == OK){
                if(PreOrderTraverse(T->rchild, Visit) == OK){
                    return OK;
                }
            }
        }
        return ERROR;
    }else {
        return OK;
    }
}
//后序遍历二叉树T
Status PosOrderTraverse(BiTree T, Status (* Visit)(TElemType e)){
    //采用二叉链表表示存储结构，Visit是对结点操作的应用函数。
    //后序遍历二叉树T，对每个结点调用函数Visit一次且仅一次。
    //一旦visit()失败，则操作失败。
    if(T){
        if(PreOrderTraverse(T->lchild, Visit) == OK){
            if(PreOrderTraverse(T->rchild, Visit) == OK){
                if(Visit(T->data) == OK){
                    return OK;
                }
            }
        }
        return ERROR;
    }else {
        return OK;
    }
}
//层序遍历二叉树T
Status LevelOrderTraverse(BiTree T, Status (* Visit)(TElemType e)){
    //采用二叉链表表示存储结构，Visit是对结点操作的应用函数。
    //层序遍历二叉树T，对每个结点调用函数Visit一次且仅一次。
    //一旦visit()失败，则操作失败。
    if(T){
        if(Visit(T->data) == OK){
            if(PreOrderTraverse(T->lchild, Visit) == OK){
                if(PreOrderTraverse(T->rchild, Visit) == OK){
                    return OK;
                }
            }
        }
        return ERROR;
    }else {
        return OK;
    }
}
//求树的深度
Status TreeDeep(BiTree T){
    int deep=0;
    if(T){
        int leftDeep = TreeDeep(T->lchild);
        int rightDeep = TreeDeep(T->rchild);
        deep = leftDeep>=rightDeep ? leftDeep+1 : rightDeep+1;
    }
    return deep;
}

Status BiTreeEmpty(BiTree T){
    if(T->data==' ')return OK;
    else return ERROR;
}

Status Root(BiTree T, TElemType *e){
    //根节点
    if(T)
        if(BiTreeEmpty(T) == OK)return ERROR;
        else{
            *e=T->data;
            return OK;
        }
}
//求树叶的个数
Status LeafCount(BiTree T, int &num){
    if(T)
    {
        if(T->lchild==NULL && T->rchild==NULL){
            num++;
        }
        LeafCount(T->lchild,num);
        LeafCount(T->rchild,num);
    }
    return num;
}
//最简单的visit函数
//调用实例：PreOrderTraverse(T, PrintElement);
Status PrintElement(TElemType e){	//输出元素e的值
    printf("%c",e);
    return OK;
}
void ceng(BiTree T) {
    printf("层序遍历:");
    queue <BiTree> TreeQueue;
    TreeQueue.push(T);
    BiTree p =T;
    while (!TreeQueue.empty())
    {
        p = TreeQueue.front();
        TreeQueue.pop();
        printf(" %c ", p->data);

        if (p->lchild)
        {
            TreeQueue.push(p->lchild);
        }
        if (p->rchild)
        {
            TreeQueue.push(p->rchild);
        }
    }
}


int main(){
    int i;
    BiTree T;
    TElemType e;
    printf("输入树根：");
    CreateBiTree(T);
    printf("建立二叉树后,树空否？ %d(1:是 0: 否) \n树的深度为：%d\n", BiTreeEmpty(T),TreeDeep(T));
    i=Root(T,&e);
    if(i) printf("二叉树的根为：%c\n",e);
    else printf("树空,无根 \n");
    ceng(T);
    printf("\n");
    printf("先序遍历：\n");
    PreOrderTraverse(T, PrintElement);
    printf("\n");
    printf("中序遍历：\n");
    InOrderTraverse(T, PrintElement);
    printf("\n");
    printf("后序遍历：\n");
    PosOrderTraverse(T, PrintElement);
    printf("\n");
    return 0;
}