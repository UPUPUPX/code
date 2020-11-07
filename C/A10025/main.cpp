#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
struct Student{
    char number[14];
    int score;
    int testroom;
    int roomrank;
};
bool cmp(Student a,Student b)
{
    if (a.score>b.score)
    {
        return a.score>b.score;
    }
    else return strcmp(a.number,b.number)<0;
}
int main()
{
    Student stu[30030];
    int n,numstu,num=0;
    scanf("%d",&n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d",&numstu);
        for (int j = 0; i < numstu; i++)
        {
            scanf("%s %d",&stu[num].number,&stu[num].score);
            stu[j].testroom=i+1;
            num++;
        }
        sort(stu+num-numstu-1,stu+num,cmp);
        stu[num-numstu].roomrank=1;
        for (int i = num-numstu+1; i < n; i++)
        {
            if (stu[i].score==stu[i-1].score)
            {
                stu[i].roomrank=stu[i-1].roomrank;
            }
            else
            {
                stu[i].roomrank=i+1-(num-numstu);
            }
        }
    }
    sort(stu,stu+num,cmp);
    int rank=1;
    for (int i = 0; i < num; i++)
    {
        if(i>0&&stu[i].score!=stu[i-1].score)rank++;
        printf("%s %d %d %d\n",stu[i].number,stu[i].roomrank,stu[i].testroom,stu[i].roomrank);
    }
    return 0;
}