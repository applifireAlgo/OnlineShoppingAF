Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.OrderMainMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "OrderMainMainController",
     "restURL": "/OrderMain",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.retail.OrderMainModel", "Onlineshopping.onlineshopping.web.shop.controller.retail.OrderMainMainController", "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.OrderMainViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "OrderMain",
               "name": "OrderMainTreeContainer",
               "itemId": "OrderMainTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "OrderMainTree",
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
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
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
                    "xtype": "form",
                    "displayName": "OrderMain",
                    "name": "OrderMain",
                    "itemId": "OrderMainForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "orderDate",
                                   "itemId": "orderDate",
                                   "xtype": "customDateField",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Date",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Date",
                                   "fieldId": "371BCCC7-088E-4629-AC68-B855724C1ACF",
                                   "columnWidth": 0.5,
                                   "bind": "{orderDate}"
                              }, {
                                   "name": "userId",
                                   "itemId": "userId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "userId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "userId",
                                   "fieldId": "4A6A34B5-1D59-45EA-ABD4-995280F27874",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "columnWidth": 0.5,
                                   "bind": "{userId}"
                              }, {
                                   "name": "total",
                                   "itemId": "total",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "OrderTotal",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "OrderTotal",
                                   "fieldId": "8D239E82-7067-4A3F-B003-E401ECAC70B1",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "columnWidth": 0.5,
                                   "bind": "{total}"
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "OrderDetail",
                         "title": "OrderDetail",
                         "name": "OrderDetail",
                         "itemId": "OrderDetailForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "itemId",
                                        "itemId": "itemId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Item",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Item<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "93588115-5A47-433D-862C-E0B1437D6F70",
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
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "price",
                                        "itemId": "price",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Price",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Price<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "EADFBF1D-A9C7-4884-B5BC-B644FBFBC8AC",
                                        "minValue": "0",
                                        "maxValue": "999999",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "qty",
                                        "itemId": "qty",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Quantity",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "EF85C415-78E7-494E-BEDB-63442DD93156",
                                        "minValue": "-2147483648",
                                        "maxValue": "2147483647",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "subTotal",
                                        "itemId": "subTotal",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Sub Total",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Sub Total<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "16902C23-0FBA-4DA1-B8FD-2C2B694CAE84",
                                        "minValue": "-9223372000000000000",
                                        "maxValue": "9223372000000000000",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 176,
                              "text": "Add OrderDetail",
                              "handler": "addOrderDetail"
                         }, {
                              "xtype": "grid",
                              "customWidgetType": "vdGrid",
                              "title": "OrderDetail",
                              "columnWidth": 1,
                              "itemId": "OrderDetailGrid",
                              "fieldLabel": "List",
                              "bindLevel": "orderDetail",
                              "listeners": {
                                   "select": "onOrderDetailGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "OrderDetailId",
                                   "text": "OrderDetailId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "orderdetId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Item",
                                   "text": "Item",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Price",
                                   "text": "Price",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "price",
                                   "flex": 1
                              }, {
                                   "header": "Quantity",
                                   "text": "Quantity",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "qty",
                                   "flex": 1
                              }, {
                                   "header": "Sub Total",
                                   "text": "Sub Total",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "subTotal",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "viewModel": "OrderMainViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "OrderMain",
                    "title": "Details Grid",
                    "name": "OrderMainGrid",
                    "itemId": "OrderMainGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "orderId",
                         "dataIndex": "orderId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Date",
                         "dataIndex": "orderDate",
                         "flex": 1
                    }, {
                         "header": "userId",
                         "dataIndex": "userId",
                         "flex": 1
                    }, {
                         "header": "OrderTotal",
                         "dataIndex": "total",
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
               "xtype": "form",
               "displayName": "OrderMain",
               "name": "OrderMain",
               "itemId": "OrderMainForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "orderDate",
                              "itemId": "orderDate",
                              "xtype": "customDateField",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Date",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Date",
                              "fieldId": "371BCCC7-088E-4629-AC68-B855724C1ACF",
                              "columnWidth": 0.5,
                              "bind": "{orderDate}"
                         }, {
                              "name": "userId",
                              "itemId": "userId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "userId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "userId",
                              "fieldId": "4A6A34B5-1D59-45EA-ABD4-995280F27874",
                              "minLength": "0",
                              "maxLength": "256",
                              "columnWidth": 0.5,
                              "bind": "{userId}"
                         }, {
                              "name": "total",
                              "itemId": "total",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "OrderTotal",
                              "margin": "5 5 5 5",
                              "fieldLabel": "OrderTotal",
                              "fieldId": "8D239E82-7067-4A3F-B003-E401ECAC70B1",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "columnWidth": 0.5,
                              "bind": "{total}"
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "OrderDetail",
                    "title": "OrderDetail",
                    "name": "OrderDetail",
                    "itemId": "OrderDetailForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "itemId",
                                   "itemId": "itemId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Item",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Item<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "93588115-5A47-433D-862C-E0B1437D6F70",
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
                                   "columnWidth": 0.5
                              }, {
                                   "name": "price",
                                   "itemId": "price",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Price",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Price<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "EADFBF1D-A9C7-4884-B5BC-B644FBFBC8AC",
                                   "minValue": "0",
                                   "maxValue": "999999",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "qty",
                                   "itemId": "qty",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "EF85C415-78E7-494E-BEDB-63442DD93156",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "subTotal",
                                   "itemId": "subTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sub Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sub Total<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "16902C23-0FBA-4DA1-B8FD-2C2B694CAE84",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 176,
                         "text": "Add OrderDetail",
                         "handler": "addOrderDetail"
                    }, {
                         "xtype": "grid",
                         "customWidgetType": "vdGrid",
                         "title": "OrderDetail",
                         "columnWidth": 1,
                         "itemId": "OrderDetailGrid",
                         "fieldLabel": "List",
                         "bindLevel": "orderDetail",
                         "listeners": {
                              "select": "onOrderDetailGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "OrderDetailId",
                              "text": "OrderDetailId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "orderdetId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Item",
                              "text": "Item",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Price",
                              "text": "Price",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "price",
                              "flex": 1
                         }, {
                              "header": "Quantity",
                              "text": "Quantity",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "qty",
                              "flex": 1
                         }, {
                              "header": "Sub Total",
                              "text": "Sub Total",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "subTotal",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "viewModel": "OrderMainViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});