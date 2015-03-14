package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 完型天空选择题
 * @author wangyang
 * 2015-02-01
 */
@Entity
public class ClozeQuestion {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 题号
     */
    private int questionIndex;

    /**
     * 分析
     */
    private String analysis;

    /**
     * 知识点
     */
    private String knowledgePoint;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 误导答案
     */
    private String confuseAnswer;

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

	public int getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getKnowledgePoint() {
		return knowledgePoint;
	}

	public void setKnowledgePoint(String knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getConfuseAnswer() {
		return confuseAnswer;
	}

	public void setConfuseAnswer(String confuseAnswer) {
		this.confuseAnswer = confuseAnswer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClozeQuestions [id=");
		builder.append(id);
		builder.append(", questionIndex=");
		builder.append(questionIndex);
		builder.append(", analysis=");
		builder.append(analysis);
		builder.append(", knowledgePoint=");
		builder.append(knowledgePoint);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", confuseAnswer=");
		builder.append(confuseAnswer);
		builder.append("]");
		return builder.toString();
	}

}