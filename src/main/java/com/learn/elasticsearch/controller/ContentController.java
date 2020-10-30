package com.learn.elasticsearch.controller;

import com.learn.elasticsearch.service.ContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jingjing.zhang
 */
@CrossOrigin
@RestController
public class ContentController {

    @Resource
    private ContentService contentService;
    @PostMapping("/parse/{keywords}")
    public Boolean parse(@PathVariable String keywords) throws Exception {
        return contentService.parseContent(keywords);
    }

    @GetMapping("/search/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(@PathVariable("keywords") String keywords,
                                           @PathVariable("pageNo") int pageNo,
                                           @PathVariable("pageSize") int pageSize) throws Exception {
        return contentService.searchPage(keywords,pageNo,pageSize);
    }
}
