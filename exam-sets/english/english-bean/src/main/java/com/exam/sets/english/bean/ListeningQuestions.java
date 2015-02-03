package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 听力选择题
 * @author wangyang
 * 2015-02-01
 */
@Entity
public class ListeningQuestions {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 容易混淆的答案
     */
    private String confuseAnswer;

    /**
     * 分析
     */
    private String analysis;

    /**
     * 知识点
     */
    private String knowlegePoint;

    /**
     * 题号
     */
    private int questionIndex;

    /**
     * 选项
     */
    private String chooseItems;

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

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getKnowlegePoint() {
		return knowlegePoint;
	}

	public void setKnowlegePoint(String knowlegePoint) {
		this.knowlegePoint = knowlegePoint;
	}

	public int getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}

	public String getChooseItems() {
		return chooseItems;
	}

	public void setChooseItems(String chooseItems) {
		this.chooseItems = chooseItems;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListeningQuestions [id=");
		builder.append(id);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", confuseAnswer=");
		builder.append(confuseAnswer);
		builder.append(", analysis=");
		builder.append(analysis);
		builder.append(", knowlegePoint=");
		builder.append(knowlegePoint);
		builder.append(", questionIndex=");
		builder.append(questionIndex);
		builder.append(", chooseItems=");
		builder.append(chooseItems);
		builder.append("]");
		return builder.toString();
	}

}