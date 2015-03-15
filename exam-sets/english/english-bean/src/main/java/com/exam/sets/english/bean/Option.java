package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.exam.sets.english.bean.enums.QuestionType;

/**
 * 选择题的选项
 * @author wangyang
 * 2015-02-01
 */
@Entity
public class Option {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 选项
     */
    private String label;

    /**
     * 选项对应的内容更
     */
    private String content;

    /**
     * 题型类型
     */
    private QuestionType questionType;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Options [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", content=");
		builder.append(content);
		builder.append(", questionType=");
		builder.append(questionType);
		builder.append("]");
		return builder.toString();
	}

}