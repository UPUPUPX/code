#include <cstdio>
#include <cmath>
using namespace std;
int main()
{
    int a,b;
    while (scanf("%d%d",&a,&b)!=EOF)
    {
        int f=1;
        for (int i = a; i <= b; i++) {
            int a=i/100;
            int b=i/10%10;
            int c=i%10;
            if ((pow(a,3)+pow(b,3)+pow(c,3))==i)
            {
                if (f==1)
                {
                    printf("%d",i);
                    f=0;
                }
                else printf(" %d",i);
            }
        }
        if (f) printf("no\n");
        else printf("\n");
    }
    return 0;
}