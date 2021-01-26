// pages/foreign/foreign.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[]

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
    wx.request({
      url: 'http://127.0.0.1:8080/demo/superadmin/listteacher',
      method: 'GET',
      data: {},
      success: function(res){
        //  console.log("request",res)
        //  var foreign = res.data.teacherList;
        //console.log(res)
        var list = res.data.teacherList;
        
        for(let i=0;i<list.length;i++){
          if(list[i].time!=null){
            var abc = new Date(list[i].time)
            list[i].time = abc.toLocaleDateString()
            //console.log(list[i].time)
            list[i].url = "../../images/ft" + (i+1) + ".jpg" 
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

  },

  detail:function(){
    wx.navigateTo({
      url: '../foreign/detail/detail',
    })
  }
})