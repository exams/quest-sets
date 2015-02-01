package com.exam.sets.english.bean;

/**
 * 写作
 * @author wangyang
 * 2015-02-01
 */
public class Writing {

    /**
     * 
     */
    private String id;

    /**
     * 题干
     */
    private String article;

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
     * 难度系数，取值1到10
     */
    private int difficultyDegree;

}