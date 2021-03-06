Ext.define('Onlineshopping.onlineshopping.shared.shop.model.retail.BrandModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "brandId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "product",
          "reference": "Product",
          "defaultValue": ""
     }, {
          "name": "brandName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});