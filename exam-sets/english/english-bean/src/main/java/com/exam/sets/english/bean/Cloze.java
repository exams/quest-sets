package com.exam.sets.english.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * 完型填空
 * @author wangyang
 * 2015-02-01
 */
@Entity
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
    
    private Set<ClozeQuestion> clozeQuestion;

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

	public int getBlankNumber() {
		return blankNumber;
	}

	public void setBlankNumber(int blankNumber) {
		this.blankNumber = blankNumber;
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
	
	@OneToMany
	public Set<ClozeQuestion> getClozeQuestion() {
		return clozeQuestion;
	}

	public void setClozeQuestion(Set<ClozeQuestion> clozeQuestion) {
		this.clozeQuestion = clozeQuestion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cloze [id=");
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
		builder.append(", blankNumber=");
		builder.append(blankNumber);
		builder.append(", difficultyDegree=");
		builder.append(difficultyDegree);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}

}