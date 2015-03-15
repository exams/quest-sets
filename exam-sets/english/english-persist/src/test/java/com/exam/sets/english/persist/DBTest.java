package com.exam.sets.english.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.exam.sets.english.bean.Option;
import com.exam.sets.english.bean.enums.QuestionType;
import com.exam.sets.english.persist.dao.IBaseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
@Transactional("txManager")
public class DBTest
{
	@Autowired
	private IBaseDao<Option> transDao;
   
	@Test
	public void testDao(){
		Option options = new Option();
		options.setLabel("A");
		options.setContent("hello, this is test");
		options.setQuestionType(QuestionType.READING);
		
		transDao.save(options);
	}
}
