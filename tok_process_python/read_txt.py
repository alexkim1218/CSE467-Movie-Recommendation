import os
import string
import numpy as np
import pandas as pd
import pymysql

path='/Users/zhengce/Documents/567finalproject/wiki-plot-clean-tok'
path1='/Users/zhengce/Documents/567finalproject/wiki-plot-clean-tok/'
files=os.listdir(path)
df=pd.read_csv('movie_titles(whole).csv')

content=list()
# db1=pymysql.connect(host='localhost',port=3306,user='root',passwd='admin',db='movie')
# cur=db1.cursor()
for i in range(0,len(files),1):
    str=files[i]
    if ".txt" in str:
        path2=path1+str
        with open(path2,'r') as f:
            # if os.path.getsize(path2)!=0:
            data=f.read()
            data.strip('\n')
            a=''
            for line in data:
                a +=line.strip('\n')
            # c=a.split()
            b=''.join(a)
            # print(b)
            # sql = "UPDATE `movie` SET `plot`=(%S) WHERE `index`=(%s)"
            # cur.execute(sql, (data, i+1))
            # db1.commit()
            # db1.close()

            #print(data)
            content.append(b)
for i in range(0,len(content),1):
    if content[i]=="":
        content[i]='Coming soon~'
#print(content[1])
array=np.array(content)
df1=pd.DataFrame(content)
df['plot']=df1
print(df)
df1.to_csv('testing_plot')
# for j in range(0,len(content),1):
#
#     sql="UPDATE `movie` SET `plot`=(%S) WHERE `index`=(%s)"
#     cur.execute(sql,(content[j],j+1))
#     db1.commit()
#     db1.close()
# df.to_csv('testing1.1.csv')


