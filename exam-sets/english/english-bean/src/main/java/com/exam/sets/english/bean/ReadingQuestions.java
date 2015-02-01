package com.exam.sets.english.bean;

/**
 * 阅读选择题
 * @author wangyang
 * 2015-02-01
 */
public class ReadingQuestions {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 题号
     */
    private int questionIndex;

    /**
     * 题干
     */
    private String questionStem;

    /**
     * 选项
     */
    private String chooseItems;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 误导答案
     */
    private String confuseAnswer;

    /**
     * 分析
     */
    private String analysis;

    /**
     * 知识点
     */
    private String knowlegePoint;

}