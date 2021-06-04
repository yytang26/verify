package com.tyy.page.controller;

import com.github.pagehelper.PageInfo;
import com.tyy.page.pojo.EduChapter;
import com.tyy.page.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:tyy
 * @date:2021/5/30
 */

@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/page")
    public PageInfo<EduChapter> page(){
        return pageService.queryEduChapter();
    }
}
