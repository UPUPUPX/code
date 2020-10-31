#include<cstdio>
#include<ctime>
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 20
using namespace std;
typedef int Status;
typedef int SElemType;
typedef struct{
    SElemType data[MAXSIZE];
    int top;
}SqStack;
Status init(SqStack *s){
    s->top=-1;
    return OK;
}
Status clear(SqStack *s){
    s->top=-1;
    return OK;
}
Status Isempty(SqStack s){
    if (s.top==-1){
        return TRUE;
    }
    else{
        return FALSE;
    }
}
int gettop(SqStack s,SElemType *e){
    if (s.top==-1){
        return ERROR;
    }
    else{
        *e=s.data[s.top];
    }
    return OK;
}
Status push(SqStack *s,SElemType e){
    if (s->top==MAXSIZE-1){
        return ERROR;
    }
    s->top++;
    s->data[s->top]=e;
    return OK;
}
Status pop(SqStack *s,SElemType *e){

}