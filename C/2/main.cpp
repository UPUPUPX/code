#include <cstdio>
using namespace std;
int main(){
    int a,b;
    scanf("%d %d",&a,&b);
    if (b==0){printf("%d/%d=Error",a,b);}
    else if (b<0){
        printf("%d/(%d)=%.2f",a,b,(double)a/b);
    }else{
        printf("%d/%d=%.2f",a,b,(double)a/b);
    }
}
