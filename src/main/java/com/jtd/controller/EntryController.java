package com.jtd.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.entity.Entry;
import com.jtd.service.IEntryService;

@RequestMapping("/entry")
@Controller
public class EntryController {

    @Autowired
    private IEntryService entryService;
    @RequestMapping(value = "/getEntry", method = RequestMethod.POST)
    @ResponseBody
    public List<Entry> getEntry(@RequestParam String dictTypeId) {
        List<Entry> e = entryService.getEntry(dictTypeId);
        return e;
    }

    @RequestMapping(value = "/getEntryByDictId", method = RequestMethod.POST)
    @ResponseBody
    public Entry getEntryByDictId(@RequestParam String dictTypeId,
                                  @RequestParam String dictId) {
        Entry e = entryService.getEntryByDictId(dictTypeId, dictId);
        return e;
    }
}
