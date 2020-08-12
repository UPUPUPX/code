## 操作流程

```c
git init //初始化仓库
git add .(文件name) //添加文件到本地仓库
git commit -m “first commit” //添加文件描述信息
git remote add origin git@github.com:UPUPUPX/code.git //链接远程仓库，创建主分支
git pull origin master // 把本地仓库的变化连接到远程仓库主分支
git push -u origin master //把本地仓库的文件推送到远程仓库
```



```c
git status ./      查看这个文件夹下的文件状态，会列出有哪些没有加入追踪，哪些没有commit
git add ./*       把这个文件下的所有应该加入追踪的，加入到暂存区
git commit -m "日志描述" ./      把这个文件夹下可以commit的，都commit到本地库
git push        push到远程库
```

git remote rm origin