#include<cstdio>
#include<cstring>
using namespace std;
// 选择排序
void selectsort(int a[],int n)
{
    for (int i = 0; i < n; i++)
    {
        int k=i;
        for (int j = 0; i < n; i++)
        {
            if (a[j]<a[k])
            {
                k=j;
            }
        }
        int t=a[i];
        a[i]=a[k];
        a[k]=t;
    }
    
}
// 插入排序
void insertsort(int a[],int count)
{
    for (int i = 1; i < count; i++)
    {
        int t=a[i],j=i;
        while (j>=1&&t<a[j-1])
        {
           a[j]=a[j-1];
           j--;
        }
        a[j]=t;      
    }    
}
// sort函数应用
struct Student{
    char number[14];
    char name[11];
    int score;
    int rank;
};
bool cmp(Student a,Student b)
{
    if (a.score>b.score)
    {
        return a.score>b.score;
    }
    else return strcmp(a.name,b.name)<0;
}
int main()
{
    
}