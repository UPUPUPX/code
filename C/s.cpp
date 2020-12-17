#include<cstdio>
using namespace std;
int main(){
    int count=0;
    for (int i = 1922; i <= 2020; i++)
    {
       if (i%4==0||i%100==0)
       {
          count++;
       }
    }
    printf("%d",count);
    return 0;
}