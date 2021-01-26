// pages/person/person.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userId: " ",
    userName:" "
  },

  goEditPassword:function(e){

    wx.navigateTo({
      url: '../EditPassword/EditPassword',
    })
  },




  goInfor:function(e){
    var userId = e.currentTarget.dataset.userid
    wx.navigateTo({
      url: '../person/detailPerson/detailPerson?userId=' + userId,
    })
  },

  goPublish:function(){
    var that = this
    var app = getApp()
    if(app.globalData.userType == "C"){
      wx.navigateTo({
        url: '../person/publish/publish',
      })
    }else{
      wx.navigateTo({
        url: '../person_foreign/publish_foreign/publish_foreign',
      })

    }
  },
  goManage:function(e){
    var that = this 
    var app = getApp()
    if(app.globalData.userType == "C"){
      wx.navigateTo({
        url: '../person/manage/manage',
      })
  }else{
    wx.navigateTo({
      url: '../person_foreign/manage_foreign/manage_foreign',
    })
  }

  },

 
  goLoginOut:function(){
    var app = getApp()
    app.globalData.userInfo = null
    app.globalData.userName = null
    app.globalData.telephone = null
    wx.redirectTo({
      url: '../login/login',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 页面初始化 options为页面跳转所带来的参数
    var app = getApp();
    var userId = app.globalData.userInfo
    
    wx.request({
      url: "http://127.0.0.1:8080/demo/superadmin/getuserbyid",
      data: { "userId": app.globalData.userInfo },
      method: 'GET',
      success: function (res) {
        //console.log("request",res)
        var user = res.data.user;
        that.setData({
          userName:user.userName,
          userId:app.globalData.userInfo
        });   
      }   
    }) 
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