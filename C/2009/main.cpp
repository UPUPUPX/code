#include <cstdio>
#include <cmath>
using namespace std;
int main()
{
    int a=0,b=0;
    while (scanf("%d%d",&a,&b)!=EOF)
    {
        double ans=0;
        double s=a;
        for (int i = 0; i < b; i++) {
            ans+=s;
            s=sqrt(s);
        }
        printf("%.2lf\n",ans);
    }
    return 0;
}