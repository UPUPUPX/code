#include <cstdio>
#include <cmath>
using namespace std;
bool Isprime(int n){
    int s=sqrt(n);
    for (int i = 2; i < n; ++i) {
        if (s%i==0){
           return false;
        }
    }
    return true;
}
int main() {
    int n, count = 0;
    scanf("%d", &n);
    for (int i = 2; i < n - 2; i ++) {
        if (Isprime(i)) {
            {
                if (Isprime(i + 2)) {
                    count++;
                }
            }
        }
    }
    printf("%d", count);
    return 0;
}