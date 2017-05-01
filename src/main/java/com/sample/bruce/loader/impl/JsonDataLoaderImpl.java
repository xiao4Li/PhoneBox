package com.sample.bruce.loader.impl;

import com.alibaba.fastjson.JSON;
import com.sample.bruce.loader.DataLoader;
import com.sample.bruce.po.LinkmanPo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

/**
 * @Description: [XXX XXX]
 * @Author: [qi.li@funi365.com]
 * @CreateDate: 2017-05-01 18:00
 * @UpdateUser: [] 
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version:    [v1.0] 
 **/
@Controller("jsonDataLoaderImpl")
public class JsonDataLoaderImpl implements DataLoader<LinkmanPo> {
    public static final String FILE_NAME = "linkman.json";
    private List<LinkmanPo> cache;
    private List<LinkmanPo>   load(boolean refresh)   {
        List<LinkmanPo> data = null;
        synchronized(this){
            if(cache == null || refresh){
                File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
                StringBuffer sb = new StringBuffer();
                try(InputStream is = new FileInputStream(file)) {
                    byte[] buffer =  new byte[4096];
                    int offset = 0;
                    while ( (offset = is.read(buffer)) > 0){
                        sb.append(new String(buffer,0,offset));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(StringUtils.hasText(sb.toString())){
                    data = JSON.parseArray(sb.toString(),LinkmanPo.class);
                    cache = data;
                }
            }
        }
        return data;
    }

    private List<LinkmanPo>   load()   {
       return load(false);
    }

    private void writeDataToDisc(String data){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        try(OutputStream os = new FileOutputStream(file)){
            os.write(data.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<LinkmanPo> listData() {
        if(cache == null){
            return load();
        }
        return cache;
    }

    @Override
    public int addData(LinkmanPo item) {
        synchronized (this){
            this.cache.add(item);
        }
        String jsonString = JSON.toJSONString(this.cache);
        writeDataToDisc(jsonString);
        return 1;
    }

    @Override
    public LinkmanPo getDataById(Integer id) {
        LinkmanPo linkmanPo = null;
        for (LinkmanPo item : this.cache){
            if(id.equals(item.getId())){
                linkmanPo = item;
                break;
            }
        }
        return linkmanPo;
    }
}
