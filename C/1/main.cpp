#include <cstdio>
using namespace std;
int main(){
    int a[4];
    int sum=0;
    double average;
    for (int i = 0; i < 4; ++i) {
        scanf("%d",&a[i]);
        sum+=a[i];
    }
    average=(double)sum*1.0/4;
    printf("Sum = %d; Average = %.1f",sum,average);
    return 0;
}
