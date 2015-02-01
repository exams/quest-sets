package com.exam.sets.english.bean;

/**
 * 阅读理解题
 * @author wangyang
 * 2015-02-01
 */
public class ReadComprehension {

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
     * 分值
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
     * 题数
     */
    private int chooseNumber;

    /**
     * 难度系数，取值1到10
     */
    private int difficultyDegree;

    /**
     * 
     */
    private String article;

}