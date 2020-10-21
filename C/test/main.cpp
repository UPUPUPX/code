#include<iostream>
using namespace std;
int main()
{
    int start,through,x;
    int minute,hour;
    cin>>start>>through;
    hour=start/100;
    minute=start%100;

    x=through/60;
    hour+=x;
    minute+=through%60;
    //minute+=through-x*60;
    while(minute<0){
        hour-=1;
        minute+=60;
    }
    if(minute>=60)
    {
        hour++;
        minute=minute-60;
    }
    if(hour==0)
    {
        cout<<"0"<<minute<<endl;
    }
    else
    {
        cout<<hour*100+minute<<endl;
    }
}
