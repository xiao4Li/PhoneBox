/**
 *@Author:  liqi@youbangsoft.com
 *@Date:  2017/4/28
 *@Description: [ xxxx ]
 *@Version: 1.0
 */Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
    name: 'PhoneBox',
    appFolder: 'app',

    models: [

    ],
    stores: [

    ],
    views: [
        'PhoneBoxViewPort'
    ],
    launch: function () {
        var app = new PhoneBox.view.PhoneBoxViewPort();
    }
});