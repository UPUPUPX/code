#include<cstdio>
#include<algorithm>
#include <vector>
using namespace std;
bool cmp(int a,int b){
    return a>b;
}
int main(){
    int n,flag=0;
    int a[1000]={0};
    vector<int> v(1000,0);
    scanf("%d",&n);
    for (int i = 0; i < n; i++) {
        int t;
        scanf("%d",&t);
        v.push_back(t);
        while (t!=0){
            if (t%2==1){t=(3*t+1);}
            t/=2;
            if (a[t]==0){a[t]=1;}
        }
    }
    sort(v.begin(),v.end(),cmp);
    for (int i = 0; i < v.size(); i++) {
        if (a[v[i]]==0){
            if (flag==1){
                printf(" ");
            }
            printf("%d",v[i]);
            flag=1;
        }
    }
    return 0;
}