#include<cstdio>
using namespace std;
typedef struct student{
    char name[11];
    char id[11];
    int score;
};
int main(){
    int n;
    scanf("%d",&n);
    student a[n];
    for (int i = 0; i < n; ++i) {
        scanf("%s %s %d",&a[i].name,&a[i].id,&a[i].score);
    }
    student b[2];
    b[0]=a[0];
    b[1]=a[0];
    for (int i = 1; i < n; ++i) {
        if (a[i].score>b[0].score){
            b[0]=a[i];
        }
        if (a[i].score<b[1].score){
            b[1]=a[i];
        }
    }
    printf("%s %s\n",b[0].name,b[0].id);
    printf("%s %s\n",b[1].name,b[1].id);
    return 0;
}