package com.exam.sets.english.bean;

/**
 * 翻译解析
 * @author wangyang
 * 2015-02-01
 */
public class TranslateAnalysis {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 分析
     */
    private String analysis;

    /**
     * 参考答案
     */
    private String referenceAnswer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getReferenceAnswer() {
		return referenceAnswer;
	}

	public void setReferenceAnswer(String referenceAnswer) {
		this.referenceAnswer = referenceAnswer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TranslateAnalysis [id=");
		builder.append(id);
		builder.append(", analysis=");
		builder.append(analysis);
		builder.append(", referenceAnswer=");
		builder.append(referenceAnswer);
		builder.append("]");
		return builder.toString();
	}

}