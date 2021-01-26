// pages/foreign/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userName: " ",
    nationality: " ",
    language: " ",
    service: "",
    address: " ",
    telephone: " ",
    context:" "
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 页面初始化 options为页面跳转所带来的参数
    //console.log(options)
    if (options.teacherId == undefined) {
      return;
    }
    this.setData({
      teacherId: options.teacherId
    });

    wx.request({
      url: "http://127.0.0.1:8080/demo/superadmin/getteacherbyid",
      data: { "teacherId": options.teacherId },
      method: 'GET',
      success: function (res) {
        console.log("request",res)
        var teacher = res.data.teacher;
        var abc = new Date(teacher.time)
        teacher.time = abc.toLocaleDateString()
        if (teacher == undefined) {
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            service: teacher.service,
            time: teacher.time,
            address: teacher.address,
            telephone: teacher.telephone,
            context:teacher.context
          });
        }
      }
    })

    console.log(options)
    wx.request({
      url: "http://127.0.0.1:8080/demo/superadmin/getuserbyid",
      data: { "userId": options.userId },
      method: 'GET',
      success: function (res) {
        console.log("request",res)
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
            nationality: user.nationality,
            language: user.language,
          });
        }
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

  },

  callTelephone:function(e){
    wx.showModal({
      cancelColor: 'cancelColor',
      title: '提示',
      content: '确定要拨打电话 [' + e.target.dataset.telephone + '] 预约吗？',
      success:function(sm){
        if(sm.confirm){
          wx.navigateBack({
            delta: 1,
          })
        }
      }
    })
  }


})