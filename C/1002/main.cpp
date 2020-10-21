#include <cstdio>
#include <string>
using namespace std;
string switch_chinese(int n){
    string b[10]={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    return b[n];
}
int main(){
    char a;
    int c=0;
    int sum=0;
    string s[100];
    while ((a=getchar())!='\n') {
        sum += (a - '0');
    }
    while (sum/10!=0){
        s[c]=switch_chinese(sum%10);
        sum/=10;
        c++;
    }
    s[c++]=switch_chinese(sum%10);
    for (int j = c; j >0 ; j--) {
        if (j==c){
            printf("%s",s[j].c_str());
        }
        else{
            printf("%s",s[j].c_str());
            printf(" ");
        }
    }
    printf("%s",s[0].c_str());
    return 0;
}