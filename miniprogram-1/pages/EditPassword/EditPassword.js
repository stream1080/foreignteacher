// pages/EditPassword/EditPassword.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    oldPassword:'',
    newPassword:'',
    idenPassword:''
  },


  formSubmit: function (e) {
    var that = this;
    var app = getApp()
    var formData = e.detail.value;
    if(formData.newPassword.length == 0 || formData.idenPassword.length == 0 || formData.oldPassword.length == 0){
      wx.showToast({
        title: '用户名或密码不能为空',
        icon: "none",
        duration: 2000
      })
    }

    else if(formData.oldPassword == app.globalData.password && formData.idenPassword == formData.newPassword){
      var url = "http://127.0.0.1:8080/demo/superadmin/modifyuser";
      var x = {
        
         "userId":app.globalData.userInfo,
         "password":formData.newPassword
        // "time":formData.time,
        // "service":formData.service,
        // "address": formData.address,
        // "telephone": formData.telephone,
        // "context": formData.context
      }
      wx.request({
        url: url,
        data: JSON.stringify(x),
        method: 'POST',
        header: {
          'Content-Type': 'application/json'
        },
        success: function (res) {
          //console.log(res)
          var result = res.data.success
          var toastText = "操作成功！";
          if (result != true) {
            toastText = "操作失败" + res.data.errMsg;
          }
          wx.showToast({
            title: toastText,
            icon: 'none',
            duration: 2000
          });
          // wx.navigateBack({
          //   delta: 1,
          // })
          wx.navigateTo({
            url: '../login/login',
          })
        }
      })

    }else{
      wx.showToast({
        title: "旧密码错误或者两次密码不一致",
        icon: 'none',
        duration: 2000
      });
    }
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

  }
})