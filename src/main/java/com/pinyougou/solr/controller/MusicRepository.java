package com.pinyougou.solr.controller;

import com.pinyougou.solr.pojo.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface MusicRepository extends SolrCrudRepository<Item, String> {

    /**
     * 分页模糊查询
     * @param title
     * @param pageable
     * @return
     */
    Page<Item> findByTitleContaining(String title, Pageable pageable);

}