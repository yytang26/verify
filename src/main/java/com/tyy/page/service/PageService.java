package com.tyy.page.service;

import com.github.pagehelper.PageInfo;
import com.tyy.page.pojo.EduChapter;

/**
 * @author:tyy
 * @date:2021/5/30
 */
public interface PageService {

    PageInfo<EduChapter> queryEduChapter();
}
