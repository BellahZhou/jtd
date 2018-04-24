package com.jtd.service;

import com.jtd.entity.Entry;
import java.util.List;

public interface IEntryService {

    public List<Entry> getEntry(String dictTypeId);


    public Entry getEntryByDictId(String dictTypeId, String dictId);



}
