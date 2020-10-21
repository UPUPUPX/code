#include <cstdio>
using namespace std;
int main(){
    int n;
    int rows;
    char a;
    scanf("%d %c",&n,&a);
    if (n%2==0)rows=n/2;
    else rows=n/2+1;
    for (int i = 0; i < rows; i++) {
        printf("%c",a);
        if (i==0)
        {
            for (int j = 0; j < n-1; ++j) {
                printf("%c",a);
            }
            printf("\n");
        }
        else if (i==rows-1)
        {
            for (int j = 1; j < n; ++j) {
                printf("%c",a);
            }
        }
        else if(i>0&&i<rows-1) {
            for (int j = 1; j < n-1; j++) {
                printf(" ");
            }
            printf("%c",a);
            printf("\n");
        }
    }
    return 0;
}