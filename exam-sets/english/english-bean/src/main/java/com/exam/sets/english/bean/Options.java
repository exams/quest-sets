package com.exam.sets.english.bean;

import com.exam.sets.english.bean.enums.QuestionType;

/**
 * 选择题的选项
 * @author wangyang
 * 2015-02-01
 */
public class Options {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 选项
     */
    private String label;

    /**
     * 选项对应的内容更
     */
    private String content;

    /**
     * 题型类型
     */
    private QuestionType questionType;

}