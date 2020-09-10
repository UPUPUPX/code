#include<cstdio>
using namespace std;
int main()
{
    int n,j=0;
    long ans=1;
    while (scanf("%d",&n)!=EOF){
        for (int i = 0; i < n; i++) {
            int am;
            scanf("%d",&am);
            if (am%2==1){
                ans*=am;
            }
        }
        printf("%ld\n",ans);
        ans=1;
    }
    return 0;
}