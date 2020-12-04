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
 int qusort(int s[],int start,int end)    //自定义函数 qusort()
    {
        int i,j;    //定义变量为基本整型
        i=start;    //将每组首个元素赋给i
        j = end;    //将每组末尾元素赋给j
        s[0]=s[start];    //设置基准值
        while(i<j)
        {
            while(i<j&&s[0]<s[j])
            j--;    //位置左移
            if(i<j)
            {
                s[i]=s[j];    //将s[j]放到s[i]的位置上
                i++;    //位置右移
            }
            while(i<j&&s[i]<=s[0])
                i++;    //位置左移
            if(i<j)
            {
                s[j]=s[i];    //将大于基准值的s[j]放到s[i]位置
                j--;    //位置左移
            }
        }
        s[i]=s[0];    //将基准值放入指定位置
        if (start<i)
            qusort(s,start,j-1);    //对分割出的部分递归调用qusort()函数
        if (i<end)
            qusort(s,j+1,end);
        return 0;
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