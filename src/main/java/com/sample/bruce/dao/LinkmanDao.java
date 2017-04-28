package com.sample.bruce.dao;

import com.sample.bruce.po.LinkmanPo;

import java.util.List;

/**
 * @Author: liqi@youbangsoft.com
 * @Date: 2017/4/28
 * @Description: [ xxxx ]
 * @Version: 1.0
 */
public interface LinkmanDao {

    boolean addLinkman(LinkmanPo linkmanPo);

    List<LinkmanPo> findLinkmanByName(String name);

    LinkmanPo findLinkmanById(Integer id);

    List<LinkmanPo> listLinkman();

    boolean removeLinkmanById(Integer id);

    LinkmanPo updateLinkman(LinkmanPo linkmanPo);
}
