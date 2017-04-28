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
                    width:800,
                    height:400,
                    title:'test'
                }
            ]
        });

        this.callParent(arguments);
    }

});