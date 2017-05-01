package com.sample.bruce;

import com.sample.bruce.po.LinkmanPo;

import java.util.List;

/**
 * @Description: [XXX XXX]
 * @Author: [qi.li@funi365.com]
 * @CreateDate: 2017-05-01 20:43
 * @UpdateUser: [] 
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version:    [v1.0] 
 **/
public class Utils {
    private static Integer linkmanId = 0;

    public static Integer  getMaxId(List<LinkmanPo> list){
        Integer idHolder = 0;
        for(LinkmanPo item : list){
            idHolder =  item.getLinkmanId() > idHolder ? item.getLinkmanId() : idHolder ;
        }

        return  idHolder;
    }

}
