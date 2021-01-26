// pages/login/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:'',
    password:'',
    type: " "
  },

/**
 * 
 * 设置用户类型
 * 
 */
  userType:function(e){
    var app = getApp()
    app.globalData.type = e.detail.value
    //console.log(app.globalData.type)
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  formSubmit:function(e){
    var that = this;
    var app = getApp()
    var username = e.detail.value.username;
    var password = e.detail.value.password;
    //console.log(username)

    if(username.length == 0 || password.length == 0){
      wx.showToast({
        title: '用户名或密码不能为空',
        icon: "none",
        duration: 2000
      })
    }else{
      
        var np = {
          "userId":username,
          "password":password
        }
        //console.log(np)
        wx.request({
        url: "http://127.0.0.1:8080/demo/superadmin/wxlogin",
        data: JSON.stringify(np),
        method: 'POST',
        header: {
          'Content-Type': 'application/json'
        },
        success: function (res) {
          //console.log(res)
          
          //var result = res.data.success
          if(res.data.user == null){
            wx.showToast({
              title: '用户名或密码错误',
              icon: 'none',
              duration: 2000
            })
          }else if (res.data.user.userId == username) {
            app.globalData.userInfo = username
            app.globalData.userName = res.data.user.username
            app.globalData.age = res.data.user.age
            app.globalData.sex = res.data.user.sex
            app.globalData.telephone = res.data.user.telephone
            app.globalData.address = res.data.user.address
            app.globalData.notioality = res.data.user.notioality
            app.globalData.language = res.data.user.language
            app.globalData.userType = res.data.user.userType
            app.globalData.password = res.data.user.password
            ////console.log(app.globalData.telephone)
            wx.switchTab({
              url: '../person/person',
            })
          }else{
            wx.showToast({
              title: '登录失败',
              icon: 'none',
              duration: 2000
            })
          }
        },
      })
}
  },

  goToRegist:function(){
    wx.navigateTo({
      url: '../operation/operation',
    })
  }
})





// wx.request({
//   url: 'http://127.0.0.1:8080/demo/superadmin//getuserbyid',
//   data: { "userId": username },
//   method: 'GET',
//   success:function(res){
//   // var pass = res.data.user.password;
//   ////console.log(res)
//     var userId = res.data.user.userId;
//     if(res.data.user.password == password){
      
//       app.globalData.userInfo = userId
//       app.globalData.userName = res.data.user.username
//       app.globalData.telephone = res.data.user.telephone
//       ////console.log(app.globalData.telephone)
//       wx.switchTab({
//         url: '../person/person',
//       })
//     } else{
//       wx.showToast({
//         title: '登录失败',
//         icon: '',
//         duration: 2000
//       })
//     }
//   }
//   })


 // wx.request({
        // url: 'http://127.0.0.1:8080/demo/superadmin//getuserbyid',
        // data: { "userId": username },
        // method: 'GET',
        // success:function(res){
        // // var pass = res.data.user.password;
        // ////console.log(res)
        //   var userId = res.data.user.userId;
        //   if(res.data.user.password == password){
            
        //     app.globalData.userInfo = userId
        //     app.globalData.userName = res.data.user.username
        //     app.globalData.telephone = res.data.user.telephone
        //     ////console.log(app.globalData.telephone)
        //     wx.switchTab({
        //       url: '../person/person',
        //     })
        //   } else{
        //     wx.showToast({
        //       title: '登录失败',
        //       icon: '',
        //       duration: 2000
        //     })
        //   }
        // }
        // })


