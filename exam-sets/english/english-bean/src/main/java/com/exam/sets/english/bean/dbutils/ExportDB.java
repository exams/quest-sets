package com.exam.sets.english.bean.dbutils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.exam.sets.english.bean.Cloze;
import com.exam.sets.english.bean.ClozeQuestions;
import com.exam.sets.english.bean.Listening;
import com.exam.sets.english.bean.ListeningBlank;
import com.exam.sets.english.bean.ListeningQuestions;
import com.exam.sets.english.bean.Options;
import com.exam.sets.english.bean.ReadComprehension;
import com.exam.sets.english.bean.ReadingQuestions;
import com.exam.sets.english.bean.ReadingSecBOptions;
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
		cfg.addAnnotatedClass(ClozeQuestions.class);
		cfg.addAnnotatedClass(Listening.class);
		cfg.addAnnotatedClass(ListeningBlank.class);
		cfg.addAnnotatedClass(ListeningQuestions.class);
		cfg.addAnnotatedClass(Options.class);
		cfg.addAnnotatedClass(ReadComprehension.class);
		cfg.addAnnotatedClass(ReadingQuestions.class);
		cfg.addAnnotatedClass(ReadingSecBOptions.class);
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