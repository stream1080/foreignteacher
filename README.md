
# 外教资源供需平台的微信小程序


#### 技术选型

1.  Java版本：1.8
2.  数据库：MySQL
3.  框架：SpringBoot + MyBatis
4.  服务器：Tomcat
5.  前端：微信小程序
6.  开发工具：Idea 2020，微信开发者工具



#### 登录功能
打开小程序，进入登录界面，输入账号和密码，点击登录，系统会判断用户的账号和密码，已经用户的身份，根据用户的身份进入不同的页面。小程序会访问后端服务器的一个登录接口，将账号和密码打包送往服务器进行验证，验证成功返回该用户的信息，验证失败则显示账号密码错误或者账号未注册。



#### 用户招聘列表
小程序第一页，用户发布的招聘。打开进入小程序，即可看到所有的用户发布的招聘信息，点击其中一个即可进入页面查看详细的招聘描述，点击下方的电话预约按钮即可拨打电话与外教联系，预约试听。



#### 外教服务列表

外教服务列表位于小程序中间的导航栏，点击即可显示所有外教发布的可提供外教服务的服务信息，选择其中一个，点击进入即可查看详细的外教服务内容，点击下方的电话预约即可预约相应的外教，申请试听。
	


#### 拨打电话预约

调用拨打电话的接口，拨打用户发布招聘中预留的电话，或者外教发布的服务预留的电话，与对方联系具体的情况和预约试听。



#### 查看和编辑用户个人信息

在导航栏“我的”中，点击信息维护即可查看个人的所有信息，点击编辑信息即可修改个人的所有信息。


#### 发布招聘/服务

用户可以发布招聘，寻找合适的外教，外教可以发布服务，寻找合适的用户。根据不同的用户，实现不同的功能。

     

#### 发布管理

美国用户都可以看到自己发布的招聘或者服务，可以编辑自己发布的招聘或者服务，也可以删除自己发布的内容，点击删除即可删除发布。

  
#### 修改密码功能

用户点击修改密码，进入修改密码界面，需要用户输入旧密码，新密码，确认新密码，系统会验证旧密码的正确性，和两次新密吗的一致性，通过则修改密码。修改成功后重新登录。
