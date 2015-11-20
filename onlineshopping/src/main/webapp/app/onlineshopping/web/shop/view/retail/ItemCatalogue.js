Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.ItemCatalogue', {
     "xtype": "itemCatalogue",
     "name": "itemcatalogue",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "items",
          "items": [],
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "898BEE22-185F-4A87-B49D-4117FC4B187E",
               "uiClass": "Onlineshopping.onlineshopping.web.shop.view.retail.ItemTemplate",
               "uiType": 2,
               "url": "secure/FetchItemListWS/itemList",
               "requestMethodType": "POST"
          },
          "title": "Items",
          "padding": 0,
          "margin": 5,
          "itemId": "ejmaioi",
          "dockedItems": []
     }],
     "border": true,
     "title": "Item Catalogue",
     "margin": 5,
     "itemId": "danbeki",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "layout": "fit",
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.ItemCatalogueController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.ItemCatalogueViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemCatalogueModel", "Onlineshopping.view.fw.component.ListViewBaseView"],
     "viewModel": "ItemCatalogueViewModel",
     "controller": "ItemCatalogueController"
});