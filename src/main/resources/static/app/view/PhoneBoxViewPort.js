/**
 *@Author:  liqi@youbangsoft.com
 *@Date:  2017/4/28
 *@Description: [ xxxx ]
 *@Version: 1.0
 */
Ext.define('PhoneBox.view.PhoneBoxViewPort', {
    extend: 'Ext.container.Viewport',
    layout:'center',
    initComponent: function () {
        var me = this;

        var linkmanStore = Ext.create('Ext.data.Store', {
            fields:["name"],
            proxy: {
                type: 'ajax',
                url: 'listLinkman',
                reader: {
                    type: 'json'
                }
            },
            autoLoad: true
        });

        Ext.applyIf(me, {
            items: [
                {
                    xtype:'grid',
                    width:'30%',
                    height:'80%',
                    title:'电话联系人',
                    columnLines : true,
                    store:linkmanStore,
                    selModel: {
                        injectCheckbox: 0,
                        mode: "MULTI",     //"SINGLE"/"SIMPLE"/"MULTI"
                        checkOnly: true     //只能通过checkbox选择
                    },
                    selType: "checkboxmodel",
                    columns: [
                        {header: '姓名', width:'120',dataIndex: 'name'},
                        {header: '公司', width:'200',dataIndex: 'company'},
                        {header:'职位',dataIndex:'title',flex:1},
                        {header:'电话号码',dataIndex:'phoneNo',flex:1}
                    ],
                    tbar: [
                        {
                            xtype: 'button',
                            text:'添加',
                            handler:function(){
                                Ext.create('Ext.window.Window',{
                                    title:'添加联系人',
                                    modal : true,
                                    width:'20%',
                                    height:'22%',
                                    layout:'fit',
                                    items:[
                                        Ext.create('PhoneBox.view.LinkmanInfo',{
                                            ref:me
                                        })
                                    ]
                                }).show();
                            }
                        },{
                            xtype: 'button',
                            text:'修改',
                            handler:function(){
                                var records = me.down('grid').getSelectionModel().getSelection();
                                if(records.length != 1){
                                    Ext.Msg.alert("系统提示","请选择一条记录修改")
                                    return;
                                }else{
                                    Ext.create('Ext.window.Window',{
                                        title:'添加联系人',
                                        modal : true,
                                        width:'20%',
                                        height:'22%',
                                        layout:'fit',
                                        items:[
                                            Ext.create('PhoneBox.view.LinkmanInfo',
                                                {ref:me,linkmanInfo:records[0]})
                                        ]
                                    }).show();
                                }
                            }
                        },{
                            xtype: 'button',
                            text:'删除',
                            handler:function(){
                                var records = me.down('grid').getSelectionModel().getSelection();
                                if(records.length < 1){
                                    Ext.Msg.alert("系统提示","请选择记录删除")
                                    return;
                                }else{
                                    var idArray = [];
                                    for(var i=0; i < records.length ; i ++){
                                        var item = records[i];
                                        idArray.push(item.get("linkmanId"));
                                    }
                                    Ext.Ajax.request({
                                        url: 'delLinkmanByIds',
                                        params: {
                                            ids:  JSON.stringify(idArray)
                                        },
                                        success: function(response){
                                            me.down('grid').getStore().reload();
                                        },
                                        failure: function(form, action) {
                                            me.down('grid').getStore().reload();
                                        }
                                    });
                                }
                            }
                        }
                    ]
                }
            ]
        });

        this.callParent(arguments);
    }

});