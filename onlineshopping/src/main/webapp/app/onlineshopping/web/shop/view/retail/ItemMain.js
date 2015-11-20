Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.ItemMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ItemMainController",
     "restURL": "/Item",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel", "Onlineshopping.onlineshopping.web.shop.controller.retail.ItemMainController", "Onlineshopping.onlineshopping.shared.shop.model.retail.ProductModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.BrandModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.CategoryModel", "Onlineshopping.view.fw.component.FileUploadComponent", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.ItemViewModel", "Ext.form.field.CustomDateField"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Item",
               "name": "ItemTreeContainer",
               "itemId": "ItemTreeContainer",
               "restURL": "/Item",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ItemTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "ItemViewModel",
                    "xtype": "form",
                    "displayName": "Item",
                    "title": "Item",
                    "name": "Item",
                    "itemId": "Item",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "product",
                         "itemId": "product",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CC837FE1-7A1E-4444-98DF-C303CEC051E1",
                         "restURL": "Product",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.ProductModel"
                         },
                         "forceSelection": true,
                         "bind": "{product}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onProductChange"
                         }
                    }, {
                         "name": "brand",
                         "itemId": "brand",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C9442F99-A24E-48CE-851D-41019307FE0E",
                         "restURL": "Brand",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.BrandModel"
                         },
                         "forceSelection": true,
                         "bind": "{brand}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onBrandChange"
                         }
                    }, {
                         "name": "category",
                         "itemId": "category",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3D4D0F19-0F40-49A1-A47B-B742A6405830",
                         "restURL": "Category",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.CategoryModel"
                         },
                         "forceSelection": true,
                         "bind": "{category}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D8804F72-FBAE-46F3-A077-566984152099",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{itemName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4466FCDA-B833-4F61-A9F6-F62C6A865E7A",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bind": "{itemPrice}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemStock",
                         "itemId": "itemStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Stock<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F5F6574F-1359-4175-9284-3AB39F98AA0C",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bind": "{itemStock}",
                         "columnWidth": 0.5
                    }, {
                         "items": [{
                              "name": "filePathHidden",
                              "xtype": "hidden",
                              "itemId": "filePathHidden",
                              "bind": "{itemIcon}"
                         }, {
                              "name": "itemIcon",
                              "itemId": "itemIcon",
                              "xtype": "fileupload",
                              "customWidgetType": "vdFileUpload",
                              "displayName": "Icon",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Icon<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "82C2060B-1FAE-4EEC-9463-C4532D53719D",
                              "columnWidth": 0.5
                         }]
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 668,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 668,
                              "customId": 621
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 668,
                              "customId": 622,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 668,
                              "customId": 623,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Item",
                    "title": "Details Grid",
                    "name": "ItemGrid",
                    "itemId": "ItemGrid",
                    "restURL": "/Item",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "itemId",
                         "dataIndex": "itemId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Product",
                         "dataIndex": "product",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Brand",
                         "dataIndex": "brand",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "category",
                         "dataIndex": "category",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Item",
                         "dataIndex": "itemName",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Stock",
                         "dataIndex": "itemStock",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "itemIcon",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "ItemViewModel",
               "xtype": "form",
               "displayName": "Item",
               "title": "Item",
               "name": "Item",
               "itemId": "Item",
               "bodyPadding": 10,
               "items": [{
                    "name": "product",
                    "itemId": "product",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CC837FE1-7A1E-4444-98DF-C303CEC051E1",
                    "restURL": "Product",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.ProductModel"
                    },
                    "forceSelection": true,
                    "bind": "{product}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onProductChange"
                    }
               }, {
                    "name": "brand",
                    "itemId": "brand",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Brand",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Brand<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C9442F99-A24E-48CE-851D-41019307FE0E",
                    "restURL": "Brand",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.BrandModel"
                    },
                    "forceSelection": true,
                    "bind": "{brand}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onBrandChange"
                    }
               }, {
                    "name": "category",
                    "itemId": "category",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3D4D0F19-0F40-49A1-A47B-B742A6405830",
                    "restURL": "Category",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.CategoryModel"
                    },
                    "forceSelection": true,
                    "bind": "{category}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemName",
                    "itemId": "itemName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D8804F72-FBAE-46F3-A077-566984152099",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{itemName}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemPrice",
                    "itemId": "itemPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Price<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4466FCDA-B833-4F61-A9F6-F62C6A865E7A",
                    "minValue": "-9223372000000000000",
                    "maxValue": "9223372000000000000",
                    "bind": "{itemPrice}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemStock",
                    "itemId": "itemStock",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Stock",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Stock<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F5F6574F-1359-4175-9284-3AB39F98AA0C",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bind": "{itemStock}",
                    "columnWidth": 0.5
               }, {
                    "items": [{
                         "name": "filePathHidden",
                         "xtype": "hidden",
                         "itemId": "filePathHidden",
                         "bind": "{itemIcon}"
                    }, {
                         "name": "itemIcon",
                         "itemId": "itemIcon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "82C2060B-1FAE-4EEC-9463-C4532D53719D",
                         "columnWidth": 0.5
                    }]
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 668,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 668,
                         "customId": 621
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 668,
                         "customId": 622,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 668,
                         "customId": 623,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});