package com.sample.bruce.dao;

import com.sample.bruce.po.LinkmanPo;

import java.util.List;

/**
 * @Author: liqi@youbangsoft.com
 * @Date: 2017/4/28
 * @Description: [ xxxx ]
 * @Version: 1.0
 */
public class JsonDatasourceLinkmanDaoImpl implements LinkmanDao {
    @Override
    public boolean addLinkman(LinkmanPo linkmanPo) {
        return false;
    }

    @Override
    public List<LinkmanPo> findLinkmanByName(String name) {
        return null;
    }

    @Override
    public LinkmanPo findLinkmanById(Integer id) {
        return null;
    }

    @Override
    public List<LinkmanPo> listLinkman() {
        return null;
    }

    @Override
    public boolean removeLinkmanById(Integer id) {
        return false;
    }

    @Override
    public LinkmanPo updateLinkman(LinkmanPo linkmanPo) {
        return null;
    }
}
