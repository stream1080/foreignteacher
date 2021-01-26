// pages/person_foreign/publish_foreign/publish_foreign.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  formSubmit: function (e) {
    var that = this;
    var app = getApp()
    var formData = e.detail.value;
    //console.log(formData)
    var url = "http://127.0.0.1:8080/demo/superadmin/addteacher";
    var x = {
      "userId":app.globalData.userInfo,
      "time":formData.time,
      "service":formData.service,
      "address": formData.address,
      "telephone": formData.telephone,
      "context": formData.context,
      "password":""
    }

    console.log(x)
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
      }
    })
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