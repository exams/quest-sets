package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 阅读选择题
 * @author wangyang
 * 2015-02-01
 */
@Entity
public class ReadingQuestions {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 题号
     */
    private int questionIndex;

    /**
     * 题干
     */
    private String questionStem;

    /**
     * 选项
     */
    private String chooseItems;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 误导答案
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

	public String getQuestionStem() {
		return questionStem;
	}

	public void setQuestionStem(String questionStem) {
		this.questionStem = questionStem;
	}

	public String getChooseItems() {
		return chooseItems;
	}

	public void setChooseItems(String chooseItems) {
		this.chooseItems = chooseItems;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReadingQuestions [id=");
		builder.append(id);
		builder.append(", questionIndex=");
		builder.append(questionIndex);
		builder.append(", questionStem=");
		builder.append(questionStem);
		builder.append(", chooseItems=");
		builder.append(chooseItems);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", confuseAnswer=");
		builder.append(confuseAnswer);
		builder.append(", analysis=");
		builder.append(analysis);
		builder.append(", knowlegePoint=");
		builder.append(knowlegePoint);
		builder.append("]");
		return builder.toString();
	}

}