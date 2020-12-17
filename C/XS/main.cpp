#include <stdio.h>
using namespace std;
int main()
{
    int n;
    scanf("%d",&n);
    int flag=0;
    for (int i = 2; i < n; i+=2) {
        int m=i;
        for (int j = 2; j < n; j+=2) {
            if ((m+j==n||(m!=n)){
                flag=1;
                break;
            }
        }
    }
    if (flag==1)printf("YES");
    else printf("NO");
    return 0;
}