package com.pinyougou.solr.controller;

import com.pinyougou.solr.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
        item.setPrice("2000");

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
        item.setPrice("2000");

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

    @RequestMapping("/addList")
    public void testAddList(){
        List<Item> list=new ArrayList();
        for(int i=0;i<100;i++){
            Item item=new Item();
            item.setId(String.valueOf(i+1));
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为2号专卖店");
            item.setTitle("华为Mate"+i);
            item.setPrice("2000");
            list.add(item);
        }
        musicRepository.saveAll(list);
    }

    @RequestMapping("/pageQuery")
    public void testPageQuery(){

        Pageable pageable = PageRequest.of(1, 20);
        Page<Item> page = musicRepository.findAll(pageable);
        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("总分页数："+page.getTotalPages());

        List<Item> list = page.getContent();
        //显示记录数据
        for(Item item:list){
            System.out.println(item.getTitle() +"====="+item.getPrice());
        }

    }

    @RequestMapping("/deleteAll")
    public void testDeleteAll(){
        musicRepository.deleteAll();
    }


    @RequestMapping("/pageQueryMutil")
    public void testPageQueryMutil(){

        Pageable pageable = PageRequest.of(0, 15);
        Page<Item> page = musicRepository.findByTitle("5",pageable);
        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("总分页数："+page.getTotalPages());

        List<Item> list = page.getContent();
        //显示记录数据
        for(Item item:list){
            System.out.println(item.getTitle() +"====="+item.getPrice());
        }
    }






}
