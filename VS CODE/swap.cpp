#include<cstdio>
using namespace std;
template <typename T>
void swap(T &a,T &b)
{
    T t=a;
    a=b;
    b=t;
}
template <typename T>
void swapp(T *a,T *b)
{
    T t=*a;
    *a=*b;
    *b=t;
}
int main()
{
    int a=1,b=2;
    printf("PRE %d %d\n",a,b);
    swap(a,b);
    printf("AFT %d %d\n",a,b);
    int *m=&a;
    int *n=&b;
    printf("PRE %d %d\n",a,b);
    swapp(m,n);
    printf("AFT %d %d",a,b);
}