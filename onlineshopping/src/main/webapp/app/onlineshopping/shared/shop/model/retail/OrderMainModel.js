Ext.define('Onlineshopping.onlineshopping.shared.shop.model.retail.OrderMainModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "orderId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "orderDate",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "userId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "total",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "OrderDetail",
          "reference": "OrderDetailModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});