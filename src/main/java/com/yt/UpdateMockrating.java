package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateMockrating {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		syntax :- select s from class_name s where s.Sname = ?1
		
//		Query query = entityManager.createQuery("select s from Student s where s.Sname = ?1");
//		query.setParameter(1, "Maruti");
//		List<Student> details = query.getResultList();
//
//		for (Student ele : details) {
//			ele.setSmockratings("3*");
//			entityTransaction.begin();
//			entityManager.merge(ele);
//			entityTransaction.commit();
//		}
		
		Query query = entityManager.createQuery("select c from Courses c where c.Cname = ?1");
		query.setParameter(1, "Java");
		List<Courses> details = query.getResultList();
		
		for (Courses ele : details) {
			ele.setCfees(3500);
			entityTransaction.begin();
			entityManager.merge(ele);
			entityTransaction.commit();
		}
	}

}
