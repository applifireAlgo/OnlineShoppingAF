Ext.define('Onlineshopping.onlineshopping.web.shop.controller.retail.OrderProcessingController', {
     extend: 'Onlineshopping.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.OrderProcessingController',
     onprocessOrderclick: function(me, e, eOpts) {
          var jsonData = {};
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/ProcessOrderServiceWS/processOrder',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               },
               failure: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               }
          }, scope);
     }
});