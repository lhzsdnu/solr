package com.pinyougou.solr.controller;

import com.pinyougou.solr.pojo.Item;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface MusicRepository extends SolrCrudRepository<Item, String> {



}