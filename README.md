# 实训操作流程
    楔子：
        本次实训， 无其他意义，让普通学生“见见世面罢了”， 知道在课堂之外的“编程”。
    涉及的相关知识：
        js(ES6标准), html5, Java, sql语句
* 原则：为了避免麻烦，凡是涉及到路径的， 一律不带中文和空格。
## 第一步: 下载MySQL
    自己在网络上搜索如何下载教程。
    注意点只有一个，那就是记住自己的用户名和密码。 可以是root用户， 也可以自己创建用户。 

## 第二步： 下载Idea专业版
    一定要专业版， 社区版阉割掉了一些功能。
    也可以使用其他的IDE， 也不是不行。 但是我没操作过。自己个儿摸索吧。 
    在此郑重声明： 我们【应该】支持正版。 当然。

## 第三步：建立项目 步骤如下：
>*<font size=1 color=red>注： 我懂的地方， 我会讲一讲为什么， 我不懂的就不讲了。 因为此代码项目是老师带着的， 
说白了就是亦步亦趋， “copy”的。老师给讲一讲流程， 要实现什么功能，要掉用什么方法。 
而彼时彼刻， 我是不具备相应的基础知识储备的。 知其然， 而不知其所以然， 此之谓也。 
这样不好。</font>*
---
    一. 创建工程
>   入下图所示：
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/1.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/2.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/3.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/4.png)
    GroupID 和 ArtifactId 自己随便起就行了。
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/5.png)
    User settings file 和 Local repository这两个路径可以自己选择也可默认， 悉听尊便。
    User settins file就是settings.xml文件所在的目录。 
    至于Local repository是用来做什么的， 目前我不详。 
    倘若要自己选择， 勾选右侧的Override。
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/6.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/7.png)
    settings.xml文件的注意点：
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/8.png)
    请一定注意， 这里的这个路径，一定要填写你自己的Local repository路径， 也就是上面图中的那个。 
    之后一路确定就完事了， 就新建成功了一个项目。
    进入下一轮操作
--- 
    二. 配置相应环境

>   1. 配置pom.xml文件, 
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/9.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/10.png)
      复制内容如下：
>>      
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <!--导入 servlet jar包-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
    </dependency>
    <!--导入mysql jar包依赖-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.46</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.59</version>
    </dependency>
>   2. 配置web.xml文件, 复制内容如下:
      ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/11.png)
      ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/12.png)
>>  
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
    <display-name>Archetype Created Web Application</display-name>
    </web-app>

>   配置好上文两个文件之后， Idea会有一通导入文件的操作。 
    当它导入完毕之后， 会呈现出如下的样子， 请对比是否完整：
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/13.png)
>   3. 让Idea支持ES6标准
    如下一通操作即可：
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/14.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/15.png)
---
>   4. 配置Configuration
    如下图中进行一通操作即可。Tomcat文件已经上传， 或者自己从网络上下载
    首先点击run-> Edit Configurations,进入如图所示：
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/18.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/17.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/19.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/20.png)
    HTTP port 和 JMX port一般来说没问题， 但是如果出现占用啥的。 自己改一个就好了。 改成8080啥的。
    然后点击Deployment, 出现如下图所示：
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/21.png)
    你的Deploy at the server startup下面应该是空的。然后点击旁边的加号。点击Artifact, 然后点击第二个
    带有exploded字样的。
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/22.png)
    ![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/23.png)
    如上图， 可把这个整成只剩一个/， 不过此时没必要。
    全部完成。 

## 第四步：上代码
![Image text](https://github.com/MuXTing/ShiXunInNUIST/blob/master/image-folder/16.png)
    请根据我上面的工程结构截图， 一次创建相应的文件夹， 创建相应的文件。 
    至于代码， 你可以自己敲， 也可以ctrl A & C。 看你需求了。 
    
**声明： 代码来源于讲师印明明先生。

