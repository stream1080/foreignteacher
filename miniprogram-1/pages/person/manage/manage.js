// pages/person/manage/manage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userId:" ",
    telephone: " ",
    list:[]

  },

  deleteRecruit:function(e){
    var that =this
    wx.showModal({
      title: '提示',
      content: '确定删除这个发布吗？',
      success: function (sm) {
         if (sm.confirm) {
          wx.request({
            url: "http://127.0.0.1:8080/demo/superadmin/removerecruit",
            data: { "recruitId": e.target.dataset.recruitid },
            method: 'GET',
            success: function (res) {
              console.log(res)
              var result = res.data.success
              var toastText = "删除成功！";
              if (result != true) {
                toastText = "删除失败" + res.data.errMsg;
              } else{
                that.data.list.splice(e.target.dataset.index, 1)
                //渲染数据
                that.setData({
                  list: that.data.list
                });
              }
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              });
            }
            })
      }
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
    var that = this;
    var app = getApp()
    var userId = app.globalData.userInfo
    wx.request({
      url: 'http://127.0.0.1:8080/demo/superadmin/listrecruit',
      method: 'GET',
      data: {},
      success: function(res){
        //console.log(res.data.recruitList)
        var list = res.data.recruitList;
        for(let i=0;i<list.length;i++){
          if(list[i].userId == userId){
            var abc = new Date(list[i].time)
            list[i].time = abc.toLocaleDateString()
          //list[i].url = "../../images/wbb" + (i+1) + ".jpg"
          }
        }
        if(list == null){
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: 'toastText',
            icon: '',
            duration: 2000
          });
        }else{
          that.setData({
            telephone: app.globalData.telephone,
            userId:userId,
            list: list
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