package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllStudentDATA {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select s from Student s");
		List<Student> details = query.getResultList();
	
		for(Student ele : details) {
			System.out.println("*******************************");		
			System.out.println("Student id "+ele.getSid());
			System.out.println("Student name "+ele.getSname());
			System.out.println("Student age "+ele.getSage());
			System.out.println("Student gender "+ele.getSgender());
			System.out.println("Student mockrating "+ele.getSmockratings());
			System.out.println("*******************************");
		}

	}

}
