package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 阅读理解题
 * @author wangyang
 * 2015-02-01
 */
@Entity
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

	public int getChooseNumber() {
		return chooseNumber;
	}

	public void setChooseNumber(int chooseNumber) {
		this.chooseNumber = chooseNumber;
	}

	public int getDifficultyDegree() {
		return difficultyDegree;
	}

	public void setDifficultyDegree(int difficultyDegree) {
		this.difficultyDegree = difficultyDegree;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReadComprehension [id=");
		builder.append(id);
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
		builder.append(", chooseNumber=");
		builder.append(chooseNumber);
		builder.append(", difficultyDegree=");
		builder.append(difficultyDegree);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}

}