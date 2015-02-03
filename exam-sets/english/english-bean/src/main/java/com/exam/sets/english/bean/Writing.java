package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 写作
 * @author wangyang
 * 2015-02-01
 */
@Entity
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

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
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

	public int getDifficultyDegree() {
		return difficultyDegree;
	}

	public void setDifficultyDegree(int difficultyDegree) {
		this.difficultyDegree = difficultyDegree;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Writing [id=");
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