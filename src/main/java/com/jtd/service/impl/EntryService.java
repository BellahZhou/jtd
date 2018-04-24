package com.jtd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.jtd.dao.EntryMapper;
import com.jtd.entity.Entry;
import com.jtd.service.IEntryService;

@CacheConfig(cacheNames = "DictEntry")
@Service
public class EntryService  implements IEntryService {
	@Autowired
	private EntryMapper mapper;
	
    @Cacheable(key = "'getEntry.' + #dictTypeId")
    public List<Entry> getEntry(String dictTypeId) {
        return this.mapper.getEntry0(dictTypeId);
    }


    @Cacheable(key = "'getEntryByDictId.' + #dictTypeId + '.' + #dictId")
    public Entry getEntryByDictId(String dictTypeId, String dictId) {
        Entry dictEntry = new Entry();
        dictEntry.setDictTypeId(dictTypeId);
        dictEntry.setDictId(dictId);
        return this.mapper.selectOne(dictEntry);
    }


}
