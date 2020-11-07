#include<cstdio>
using namespace std;
const int maxn=10010;
bool hashTable[maxn]={false};

int main()
{
    int m,n,x;
    scanf("%d %d",&m,&n);
    for (int i = 0; i < m; i++)
    {
        scanf("%d",&x);
        hashTable[x]=true;
    }
    for (int j = 0; j < n; j++)
        {
            scanf("%d",&x);
            if (hashTable[x]==true)
            {
                printf("YES\n");
            }
            else
            {
                printf("NO\n");
            }
            
        }
    return 0;    
}