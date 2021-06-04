package com.tyy.page.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyy.page.mapper.EduChapterMapper;
import com.tyy.page.pojo.EduChapter;
import com.tyy.page.pojo.EduChapterExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:tyy
 * @date:2021/5/30
 */
@Service
public class PageServiceImpl implements PageService {

    @Resource
    private EduChapterMapper eduChapterMapper;

    @Override
    public PageInfo<EduChapter> queryEduChapter() {
        EduChapterExample eduChapterExample = new EduChapterExample();
        EduChapterExample.Criteria criteria = eduChapterExample.createCriteria();

        PageHelper.startPage(1,10);
        List<EduChapter> eduChapterList = eduChapterMapper.selectByExample(eduChapterExample);

        return new PageInfo<>(eduChapterList);
    }
}
