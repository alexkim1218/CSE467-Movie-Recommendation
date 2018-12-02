import os

path='/Users/zhengce/Documents/567finalproject/wiki-plot-clean-tok'
path1='/Users/zhengce/Documents/567finalproject/wiki-plot-clean-tok/'
files=os.listdir('/Users/zhengce/Documents/567finalproject/wiki-plot-clean-tok')
print('files',type(files))

for i in range(0,len(files),1):
    str=files[i]
    print(str)
    if "plot.clean.tok" in str:
        str1=str.replace("plot.clean.tok","txt")
        str2=path1+str1
        print(str2)
        str3=path1+str
        print(str3)
        # os.renames(str3,str2)
    else:
        print(i)