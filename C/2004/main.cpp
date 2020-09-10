#include <cstdio>
using namespace std;
int main()
{
    int score;
    while (scanf("%d",&score)!=EOF)
    {
        if (score<=100&&score>=0){
            int s=score/10;
            switch (s) {
                case 10:;
                case 9:printf("A\n");break;
                case 8:printf("B\n");break;
                case 7:printf("C\n");break;
                case 6:printf("D\n");break;
                default:printf("E\n");break;
            }
        } else{
            printf("Score is error!\n");
        }

    }
    return 0;
}
