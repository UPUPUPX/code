#include <cstdio>
using namespace std;
int main(){
   int a;
   int b;
   scanf("%d %d",&a,&b);
   int min=a%100;
   int max=a/100;
   min+=b%60;
   max+=b/60;
   if (min>=60){
        min=min%60;
       max+=1;
   }
   while (min<0){
        max-=1;
        min+=60;
    }
   if (max==0){
       printf("%d%d",max,min);
   }
   else if (min<10){
       printf("%d0%d",max,min);
   }
   else{
       printf("%d%d",max,min);
   }
   return 0;
}

