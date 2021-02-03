# 外教资源供需平台项目设计
## 项目摘要
- 据统计,目前在上海市长期期工作的外籍人员达3.7万余人,主要来自美国、日本、韩国、徳国、澳大利亚等国家,取得学士学位占95%以上,主要从事信息、计算机、教育、咨洵、科学研究和综合技术服务工作。
- 现在上海有很多外国人，可以提供外语家教、展会模特、翻译。本课题的目标建立-一个微信小程序，在上海的外国人可以登录并发布自己的信息，如哪个国家的、母语是什么，什么时间有空、在上海哪个区、可以提供什么服务等。中国人通过这个平台，可以查找自己需要的外国人资源，也可以发布招聘外教的信息。
- 项目目的是通过设计一个微信小程序，建立外语教学方面的外教资源联系。连接所有需要外教服务和提供外教服务的用户，让这些人群拥有一个交流的平台。使用当下流行的微信小程序进行设计开发

## 需求分析
### 技术可行性
#### Java简介
- Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。Java作为一门精准的语言，可以使开发者规范自己的程序结构,防止出现结构混乱的情况。同时，其内存回收站可以有效回收内存，防止程序浪费资源，影响机器性能。
#### SpringBoot简介
- SpringBoot是由Pivotal团队在2013年开始研发、2014年4月发布第一个版本的全新开源的轻量级框架。它基于Spring4.0设计，不仅继承了Spring框架原有的优秀特性，而且还通过简化配置来进一步简化了Spring应用的整个搭建和开发过程。另外SpringBoot通过集成大量的框架使得依赖包的版本冲突，以及引用的不稳定性等问题得到了很好的解决。


#### Mybatis简介
- MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。
#### MySQL简介
- MySQL是最流行的关系型数据库管理系统，在WEB应用方面MySQL是最好的RDBMS
   (Relational Database Management System,关系数据库管理系统)应用软件之一。MySQL是一种关联数据库管理系统，具有极高的灵活性。MySQL 所使用的SQL语言是用于访问数据库的最常用标准化语言。MySQL体积小、速度快、总体拥有成本低，尤其是开放源码这一特点，-般中小型网站的开发都选择MySQL作为网站数据库。
#### 微信小程序
- 微信小程序是一种全新的连接用户与服务的方式，它可以在微信内被便捷地获取和传播，同时具有出色的使用体验

### 功能需求
1. 用户按照身份进行登录，展示不同的界面和不同的功能，如用户登录可以看到外教的信息，外教登录可以看到用户的招聘信息。
2. 中国人的用户可以发布招聘信息，可以看到外教信息，如照片，国家、语言、所在区域，授课时间等。可以选择其中的外教，可通过电话联系，可免费预约试听。
3. 外教可以发布自己可以提供的服务，展示自己的信息，如照片，国家、语言、所在区域，授课时间等。
4. 用户可以编辑自己的个人信息，发布招聘内容和发布外教服务；管理自己的发布内容，管理自己的预约情况，修改密码等常用的用户管理功能。


## 技术选型与架构
* Java版本：1.8
* 数据库：MySQL
* 框架：SpringBoot + MyBatis
* 服务器：Tomcat
* 前端：微信小程序
* 开发工具：Idea 2020，微信开发者工具
* 版本管理工具：Maven
* 版本控制工具：GitHub
* 其他工具：Navicat

## 总体设计
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021020313571184.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)

### 系统整体结构图
![](https://img-blog.csdnimg.cn/20210203135627639.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)

### 系统架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203135725113.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)

## 关系模式设计
### 数据库E-R图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021020314015669.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)









### 数据库关系模型

- 用户(用户ID，姓名，年龄，性别，地址，电话，国籍，语言，类型)
- 主键：用户ID

* 招聘(招聘ID，用户ID，时间，地点，需求，电话，内容)
* 主键：招聘ID，外键：用户ID

- 外教(外教ID，用户ID，时间，地点，服务，电话，内容)
- 主键：外教ID，外键：用户ID

### 数据库表设计
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141255494.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141310211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141327230.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)


## 系统各功能实现
### 登录功能
- 打开小程序，进入登录界面，输入账号和密码，点击登录，系统会判断用户的账号和密码，已经用户的身份，根据用户的身份进入不同的页面。小程序会访问后端服务器的一个登录接口，将账号和密码打包送往服务器进行验证，验证成功返回该用户的信息，验证失败则显示账号密码错误或者账号未注册。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141358229.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)


### 用户招聘列表
- 小程序第一页，用户发布的招聘。打开进入小程序，即可看到所有的用户发布的招聘信息，点击其中一个即可进入页面查看详细的招聘描述，点击下方的电话预约按钮即可拨打电话与外教联系，预约试听。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141432633.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)

### 外教服务列表
- 外教服务列表位于小程序中间的导航栏，点击即可显示所有外教发布的可提供外教服务的服务信息，选择其中一个，点击进入即可查看详细的外教服务内容，点击下方的电话预约即可预约相应的外教，申请试听。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141635358.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)

### 拨打电话预约
- 调用拨打电话的接口，拨打用户发布招聘中预留的电话，或者外教发布的服务预留的电话，与对方联系具体的情况和预约试听。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141657371.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)


### 查看和编辑用户个人信息
- 在导航栏“我的”中，点击信息维护即可查看个人的所有信息，点击编辑信息即可修改个人的所有信息。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141724215.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)

### 发布招聘/服务
- 用户可以发布招聘，寻找合适的外教，外教可以发布服务，寻找合适的用户。根据不同的用户，实现不同的功能。实现代码见附录六
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141812159.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)


### 发布管理
- 外国用户都可以看到自己发布的招聘或者服务，可以编辑自己发布的招聘或者服务，也可以删除自己发布的内容，点击删除即可删除发布。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141856252.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)
### 修改密码功能
- 用户点击修改密码，进入修改密码界面，需要用户输入旧密码，新密码，确认新密码，系统会验证旧密码的正确性，和两次新密吗的一致性，通过则修改密码。修改成功后重新登录。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210203141915550.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Vwc3RyZWFtNDgw,size_16,color_FFFFFF,t_70)
## 总结
- Spring Boot是基于Spring框架开发的全新框架，其设计目的是简化新Spring应用的初始化搭建和开发过程。它整合了许多框架和第三方库配置，几乎可以达到“开箱即用”。这两个特性，让我在这次开发中省去了很多代码的开发时间，springboot是一款非常优秀的后端框架。
- 微信小程序微信小程序是一种全新的连接用户与服务的方式，它可以在微信内被便捷地获取和传播，同时具有出色的使用体验。非常适合作为小项目的前端设计。

- [项目源码](https://github.com/stream1080/foreignteacher)


