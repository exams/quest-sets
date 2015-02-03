package com.exam.sets.english.bean;

import com.exam.sets.english.bean.enums.ExamType;

/**
 * 听力题
 * @author wangyang
 * 2015-02-01
 */
public class Listening {

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 是否真题
     */
    private boolean isReal;

    /**
     * 题库类型
     */
    private ExamType type;

    /**
     * 年份，当isReal为true时必选
     */
    private int year;

    /**
     * 
     */
    private String part;

    /**
     * 
     */
    private String section;

    /**
     * 听力文件路径
     */
    private String radioPath;

    /**
     * part I section C 听力题干
     */
    private String content;

    /**
     * 难度系数，取值1到10
     */
    public int difficultyDegree;

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

	public ExamType getType() {
		return type;
	}

	public void setType(ExamType type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public String getRadioPath() {
		return radioPath;
	}

	public void setRadioPath(String radioPath) {
		this.radioPath = radioPath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		builder.append("Listening [id=");
		builder.append(id);
		builder.append(", isReal=");
		builder.append(isReal);
		builder.append(", type=");
		builder.append(type);
		builder.append(", year=");
		builder.append(year);
		builder.append(", part=");
		builder.append(part);
		builder.append(", section=");
		builder.append(section);
		builder.append(", radioPath=");
		builder.append(radioPath);
		builder.append(", content=");
		builder.append(content);
		builder.append(", difficultyDegree=");
		builder.append(difficultyDegree);
		builder.append("]");
		return builder.toString();
	}

}
