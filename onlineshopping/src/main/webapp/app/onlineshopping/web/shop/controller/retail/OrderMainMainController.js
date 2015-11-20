Ext.define('Onlineshopping.onlineshopping.web.shop.controller.retail.OrderMainMainController', {
     extend: 'Onlineshopping.view.fw.frameworkController.AggregateViewController',
     alias: 'controller.OrderMainMainController',
     init: function() {
          if (this.view.disableDB != null && this.view.disableDB) {
               this.hideDataBrowser();
          } else {
               this.renderTreeGridData();
          }
          this.itemIdLoad();
     },
     itemIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Item/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#itemId');
                    scope.sender.controller.assignAllComboData(scope.sender, 'itemId', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#itemId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     renderTreeGridData: function(responseData) {
          if (responseData == null) {
               responseData = this.fetchDataAjaxCall();
          }
          if (responseData.response.success) {
               var data = responseData.response.data;
               var tree = this.view.down('#OrderMainTree');
               var rootNode = tree.getRootNode();
               rootNode.removeAll();
               for (var int = 0; int < data.length; int++) {
                    var childNode = {
                         text: data[int].primaryDisplay,
                         bConfig: data[int],
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
               tree.getStore().sort('text', 'ASC');
               this.setGridData(data);
               var compRef = this.view.down('#OrderMainTree');
          } else if (!sessionTimeOutFlag) {
               Ext.Msg.alert('Server Response', responseData.response.message);
          }
     },
     /*********************Main Controller Functions*********************************/
     onDeleteActionColumnClickMainGrid: function(grid, rowIndex) {
          var recordId = grid.store.data.items[rowIndex].data.orderId;
          me = this;
          Ext.MessageBox.confirm({
               title: 'Confirm',
               msg: 'Delete Record',
               buttons: Ext.MessageBox.YESNO,
               fn: function(clickedButtonId) {
                    if (clickedButtonId == 'yes') {
                         me.deleteRecord(recordId);
                    }
               },
               animateTarget: this,
               icon: Ext.MessageBox.QUESTION
          })
     },
     deleteRecord: function(recordId) {
          var restURL = this.view.restURL;
          var url = 'secure' + restURL + '/' + recordId;
          Ext.Ajax.request({
               url: url,
               method: 'DELETE',
               jsonData: {},
               success: function(response, opts) {
                    if (response.status == 204) {
                         Ext.Msg.alert('Server Response', 'Record Deleted Sucessfully');
                         me.refreshMainForm();
                    } else {
                         responseData = Ext.JSON.decode(response.responseText);
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
     refreshMainForm: function(but) {
          this.fetchData();
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          }
     },
     resetForm: function(but) {
          var form = but.up('form');
          form.reset();
          var data = form.viewModel.getData();
          for (var element in data) {
               data[element] = '';
          }
          var gridOrderDetail = but.up('form').down('#OrderDetailGrid');
          gridOrderDetail.getStore().removeAll();
     },
     hideDataBrowser: function() {
          debugger;
          var form = this.view.down('#OrderMain');
          var grid = this.view.down('#OrderMainGrid');
          var tree = this.view.down('#OrderMainTreeContainer');
          this.view.down('#addNewForm').destroy();
          grid.setHidden(true);
          tree.setHidden(true);
          if (this.view.primaryKey != null) {
               this.findById(this.view.primaryKey);
          }
     },
     fetchDataAjaxCall: function() {
          var url = this.getView().restURL;
          var me = this;
          var data = null;
          Ext.Ajax.request({
               url: 'secure' + url + '/findAll',
               method: 'GET',
               maskEnable: true,
               async: false,
               jsonData: {},
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    data = responseData;
                    me.addCommunicationLog(response, true);
               },
               failure: function(response, scope) {
                    debugger;
                    var responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
                    me.addCommunicationLog(response, false);
               }
          }, this);
          return data;
     },
     onTreeRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          var tree = this.view.down('#OrderMainTree');
          var rootNode = tree.getRootNode();
          rootNode.removeAll();
          for (var int = 0; int < data.length; int++) {
               var childNode = {
                    text: data[int].primaryDisplay,
                    bConfig: data[int],
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
          tree.getStore().sort('text', 'ASC');
     },
     onGridRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          this.setGridData(data);
     },
     refreshMainForm: function(but) {
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          }
     },
     /********************************Tree Controller Functions**********************************/
     onFilterClick: function(but, evt) {
          debugger;
          var currentObject = this.getView();
          var data = but.up('form').getForm().getValues();
          var searchData = {};
          for (key in data) {
               if (data[key] != null && data[key] != '') {
                    searchData[key] = data[key];
               }
          }
          Ext.Ajax.request({
               url: 'secure' + currentObject.restURL + '/search',
               method: 'POST',
               maskEnable: true,
               maskEle: currentObject,
               view: currentObject,
               jsonData: Ext.JSON.encode(searchData),
               success: function(response, currentObject) {
                    currentObject.view.controller.renderTreeGridData(response);
               },
               failure: function(response, currentObject) {
                    Ext.MessageBox.show({
                         title: 'Error',
                         msg: response.statusText,
                         icon: Ext.MessageBox.ERROR
                    });
                    var currentView = currentObject.view;
                    var compRef = scope.sender.view.down('#OrderMainTree');
                    currentView.controller.addCommunicationLog(response, false, compRef);
               }
          });
     },
     treeClick: function(me, record, item, index, e, eOpts) {
          if (record.data.leaf) {
               var OrderMain = this.view.down('#OrderMainForm');
               OrderMain.reset();
               var gridPanel = this.view.down('#OrderMainGrid');
               var foundRecord = gridPanel.store.findRecord('primaryKey', record.data.bConfig.primaryKey);
               if (gridPanel && foundRecord) {
                    gridPanel.setSelection(foundRecord);
               }
          }
          var formPanel = this.getView().up().down('#OrderMainForm');
          var vm = formPanel.getViewModel();
          var data = record.data.bConfig;
          vm.setData(data);
          for (var key in data) {
               if (formPanel.down('#' + key) != null && formPanel.down('#' + key).xtype == 'datefield') {
                    formPanel.down('#' + key).setValue(new Date(data[key]));
               }
          }
          var OrderDetailGrid = formPanel.down('#OrderDetailGrid');
          OrderDetailGrid.store.loadData(data.orderDetail);
          OrderDetailGrid.setSelection(0);
          this.showFirstCard(formPanel);
          tabPanel = formPanel.up('tabpanel');
          tabPanel.setActiveTab(0);
     },
     /********************************Grid Controller Functions***********************************/
     onGridItemClick: function(me, record, item, index, e, eOpts) {
          var treePanel = this.view.up().up().down('#OrderMainTree');
          var foundNode = this.findChild(treePanel.getRootNode(), 'primaryKey', record.data.primaryKey);
          if (treePanel && foundNode) {
               treePanel.setSelection(foundNode);
          }
          var formPanel = this.getView().up().down('#OrderMainForm');
          var vm = formPanel.getViewModel();
          var data = record.data;
          vm.setData(data);
          for (var key in data) {
               if (formPanel.down('#' + key) != null && formPanel.down('#' + key).xtype == 'datefield') {
                    formPanel.down('#' + key).setValue(new Date(data[key]));
               }
          }
          var OrderDetailGrid = formPanel.down('#OrderDetailGrid');
          OrderDetailGrid.store.loadData(data.orderDetail);
          OrderDetailGrid.setSelection(0);
          this.showFirstCard(formPanel);
          tabPanel = formPanel.up('tabpanel');
          tabPanel.setActiveTab(0);
     },
     renderFormValue: function(val, me) {
          store = this.view.up().down('#OrderMain').down('#' + me.column.dataIndex + '').store;
          if (store.data.length == 0) {
               return '';
          }
          var displayValue = store.findRecord('primaryKey', val).data.primaryDisplay;
          return displayValue != null ? displayValue : '';
     },
     setGridData: function(data) {
          var gridStore = this.view.down('#OrderMainGrid').store;
          gridStore.removeAll();
          gridStore.add(data);
          gridStore.sort('primaryDisplay', 'ASC');
     },
     /********************************Form Controller Functions***********************************/
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               controller: me,
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, request) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         request.controller.loadData(responseData);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
               }
          }, this);
     },
     loadData: function(responseData) {
          this.view.down('#OrderMainForm').getViewModel().setData(responseData.response.data);
     },
     fetchDataFromStore: function(store) {
          storeItems = store.data.items;
          obj = {};
          arr = [];
          for (counter in storeItems) {
               arr.push(storeItems[counter].data);
          }
          return obj['objArr'] = arr;
     },
     addOrderDetail: function(but) {
          var formOrderDetail = but.up();
          var gridOrderDetail = but.up().up().down('#OrderDetailGrid');
          if (formOrderDetail.isValid()) {
               var values = formOrderDetail.getValues();
               var duplicateRecordFound = false;
               var records = gridOrderDetail.getStore().data.items;
               var duplicateRecordFound = false;
               for (var index = 0; index < records.length; index++) {
                    if (this.isDuplicateRecord(values, records[index].data)) {
                         duplicateRecordFound = true;
                         break;
                    }
               }
               if (!duplicateRecordFound) {
                    var modifiedValues = this.modifyFormValues(values, formOrderDetail);
                    gridOrderDetail.getStore().add(modifiedValues);
               }
               formOrderDetail.reset();
          }
     },
     onOrderDetailGridItemClick: function(cellModel, record, rowIndex, columnIndex, eOpts, comp) {
          var form;
          if (comp != null) {
               form = comp.up();
          } else {
               form = this.view.down('#OrderDetailForm');
          }
          form.loadRecord(record)
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var index = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(index).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     saveForm: function(but, evt) {
          debugger;
          var form = but.up('form');
          var firstCard = form.down('#form0');
          if (!firstCard.getForm().isValid()) {
               this.showCard(form, firstCard);
               return;
          }
          var OrderDetailForm = form.down('#OrderDetailForm');
          var OrderDetail = form.down('#OrderDetailGrid');
          if (!(OrderDetailForm.isValid() || OrderDetail.store.getCount() != 0)) {
               this.showCard(form, OrderDetailForm);
               return;
          }
          this.addOrderDetail(OrderDetailForm.down('button'));
          var data = form.getViewModel().getData();
          var OrderDetailBindLavel = OrderDetail.bindLevel;
          delete data[OrderDetailBindLavel];
          this.createObject(data, OrderDetailBindLavel, this.fetchDataFromStore(OrderDetail.getStore()));
          var jsonData = this.createFinalJson(data);
          var method;
          if (jsonData.primaryKey == null) {
               method = 'POST'
          } else {
               method = 'PUT'
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               jsonData: jsonData,
               success: function(response, opts) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         me.refreshMainForm(but);
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
});