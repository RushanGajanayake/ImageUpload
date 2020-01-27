package com.sft.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sft.Entity.Test;

@Repository
public class TestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveImg(Test test) {
		Session session = sessionFactory.getCurrentSession();
		session.save(test);
	}
	
	@Transactional
	public Test get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Test)session.get(Test.class, id);
	}
	
}
