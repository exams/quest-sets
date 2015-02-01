package com.exam.sets.english.bean;

/**
 * 完型填空
 * @author wangyang
 * 2015-02-01
 */
public class Cloze {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 是否真题
     */
    private boolean isReal;

    /**
     * 年份， 当isReal为true时必选
     */
    private int year;

    /**
     * 总分值
     */
    private int scoreValue;

    /**
     * 
     */
    private String part;

    /**
     * 
     */
    private String section;

    /**
     * 填空题数量
     */
    private int blankNumber;

    /**
     * 难度系数，取值1到10
     */
    private int difficultyDegree;

    /**
     * 完型填空题干
     */
    private String article;

}