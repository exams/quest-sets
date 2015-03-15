package com.exam.sets.english.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 组卷模板
 * @author wangyang
 * 2015-03-15
 */
@Entity
public class ExamPaperTemplate {

    /**
     * 唯一主键
     */
    private String id;
    
    /**
     * 学校
     */
    private String school;
    
    /**
     * 科目
     */
    private String subject;
    
    /**
     * 类型，CET-4,CET-6
     */
    private String type;
    
    /**
     * 是否真题
     */
    private boolean isReal;
    
    /**
     * 
     */
    private String year;
    
    /**
     * 年级
     */
    private String grade;
    
    /**
     * 选择题数量
     */
    private int choiceNum;
    
    /**
     * 选择题分值
     */
    private int perChoiceScore;
    
    /**
     * 填空题
     */
    private int blankNum;
    
    /**
     * 填空题分值
     */
    private int perBlankScore;
    
    /**
     * 判断题
     */
    private int checkingNum;
    
    /**
     * 判断题分值
     */
    private int perCheckingScore;
    
    /**
     * 简答题
     */
    private int answerNum;
    
    /**
     * 简答题分值
     */
    private int perAnswerScore;
    
    /**
     * 选做题
     */
    private int noEssential;
    
    /**
     * 选做题分值
     */
    private int perNoEssentialScore;
    
    /**
     * 难度系数
     */
    private int difficultyDegree;

    /**
     * 知识点
     */
    private Set<KnowlegePoint> knowlegePoints;

	@Id
	@GenericGenerator(name="hibernateUuid", strategy="uuid")
	@GeneratedValue(generator="hibernateUuid")
	@Column(nullable=false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}