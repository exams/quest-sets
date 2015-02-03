package com.exam.sets.english.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 翻译参考答案
 * @author wangyang
 * 2015-02-01
 */
@Entity
public class TranslateReferAnswer {

    /**
     * 翻译参考答案
     */
    public TranslateReferAnswer() {
    }

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 参考答案内容
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

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TranslateReferAnswer [id=");
		builder.append(id);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}

}