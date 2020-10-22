#include <cstdio>
#include <cmath>
using namespace std;
int main(){
    int n,rows;
    char c;
    scanf("%d %c",&n,&c);
    for (int i=1;i<100;i++){
        int s=2*i*i-1;
        if (n>=s){
            rows=i;
        }
    }
    int left=n-(2*pow(rows,2)-1);
    int total=rows*2-1;
    for (int i = 0; i < total; ++i) {
        int s;
        if (i<rows){s=i%total;}
        else if (i>=rows){s=(total-1)-i%total;}
        for (int j =0; j < s; ++j) {
            printf(" ");
        }
        for (int j = 0; j < total-2*s; ++j) {
            printf("%c",c);
        }
        for (int j =0; j < s; ++j) {
            printf(" ");
        }
        printf("\n");
    }
    printf("%d",left);
    return 0;
}