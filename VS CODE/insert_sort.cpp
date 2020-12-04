#include <cstdio>
using namespace std;

void insertsort(int a[],int count)
{
    for (int i = 1; i < count; i++)
    {
        int t=a[i],j=i;
        while (j>=1&&t<a[j-1])
        {
           a[j]=a[j-1];
           j--;
        }
        a[j]=t;      
    }    
}

int main(){
	int array[]={49,38,65,97,76,13,27,49,10};
	int size= sizeof(array) / sizeof(int);
	printf("%d \n",size);
	insertsort(array,size);
    for (int i = 0; i < size; i++)
    {
        /* code */
        printf("%d ",array[i]);
    }
    
	return 0;
}