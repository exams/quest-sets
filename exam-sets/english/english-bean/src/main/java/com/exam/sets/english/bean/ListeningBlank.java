package com.exam.sets.english.bean;

/**
 * 听力填空题
 * @author wangyang
 * 2015-02-01
 */
public class ListeningBlank {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 题号
     */
    private int questionIndex;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 分析
     */
    private String analysis;

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

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListeningBlank [id=");
		builder.append(id);
		builder.append(", questionIndex=");
		builder.append(questionIndex);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", analysis=");
		builder.append(analysis);
		builder.append("]");
		return builder.toString();
	}

}