Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.ItemCat', {
     "xtype": "itemCat",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "itemListP",
          "items": [],
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "C54F8032-8268-4FBC-84AA-825163D4B1A5",
               "uiClass": "Onlineshopping.onlineshopping.web.shop.view.retail.PartialItem",
               "uiType": 2,
               "url": "secure/FetchItemListWS/itemList",
               "requestMethodType": "POST"
          },
          "title": "ListPanel",
          "padding": 0,
          "margin": 5,
          "itemId": "heiohgi",
          "dockedItems": []
     }],
     "border": true,
     "title": "Form",
     "margin": 5,
     "itemId": "igaanbi",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "layout": "fit",
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.ItemCatController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.ItemCatViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemCatModel", "Onlineshopping.view.fw.component.ListViewBaseView"],
     "viewModel": "ItemCatViewModel",
     "controller": "ItemCatController"
});