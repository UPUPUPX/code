#include <cstdio>
#include "string"
using namespace std;
int main(){
    char a[80],b[80];
    int cc=0;
    int c[cc];
    int acount=0;
    int bcount=0;
    while ((a[acount]=getchar())!='\n'){acount++;}
    while ((b[bcount]=getchar())!='\n'){bcount++;}
    for (int i = 0;i<acount; ++i) {
        int x=i;
        for (int j = 0; j < bcount; ++j) {
            int count=0;
            while (a[i]==b[j]){
                count++;
                i++;
                j++;
                if (count==bcount){
                    c[cc++]=x;
                }
            }
        }
    }
    for (int i = 0; i < acount; ++i) {
        printf("%c",a[i]);
    }
    return 0;
}
