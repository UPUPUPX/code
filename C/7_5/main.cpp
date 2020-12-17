#include <cstdio>
using namespace std;
const int max=10005;
void s(int a[max],int b[max],int c[max],int al,int bl){
    int cl=0,sa=0,sb=0;
    while(cl<al+bl){
        if (a[sa]<b[sb]){
            c[cl++]=a[sa++];
        }
        else{
            c[cl++]=b[sb++];
        }
    }
//    while (cl<al)c[cl++]=a[sa++];
//    while (cl<bl)c[cl++]=b[sb++];
    printf("%d",c[(al+bl)/2-1]);
}
int main(){
    int n;
    scanf("%d",&n);
    int a[n],b[n],c[n*2];
    for (int i = 0; i < n; ++i) {
        scanf("%d",&a[i]);
    }
    for (int j = 0; j < n; ++j) {
        scanf("%d",&b[j]);
    }
    s(a,b,c,n,n);
}