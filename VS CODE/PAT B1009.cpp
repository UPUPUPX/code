#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    char str[90], ans[90][90];
    int s=0;
    cin.get(str,90);
    int len = strlen(str), r = 0, l = 0;
    for (int i = 0; i < len; i++)
    {
        if (str[i] != ' ')
        {
            ans[r][l++] = str[i];
        }
        else
        {
            ans[r][l] = '\0';
            r++;
            l = 0;
        }
    }
    for (int i = r; i >= 0; i--)
    {
        printf("%s", ans[i]);
        if (i > 0)
        {
            printf(" ");
        }
    }

    return 0;
}