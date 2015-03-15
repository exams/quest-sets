package com.exam.sets.english.bean.dbutils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.exam.sets.english.bean.Cloze;
import com.exam.sets.english.bean.ClozeQuestion;
import com.exam.sets.english.bean.Listening;
import com.exam.sets.english.bean.ListeningBlank;
import com.exam.sets.english.bean.ListeningQuestion;
import com.exam.sets.english.bean.Option;
import com.exam.sets.english.bean.ReadComprehension;
import com.exam.sets.english.bean.ReadingQuestion;
import com.exam.sets.english.bean.ReadingSecBOption;
import com.exam.sets.english.bean.TranslateAnalysis;
import com.exam.sets.english.bean.TranslateReferAnswer;
import com.exam.sets.english.bean.Translation;
import com.exam.sets.english.bean.Writing;
import com.exam.sets.english.bean.WritingAnalysis;
import com.exam.sets.english.bean.WritingReferAnswer;

@SuppressWarnings("deprecation")
public class ExportDB {

	public static void main(String[] args) {		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
		.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/english-sets")
		.setProperty("hibernate.connection.username", "root")
		.setProperty("hibernate.connection.password", "123456")
		.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
		.setProperty("hibernate.show_sql", "true");
		
		cfg.addAnnotatedClass(Cloze.class);
		cfg.addAnnotatedClass(ClozeQuestion.class);
		cfg.addAnnotatedClass(Listening.class);
		cfg.addAnnotatedClass(ListeningBlank.class);
		cfg.addAnnotatedClass(ListeningQuestion.class);
		cfg.addAnnotatedClass(Option.class);
		cfg.addAnnotatedClass(ReadComprehension.class);
		cfg.addAnnotatedClass(ReadingQuestion.class);
		cfg.addAnnotatedClass(ReadingSecBOption.class);
		cfg.addAnnotatedClass(TranslateAnalysis.class);
		cfg.addAnnotatedClass(TranslateReferAnswer.class);
		cfg.addAnnotatedClass(Translation.class);
		cfg.addAnnotatedClass(Writing.class);
		cfg.addAnnotatedClass(WritingAnalysis.class);
		cfg.addAnnotatedClass(WritingReferAnswer.class);
		
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}
}