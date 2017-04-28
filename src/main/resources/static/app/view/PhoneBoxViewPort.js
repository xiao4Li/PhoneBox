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
                    store:linkmanStore,
                    columns: [
                        {header: '姓名', width:'120',dataIndex: 'name'},
                        {header: '公司', width:'200',dataIndex: 'company'},
                        {header:'职位',dataIndex:'title',flex:1},
                        {header:'电话号码',dataIndex:'phoneNo',flex:1}
                    ],
                    tbar: [
                        {
                            xtype: 'button',
                            text:'添加'
                        },{
                            xtype: 'button',
                            text:'修改'
                        },{
                            xtype: 'button',
                            text:'删除'
                        },
                        '->',
                        {
                            xtype: 'button',
                            text:'查询'
                        }
                    ]
                }
            ]
        });

        this.callParent(arguments);
    }

});