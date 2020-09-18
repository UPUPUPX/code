#include<cstdio>
using namespace std;
int main()
{
    int n;
    while (scanf("%d",&n)!=EOF&&n>=0)
    {
        double m;
        if (n!=0){
        int a=0,b=0,c=0;
        for (int i = 0; i < n; i++) {
           scanf("%lf",&m);//数据类型
           if(m>0) {a++;}
           else if (m==0) {b++;}
           else {c++;}
        }
        printf("%d %d %d\n",c,b,a);
        }
        else break;
    }
}