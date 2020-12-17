#include<cstdio>
#include<cmath>
#include <iostream>
using namespace std;
void s(int b[8]){
    int a[4][2];
    int m=0;
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; i < 2; i++)
        {
            a[i][j]=b[m++];
            printf("%d",a[i][j]);
        }
    }
    int s1=a[0][0]*a[1][1]+a[1][0]*a[2][1]+a[2][0]*a[0][1]-a[2][0]*a[1][1]-a[1][0]*a[0][1]-a[0][0]*a[2][1];
    int s2=a[1][0]*a[2][1]+a[2][0]*a[3][1]+a[3][0]*a[1][1]-a[3][0]*a[2][1]-a[2][0]*a[1][1]-a[1][0]*a[3][1];
    double s=fabs(s1)+fabs(s2);
    printf("%f",s/2);
}
int main(){
    int a[8]={0};
    for (int i=0;i<8;i++)
    {
        cin>>a[i];
    }
    s(a);
    return 0;
}