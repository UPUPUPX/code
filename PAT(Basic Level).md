## 1001 害死人不偿命的(3n+1)猜想 (15分)

卡拉兹(Callatz)猜想：

对任何一个正整数 *n*，如果它是偶数，那么把它砍掉一半；如果它是奇数，那么把 (3*n*+1) 砍掉一半。这样一直反复砍下去，最后一定在某一步得到 *n*=1。卡拉兹在 1950 年的世界数学家大会上公布了这个猜想，传说当时耶鲁大学师生齐动员，拼命想证明这个貌似很傻很天真的命题，结果闹得学生们无心学业，一心只证 (3*n*+1)，以至于有人说这是一个阴谋，卡拉兹是在蓄意延缓美国数学界教学与科研的进展……

我们今天的题目不是证明卡拉兹猜想，而是对给定的任一不超过 1000 的正整数 *n*，简单地数一下，需要多少步（砍几下）才能得到 *n*=1？

### 输入格式：

每个测试输入包含 1 个测试用例，即给出正整数 *n* 的值。

### 输出格式：

输出从 *n* 计算到 1 需要的步数。

### 输入样例：

```in
3
```

### 输出样例：

```out
5
```

```c++
#include <cstdio>
using namespace std;
int main(){
    int n;
    int count=0;
    scanf("%d",&n);
    while (n!=1)
    {
        if (n%2==0)
        {
            n/=2;
            count++;
        }
        else{
            n=(n*3+1)/2;
            count++;
        }
    }
    printf("%d",count);
    return 0;
}
```

## 1002 写出这个数 (20分)

读入一个正整数 *n*，计算其各位数字之和，用汉语拼音写出和的每一位数字。

### 输入格式：

每个测试输入包含 1 个测试用例，即给出自然数 *n* 的值。这里保证 *n* 小于 10100。

### 输出格式：

在一行内输出 *n* 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。

### 输入样例：

```in
1234567890987654321123456789
```

### 输出样例：

```out
yi san wu
```

```c++
#include <cstdio>
#include <string>
using namespace std;
string switch_chinese(int n){
    string b[10]={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    return b[n];
}
int main(){
    char a;
    int c=0;
    int sum=0;
    string s[100];
    while ((a=getchar())!='\n'){
       sum+=(a-'0');
    }
    while (sum/10!=0){
        s[c]=switch_chinese(sum%10);
        sum/=10;
        c++;
    }
    s[c++]=switch_chinese(sum%10);
    for (int j = c; j >0 ; j--) {
        if (j==c){
            printf("%s",s[j].c_str());
        }
        else{
            printf("%s",s[j].c_str());
            printf(" ");
        }
    }
    printf("%s",s[0].c_str());
    return 0;
}
```



## 1032 挖掘机技术哪家强 (20分)

为了用事实说明挖掘机技术到底哪家强，PAT 组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。

### 输入格式：

输入在第 1 行给出不超过 105 的正整数 *N*，即参赛人数。随后 *N* 行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号（从 1 开始连续编号）、及其比赛成绩（百分制），中间以空格分隔。

### 输出格式：

在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。

### 输入样例：

```in
6
3 65
2 80
1 100
2 70
3 40
3 0
```

### 输出样例：

```out
2 150
```

```c++
#include <cstdio>
using namespace std;
int main(){
    const int MAX=100005;
    int school[MAX]={0};
    int n,score,k;
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%d%d",&k,&score);
        school[k]+=score;
    }
    int scoremax=0;
    int schoolId=0;
    for (int i = 1; i <= n; ++i) {
        if (school[i]>scoremax){
            scoremax=school[i];
            schoolId=i;
        }
    }
    printf("%d %d",schoolId,scoremax);
    return 0;
}
```



## 1036 跟奥巴马一起编程 (15分)

美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。2014 年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！

### 输入格式：

输入在一行中给出正方形边长 *N*（3≤*N*≤20）和组成正方形边的某种字符 C，间隔一个空格。

### 输出格式：

输出由给定字符 C 画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的 50%（四舍五入取整）。

### 输入样例：

```in
10 a
```

### 输出样例：

```out
aaaaaaaaaa
a        a
a        a
a        a
aaaaaaaaaa
```

```c++
#include <cstdio>
using namespace std;
int main(){
    int n;
    int rows;
    char a;
    scanf("%d %c",&n,&a);
    if (n%2==0)rows=n/2;
    else rows=n/2+1;
    for (int i = 0; i < rows; i++) {
        printf("%c",a);
        if (i==0)
        {
            for (int j = 0; j < n-1; ++j) {
                printf("%c",a);
            }
            printf("\n");
        }
        else if (i==rows-1)
        {
            for (int j = 1; j < n; ++j) {
                printf("%c",a);
            }
        }
        else if(i>0&&i<rows-1) {
            for (int j = 1; j < n-1; j++) {
                printf(" ");
            }
            printf("%c",a);
            printf("\n");
        }
    }
    return 0;
}
```
