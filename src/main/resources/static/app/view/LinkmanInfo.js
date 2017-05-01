/**
 * @Description: [XXX XXX]
 * @Author: [qi.li@funi365.com]
 * @CreateDate: 2017-05-01 19:41
 * @UpdateUser: [] 
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version:    [v1.0] 
 **/
Ext.define('PhoneBox.view.LinkmanInfo', {
    extend: 'Ext.form.Panel',
    defaultType: 'textfield',
    bodyPadding: 5,
    width: 350,
    // 表单域 Fields 将被竖直排列, 占满整个宽度
    layout: 'anchor',
    defaults: {
        anchor: '100%'
    },
    initComponent: function () {
        var me = this;

        var url =   'addLinkman';

        var info = me.config.linkmanInfo;

        if(info){
            url = "updateLinkman";
        }

        Ext.applyIf(me, {
            'url':url,
            items: [
                {
                    name: 'linkmanId',
                    value:info ? info.get("linkmanId") : null,
                    hidden:true
                },
                {
                    fieldLabel: '姓名',
                    name: 'name',
                    value:info ? info.get("name") : null,
                    allowBlank: false
            },{
                fieldLabel: '公司',
                name: 'company',
                    value:info ? info.get("company") : null,
                allowBlank: false
            },
                {
                    fieldLabel: '职位',
                    name: 'title',
                    value:info ? info.get("title") : null,
                    allowBlank: false
                },
                {
                    fieldLabel: '电话号码',
                    name: 'phoneNo',
                    value:info ? info.get("phoneNo") : null,
                    allowBlank: false
                }
            ],
            buttons: [{
                text: '重置',
                handler: function() {
                    this.up('form').getForm().reset();
                }
            }, {
                text: '保存',
                formBind: true, //only enabled once the form is valid
                disabled: true,
                handler: function() {
                    var form = this.up('form').getForm();
                    if (form.isValid()) {
                        form.submit({
                            success: function(form, action) {
                                me.config.ref.down('grid').getStore().reload();
                                me.up('window').close();
                            },
                            failure: function(form, action) {
                                me.config.ref.down('grid').getStore().reload();
                                me.up('window').close();
                            }
                        });
                    }
                }
            }],
        });
        this.callParent(arguments);
    }
});

