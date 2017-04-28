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

        Ext.applyIf(me, {
            items: [
                {
                    type:'grid',
                    width:'40%',
                    height:'90%',
                    title:'电话联系人',
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