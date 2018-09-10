package com.pinyougou.solr.controller;

import com.pinyougou.solr.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestSolrTemplateController {


    //此示例采用JPA写法
    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private Item item;

    @RequestMapping("/add")
    public void testAdd() {
        item.setId("1");
        item.setBrand("华为");
        item.setCategory("手机");
        item.setGoodsId(1L);
        item.setSeller("华为2号专卖店");
        item.setTitle("华为Mate9");
        item.setPrice(2000D);

        musicRepository.save(item);

    }

    @RequestMapping("/update")
    public void testUpdate() {

        item.setId("1");
        item.setBrand("华为");
        item.setCategory("手机");
        item.setGoodsId(10L);
        item.setSeller("华为2号专卖店");
        item.setTitle("华为Mate9");
        item.setPrice(2000D);

        musicRepository.save(item);

    }

    @RequestMapping("/findOne")
    public void testFindOne(){

        Optional<Item> itemL =musicRepository.findById("1");
        if(itemL != null && itemL.isPresent()){
            Item companyComSizeBean = itemL.get();
            System.out.println(itemL.get().getTitle());
            System.out.println(itemL.get().getPrice());
        }

    }

    @RequestMapping("/delete")
    public void testDelete(){
        musicRepository.deleteById("1");
    }



}
