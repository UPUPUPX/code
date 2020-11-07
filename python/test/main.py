import requests
import xlwt
import os
import json
os.chdir('..//filepath//')  ##设置工作路径
workbook=xlwt.Workbook(encoding='utf-8')
worksheet=workbook.add_sheet('说好不哭评论')
worksheet.write(0,0,'昵称')
worksheet.write(0,1,'时间')
worksheet.write(0,2,'点赞数')
worksheet.write(0,3,'评论')
n=1
for page in range(0,200):
    print('-'*100)
    url_left='https://c.y.qq.com/base/fcgi-bin/fcg_global_comment_h5.fcg?g_tk=792727314&hostUin=0&format=json&inCharset=utf8&outCharset=GB2312&notice=0&platform=yqq.json&needNewCode=0&cid=205360772&reqtype=2&biztype=1&topid=237773700&cmd=8&needmusiccrit=0'
    url=url_left+'&pagenum='+str(page)+'&pagesize=25'
    headers={'User-agent':'Mozilla/5.0'}
    r=requests.get(url,headers=headers)
    data=json.loads(r.text)
    common_comments=data.get('comment').get('commentlist')
    for i in range(0,len(common_comments)):
        worksheet.write(n,0,common_comments[i].get('nick'))
        worksheet.write(n,1,common_comments[i].get('time'))
        worksheet.write(n,2,common_comments[i].get('praisenum'))
        worksheet.write(n,3,common_comments[i].get('rootcommentcontent'))
        n+=1
    print('第{}页评论爬取完成'.format(str(page)))
    print('-'*100)
workbook.save('common-comments.xls')
