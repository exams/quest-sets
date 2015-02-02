package com.exam.sets.english.bean;

import com.exam.sets.english.bean.enums.ExamType;

/**
 * 听力题
 * @author wangyang
 * 2015-02-01
 */
public class Listening {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 是否真题
     */
    private boolean isReal;

    /**
     * 题库类型
     */
    private ExamType type;

    /**
     * 年份，当isReal为true时必选
     */
    private int year;

    /**
     * 
     */
    private String part;

    /**
     * 
     */
    private String section;

    /**
     * 听力文件路径
     */
    private String radioPath;

    /**
     * part I section C 听力题干
     */
    private String content;

    /**
     * 难度系数，取值1到10
     */
    public int difficultyDegree;

}
