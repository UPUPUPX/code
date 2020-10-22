#include <cstdio>
using namespace std;
int main(){
    char a[1004];
    int length=0,count;
    while ((a[length]=getchar())!='\n'){length++;}
    int start;
    for (int i = 0; i < length; ++i) {
        start=i;count=0;
        for (int k = length;k >=0 ; k--) {
            if (i!=k){
                if (a[start]==a[k]){start++;count++;}
                else;
            }else;
            if (start==k&&count!=0){break;}
            else;
        }
    }
    printf("%d",count*2-1);
}