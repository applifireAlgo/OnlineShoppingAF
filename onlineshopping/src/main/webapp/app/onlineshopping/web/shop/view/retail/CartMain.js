Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.CartMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "CartMainController",
     "restURL": "/Cart",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.CartMainController", "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel", "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.CartViewModel", "Ext.form.field.CustomDateField"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "CartFormGridContainer",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "region": "center",
               "layout": "border",
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "CartViewModel",
                    "xtype": "form",
                    "displayName": "Cart",
                    "title": "Cart",
                    "name": "Cart",
                    "itemId": "Cart",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "38B91095-D0C3-406A-8983-8D2D8EEC82F1",
                         "restURL": "Item",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel"
                         },
                         "forceSelection": true,
                         "bind": "{itemId}"
                    }, {
                         "name": "userId",
                         "itemId": "userId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "userId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "userId",
                         "fieldId": "3A4E6676-7E12-408A-BCB9-766879A474DF",
                         "restURL": "User",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel"
                         },
                         "bind": "{userId}"
                    }, {
                         "name": "cartQty",
                         "itemId": "cartQty",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Quantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Quantity<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "69EB3733-846B-48B1-ACFD-B6FA17C0A298",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bind": "{cartQty}"
                    }, {
                         "name": "subTotal",
                         "itemId": "subTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sub Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sub Total",
                         "fieldId": "C79EB668-471A-40FF-B4E8-598DFD766468",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bind": "{subTotal}"
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Item Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item Price",
                         "fieldId": "2F7464F3-0EE7-4B50-9A4B-FDB100C4D447",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bind": "{itemPrice}"
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item",
                         "fieldId": "B06E379D-D500-424E-B149-1991A295ADFA",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{itemName}"
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
                         "customId": 862,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 862,
                              "customId": 247
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 862,
                              "customId": 248,
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
                              "parentId": 862,
                              "customId": 249,
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
                    "xtype": "panel",
                    "layout": "border",
                    "customWidgetType": "vdPanel",
                    "title": "Details Grid",
                    "columns": [{
                         "header": "cartId",
                         "dataIndex": "cartId",
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
                         "header": "Item",
                         "dataIndex": "itemId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "userId",
                         "dataIndex": "userId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Quantity",
                         "dataIndex": "cartQty",
                         "flex": 1
                    }, {
                         "header": "Sub Total",
                         "dataIndex": "subTotal",
                         "flex": 1
                    }, {
                         "header": "Item Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Item",
                         "dataIndex": "itemName",
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
                    "items": [{
                         "xtype": "form",
                         "title": "Advance Search",
                         "region": "west",
                         "width": "20%",
                         "margin": "0 5 0 0",
                         "collapsible": true,
                         "collapsed": true,
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
                         "items": [{
                              "name": "userId",
                              "itemId": "userId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "userId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "userId",
                              "fieldId": "3A4E6676-7E12-408A-BCB9-766879A474DF",
                              "restURL": "User",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel"
                              }
                         }, {
                              "name": "itemPrice",
                              "itemId": "itemPrice",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Item Price",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Item Price",
                              "fieldId": "2F7464F3-0EE7-4B50-9A4B-FDB100C4D447",
                              "minValue": "0",
                              "maxValue": "10000000"
                         }, {
                              "name": "itemName",
                              "itemId": "itemName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Item",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Item",
                              "fieldId": "B06E379D-D500-424E-B149-1991A295ADFA",
                              "minLength": "0",
                              "maxLength": "256"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Cart",
                         "name": "CartGrid",
                         "itemId": "CartGrid",
                         "restURL": "/Cart",
                         "store": [],
                         "bodyPadding": 10,
                         "dockedItems": [{
                              "xtype": "toolbar",
                              "dock": "top",
                              "items": [{
                                   "xtype": "triggerfield",
                                   "emptyText": "search",
                                   "triggerCls": "",
                                   "listeners": {
                                        "change": "onTriggerfieldChange",
                                        "buffer": 250
                                   }
                              }]
                         }],
                         "columns": [{
                              "header": "cartId",
                              "dataIndex": "cartId",
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
                              "header": "Item",
                              "dataIndex": "itemId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "userId",
                              "dataIndex": "userId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Quantity",
                              "dataIndex": "cartQty",
                              "flex": 1
                         }, {
                              "header": "Sub Total",
                              "dataIndex": "subTotal",
                              "flex": 1
                         }, {
                              "header": "Item Price",
                              "dataIndex": "itemPrice",
                              "flex": 1
                         }, {
                              "header": "Item",
                              "dataIndex": "itemName",
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
                         }
                    }],
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
               "viewModel": "CartViewModel",
               "xtype": "form",
               "displayName": "Cart",
               "title": "Cart",
               "name": "Cart",
               "itemId": "Cart",
               "bodyPadding": 10,
               "items": [{
                    "name": "itemId",
                    "itemId": "itemId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "38B91095-D0C3-406A-8983-8D2D8EEC82F1",
                    "restURL": "Item",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel"
                    },
                    "forceSelection": true,
                    "bind": "{itemId}"
               }, {
                    "name": "userId",
                    "itemId": "userId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "userId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "userId",
                    "fieldId": "3A4E6676-7E12-408A-BCB9-766879A474DF",
                    "restURL": "User",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel"
                    },
                    "bind": "{userId}"
               }, {
                    "name": "cartQty",
                    "itemId": "cartQty",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Quantity",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Quantity<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "69EB3733-846B-48B1-ACFD-B6FA17C0A298",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bind": "{cartQty}"
               }, {
                    "name": "subTotal",
                    "itemId": "subTotal",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Sub Total",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Sub Total",
                    "fieldId": "C79EB668-471A-40FF-B4E8-598DFD766468",
                    "minValue": "0",
                    "maxValue": "10000000",
                    "bind": "{subTotal}"
               }, {
                    "name": "itemPrice",
                    "itemId": "itemPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Item Price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item Price",
                    "fieldId": "2F7464F3-0EE7-4B50-9A4B-FDB100C4D447",
                    "minValue": "0",
                    "maxValue": "10000000",
                    "bind": "{itemPrice}"
               }, {
                    "name": "itemName",
                    "itemId": "itemName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item",
                    "fieldId": "B06E379D-D500-424E-B149-1991A295ADFA",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{itemName}"
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
                    "customId": 862,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 862,
                         "customId": 247
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 862,
                         "customId": 248,
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
                         "parentId": 862,
                         "customId": 249,
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