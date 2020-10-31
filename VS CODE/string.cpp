#include <cstdio>
#include <cstring>
using namespace std;
bool jduge(char a[])
{
    int len = strlen(a);
    for (int i = 0; i < len; i++)
    {
        if (a[i] != a[len - i - 1])
        {
            return false;
        }
    }
    return true;
}
int main()
{
    char a[85];
    while (gets(a))
    {
        if(jduge(a)){
            printf("TRUE\n");
        }
        else
        {
            printf("FLASE\n");
        }
        
    }
    return 0;
}