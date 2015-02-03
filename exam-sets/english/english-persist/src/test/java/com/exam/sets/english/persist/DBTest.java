package com.exam.sets.english.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.sets.english.bean.Translation;
import com.exam.sets.english.persist.dao.IBaseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class DBTest
{
	@Autowired
	private IBaseDao<Translation> transDao;
   
	@Test
	public void testDao(){
		Translation translation = new Translation();
		translation.setArticle("123123123123dfasdfasdfasdfasdfasdfasdfasadfasdfasdfasdfasdf");
		translation.setDifficultyDegree(8);
		translation.setPart("I");
		translation.setReal(true);
		translation.setScoreValue(5);
		translation.setSection("C");
		translation.setYear(2014);
		transDao.save(translation);
	}
}
