// pages/person/detailPerson/detailPerson.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userId: " ",
    userName: " ",
    sex:" ",
    age:" ",
    address: " ",
    telephone:" ",
    nationality:" ",
    language:" ",
  },

  editInfo:function(e){
    wx.navigateTo({
      url: '../../operation/operation'
    })


  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 页面初始化 options为页面跳转所带来的参数
   console.log(options)
    if (options.userId == undefined) {
      return;
    }
    this.setData({
      userId: options.userId
    });

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
    var that =this
    var app = getApp()
    //this.data.userId
    wx.request({
      url: "http://127.0.0.1:8080/demo/superadmin/getuserbyid",
      data: { "userId":  app.globalData.userInfo},
      method: 'GET',
      success: function (res) {
        console.log("request",res)
        var user = res.data.user;
        var abc = new Date(user.time)
        user.time = abc.toLocaleDateString()
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
            sex: user.sex,
            age: user.age,
            address: user.address,
            telephone: user.telephone,
            nationality: user.nationality,
            language: user.language
          });
        }
      }
    })
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