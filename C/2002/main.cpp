#include<cstdio>
#define PI 3.1415927
using namespace std;
int main() {
    double r;
    while (scanf("%lf",&r)!=EOF)
    {
        printf("%.3lf\n",4.0*PI*r*r*r/3.0);
    }
    return 0;
}
