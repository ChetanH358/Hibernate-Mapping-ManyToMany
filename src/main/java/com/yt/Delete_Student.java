package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete_Student {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		In ManyToMany mapping we can delete student easily by writing Hibernate query and 
// 		along with it corresponding primary key table Student_Sid & Course_Cid of respective will also get deleted

//		Query query = entityManager.createQuery("select s from Student s where s.Sname = ?1");
//		query.setParameter(1, "Maruti");
//		List<Student> details = query.getResultList();

//		|1|19|male|1*|Prabhu| <-- got deleted 
//		|2|18|male|3*|Maruti| <-- got deleted

//		for (Student ele : details) {
//			entityTransaction.begin();
//			entityManager.remove(ele);
//			entityTransaction.commit();
//		}
		
//		parent table -> student
//		child table -> courses
		
//		***********************************************************************************************************************************

//		In ManyToMany Mapping we can't able to delete courses (it will give exception foregin key :parent row)
		
//		Query query = entityManager.createQuery("select c from Courses c where c.Cname = ?1");
//		query.setParameter(1, "Aptitude");
//		List<Courses> details = query.getResultList();
		
//		for (Courses ele : details) {
//			entityTransaction.begin();
//			entityManager.remove(ele);
//			entityTransaction.commit();
//		}

	
//		***********************************************************************************************************************************
	
//		deleting the student details along with course details.first need to find them and if they 
//		are not null then deleting them. this approach didn't worked out .......getting
//		excepetion (cannot update or delete parent table ).....
		
//		parent table -> course_details
//		child table -> student_details
		
//		Courses course_detail_1 = entityManager.find(Courses.class, 1);
//		Courses course_detail_2 = entityManager.find(Courses.class, 2);
//		Courses course_detail_3 = entityManager.find(Courses.class, 3);
//		Student student_details = entityManager.find(Student.class, 3);	
		
//		if(student_details != null) {
//			entityTransaction.begin();
//			entityManager.remove(course_detail_1);
//			entityManager.remove(course_detail_2);
//			entityManager.remove(course_detail_3);
//			entityManager.remove(student_details);
//			entityTransaction.commit();
//			}
		

//		***********************************************************************************************************************************

		
//		writing query inside another query for deleting course as-well-as student
//		The below logic is working correct 
		
//		writing query for the course to be deleted
		Query query = entityManager.createQuery("select c from Courses c where c.Cname=?1");
		query.setParameter(1, "java");
		List<Courses> course_details = query.getResultList();

//		traverse the list i.e course_details 
		for (Courses ele : course_details) { // ele = java course details get stored

//			get details of all the students and store it in list
			Query student_details = entityManager.createQuery("select s from Student s");
			List<Student> student_list = student_details.getResultList();
			
//			traverse the list and get all course details for each student
			for (Student student_ele : student_list) { // student list array
				
//				storing each student's_course_details in the list
				List<Courses> course_det = student_ele.getCourses();
				
//				traversing the courses to write logic
				for (Courses course_ele : course_det) {
					
/*					if course_id matches with the course_id (that we are trying to delete)
 * 					then delete the student
 */
					if (course_ele.getCid() == ele.getCid()) {
						entityTransaction.begin();
						entityManager.remove(student_ele);
						entityTransaction.commit();
					}
				}
			}
			entityTransaction.begin();
			entityManager.remove(ele);
			entityTransaction.commit();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
