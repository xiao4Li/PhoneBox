package com.sample.bruce.loader;

import java.util.List;

/**
 * @Description: [XXX XXX]
 * @Author: [qi.li@funi365.com]
 * @CreateDate: 2017-05-01 17:44
 * @UpdateUser: [] 
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version:    [v1.0] 
 **/
public interface DataLoader<T> {
    List<T> listData();

    int addData(T item);

    T getDataById(Integer id);
}
