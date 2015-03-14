package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 翻译
 * @author wangyang
 * 2015-02-01
 */
@Entity
public class Translation {

    /**
     * 唯一主键
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
    
    /**
     * 翻译解析
     */
    @OneToOne
    private TranslateAnalysis translateAnalysis;
    
    /**
     * 翻译题参考答案
     */
    @OneToOne(fetch=FetchType.LAZY)
    private TranslateReferAnswer translateReferAnswer;

	@Id
	@GenericGenerator(name="hibernateUuid", strategy="uuid")
	@GeneratedValue(generator="hibernateUuid")
	@Column(unique = true, nullable=false)
	public String getId() {
		return id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	@Column(name="isReal")
	public boolean isReal() {
		return isReal;
	}

	public void setReal(boolean isReal) {
		this.isReal = isReal;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getDifficultyDegree() {
		return difficultyDegree;
	}

	public void setDifficultyDegree(int difficultyDegree) {
		this.difficultyDegree = difficultyDegree;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToOne
	public TranslateAnalysis getTranslateAnalysis() {
		return translateAnalysis;
	}

	public void setTranslateAnalysis(TranslateAnalysis translateAnalysis) {
		this.translateAnalysis = translateAnalysis;
	}

	@OneToOne
	public TranslateReferAnswer getTranslateReferAnswer() {
		return translateReferAnswer;
	}

	public void setTranslateReferAnswer(TranslateReferAnswer translateReferAnswer) {
		this.translateReferAnswer = translateReferAnswer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Translation [id=");
		builder.append(id);
		builder.append(", article=");
		builder.append(article);
		builder.append(", isReal=");
		builder.append(isReal);
		builder.append(", year=");
		builder.append(year);
		builder.append(", scoreValue=");
		builder.append(scoreValue);
		builder.append(", part=");
		builder.append(part);
		builder.append(", section=");
		builder.append(section);
		builder.append(", difficultyDegree=");
		builder.append(difficultyDegree);
		builder.append("]");
		return builder.toString();
	}
	
}