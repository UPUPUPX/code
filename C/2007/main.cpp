#include<cstdio>
using namespace std;
int main(){
    int a,b;
    while (scanf("%d %d",&a,&b)!=EOF)
    {
        int ans1=0,ans2=0;
        if (a>b)
        {
            int t;
            t=b;
            b=a;
            a=t;
        }else{}
        for (int i = a; i <= b; i++) {
            if (i%2==0)
            {
                ans1+=i*i;
            }
            else{
                ans2+=i*i*i;
            }
        }
        a=0;b=0;
        printf("%d %d\n",ans1,ans2);
    }
}