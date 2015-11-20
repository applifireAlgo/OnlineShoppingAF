Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.OrderProcessing', {
     "xtype": "orderProcessing",
     "items": [{
          "xtype": "grids",
          "name": "cartDetails",
          "title": "Cart Details",
          "hiddenName": "Grid",
          "margin": 5,
          "collapseMode": "header",
          "border": true,
          "editTools": false,
          "features": [],
          "plugins": [{
               "ptype": "cellediting",
               "clicksToEdit": 1
          }],
          "columns": [{
               "xtype": "gridcolumn",
               "header": "Item",
               "dataIndex": "itemName",
               "flex": 1,
               "isColumn": true,
               "parentGridItemId": "hdicpci"
          }, {
               "xtype": "gridcolumn",
               "header": "Item Price",
               "dataIndex": "itemPrice",
               "flex": 1,
               "isColumn": true,
               "parentGridItemId": "hdicpci"
          }, {
               "xtype": "gridcolumn",
               "header": "Quantity",
               "dataIndex": "cartQty",
               "flex": 1,
               "isColumn": true,
               "parentGridItemId": "hdicpci"
          }, {
               "xtype": "gridcolumn",
               "header": "Sub Total",
               "dataIndex": "subTotal",
               "flex": 1,
               "isColumn": true,
               "parentGridItemId": "hdicpci"
          }],
          "itemId": "cjafbei",
          "store": {
               "autoLoad": true,
               "autoSync": true,
		"model":"Onlineshopping.onlineshopping.shared.shop.model.retail.OrderProcessingModel",
               "proxy": {
                    "type": "ajax",
                    "url": "secure/FetchCartDetailsServiceWS/fetchCartItems",
                    "actionMethods": {
                         "read": "POST"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "button",
          "name": "processOrder",
          "text": "Process Order",
          "margin": 5,
          "itemId": "chicemi",
          "listeners": {
               "click": "onprocessOrderclick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "elcdbei",
     "dockedItems": [],
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.retail.CartModel", null, "Onlineshopping.onlineshopping.web.shop.controller.retail.OrderProcessingController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.OrderProcessingViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.OrderProcessingModel", "Onlineshopping.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "OrderProcessingViewModel",
     "controller": "OrderProcessingController"
});
