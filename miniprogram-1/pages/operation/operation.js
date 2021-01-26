// pages/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userId: undefined,
    userName: '',
    age: '',
    sex: '',
    telephone:'',
    address: '',
    nationality: '',
    language: '',
    addUrl: "http://127.0.0.1:8080/demo/superadmin/adduser",
    modifyUrl: "http://127.0.0.1:8080/demo/superadmin/modifyuser"
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var app = getApp()
    var userId = app.globalData.userInfo
    // 页面初始化 options为页面跳转所带来的参数
    //console.log(options)
    console.log(userId)
    if (app.globalData.userInfo == ' ') {
      return;
    }else{
      wx.request({
        url: "http://127.0.0.1:8080/demo/superadmin/getuserbyid",
        data: { "userId": app.globalData.userInfo },
        method: 'GET',
        success: function (res) {
          //console.log("request",res)
          var user = res.data.user;
          if (user == undefined) {
            var toastText = '获取数据失败' + res.data.errMsg;
            wx.showToast({
              title: toastText,
              icon: '',
              duration: 2000
            });
          } else {
            that.setData({
              userName: user.userName,
              age: user.age,
              sex: user.sex,
              telephone: user.telephone,
              address: user.address,
              nationality:user.nationality,
              language:user.language
            });
          }
        }
      })
  }
 
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
  //   var that = this
  //   // console.log(userId)
  //   var app = getApp()
  //   if(app.globalData.userInfo != null){
  //   wx.request({
  //     url: "http://127.0.0.1:8080/demo/superadmin/getuserbyid",
  //     data: { "userId": this.data.userId },
  //     method: 'GET',
  //     success: function (res) {
  //       //console.log("request",res)
  //       var user = res.data.user;
  //       if (user == undefined) {
  //         var toastText = '获取数据失败' + res.data.errMsg;
  //         wx.showToast({
  //           title: toastText,
  //           icon: '',
  //           duration: 2000
  //         });
  //       } else {
  //         that.setData({
  //           userName: user.userName,
  //           age: user.age,
  //           sex: user.sex,
  //           telephone: user.telephone,
  //           address: user.address
  //         });
  //       }
  //     }
  //   })
  // }
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
  /**
   * 用户信息表单提交
   * @param {*} e 
   */
  formSubmit: function (e) {
    //console.log(e)
    var that = this;
    var formData = e.detail.value;
    console.log(formData)
    var url = that.data.addUrl;
    var x = {
      "userName":formData.userName,
      "sex":formData.sex,
      "age":formData.age,
      "telephone":formData.telephone,
      "address": formData.address,
      "password":formData.password
    }
    if (that.data.userId != undefined) {
      x.userId = that.data.userId;
      url = that.data.modifyUrl;
    }
    wx.request({
      url: url,
      data: JSON.stringify(x),
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        console.log(res)
        var result = res.data.success
        var toastText = "操作成功！";
        if (result != true) {
          toastText = "操作失败" + res.data.errMsg;
        }
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });
        wx.navigateBack({
          delta: 1,
        })

        // if (that.data.userId == undefined) {
        //   wx.redirectTo({
        //     url: '../list/list',
        //   })
        // }
      },
    })
  }
})