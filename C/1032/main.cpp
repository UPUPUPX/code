#include <cstdio>
using namespace std;
int main(){
    const int MAX=100005;
    int school[MAX]={0};
    int n,score,k;
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%d%d",&k,&score);
        school[k]+=score;
    }
    int scoremax=0;
    int schoolId=0;
    for (int i = 0; i < n; ++i) {
        if (school[i]>scoremax){
            scoremax=school[i];
            schoolId=i;
        }
    }
    printf("%d %d",schoolId,scoremax);
    return 0;
}