import os
import string
import numpy as np
import pandas as pd
import xlwt


def file_name(file_dir):
    for root, dirs, files in os.walk(file_dir):
        print(files)
    return files

file=file_name( '/Users/zhengce/Documents/567finalproject/wiki-plot-clean-tok')
file_subs=list()
for i in range(0,len(file),1):
    str=file[i]
    str15=str[:-4]
    if len(str15)>0:
        # str_=str15.replace("(","_")
        str2=str15.replace("_"," ")
        file_subs.append(str2)
    else:
        print(i)
# print(file_subs)
# for j in range(0,len(file_subs),1):
#     str3=file_subs[j]
#     str4=str3.replace("_"," ")
#     print(str4)


array=np.array(file_subs)
#print(array)
idx=range(1,len(file_subs)+1)
print(idx)
df=pd.DataFrame(array,index=idx,columns=['movie_title'])
print(df)

df.to_csv('movie_titles(whole)without_index111.csv')

# for i in range(0, len(file), 1):
#     str = file[i]
#     if ".DS_Store" in str:
#         i = i + 1
#     else:
#         str1 = str.replace("plot.clean.tok", "txt")
#         print(str1)
#         with open('/Users/zhengce/Documents/567finalproject/rocky-examples-dir-v2/tok_dir/'+str1) as f:
#             content=f.read()
#             print(content)