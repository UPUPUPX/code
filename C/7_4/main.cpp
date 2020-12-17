#include <cstdio>
using namespace std;
const int max=10005;
typedef struct Student{
    int id;
    int c;
    int d;
};
/*输入第一行给出 3 个正整数，分别为：N（≤10
​5
​​ ），即考生总数；L（≥60），为录取最低分数线，即德分和才分均不低于 L 的考生才有资格被考虑录取；
 H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；
 才分不到但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；
 德才分均低于 H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；
 其他达到最低线 L 的考生也按总分排序，但排在第三类考生之后。*/
void s(Student b[max],int n,int D,int L){
    Student a[max],d[max],c[max],e[max];
    int x=0,y=0,z=0,q=0;
    for (int i = 0; i < n; ++i) {
        if (b[i].c>=D&&b[i].d>=D){
            a[x++]=b[i];
        }
        else if (b[i].c>=D&&b[i].d<D&&b[i].d>=L){
            b[y++]=b[i];
        }
        else if (b[i].d>=b[i].c&&b[i].c>=L){
            c[z++]=b[i];
        }else if (b[i].d>=L&&b[i].c>=L){
            e[q++]=b[i];
        }
    }

}
void sort1(Student )