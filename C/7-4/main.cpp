#include"cstdio"
using namespace std;
int index(char a[],char b[],int alength,int blength){
    int start=0;
    int i=start;
    int j=0;
    while(i<alength&&i<blength){
        if(a[i]==b[i]){i++;j++;}
        else {start++;i=start;j=0;}
    }
    if(j>=blength) return i;
    else return -1;
}
int del(char a[],int index,int alength,int blength){
    for(int i=index+blength;i<alength;i++){
        a[i-blength]=a[i];
    }
    return alength-blength;
}
int main(){
    const int maxsize=80;
    char a[maxsize+1];
    char b[maxsize+1];
    int alength=0;
    int blength=0;
    while((a[alength]=getchar())!='\n'){++alength;}
    while((b[blength]=getchar())!='\n'){++blength;}
    int pos=index(a,b,alength,blength);
    while(pos){
        pos=del(a,pos,alength,blength);
    }
    for(int i=0;i<alength;i++){
        printf("%c",a[i]);
    }
    return 0;
}