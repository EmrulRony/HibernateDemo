package com.solutionia.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonMain {
	static Person person = new Person();
	static Student student = new Student();
	static Laptop laptop = new Laptop();

	public static Session getSession() {
		// Configuring Hibernate
		Configuration conf = new Configuration().configure();
				conf.addAnnotatedClass(Person.class);
				conf.addAnnotatedClass(Student.class);
				conf.addAnnotatedClass(Laptop.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

	public static void main(String[] args) {
		setStudent();
		setLaptop();
	}

	// Fetching data into database
	public static void savePerson() {

		person.setUserName("hasan");
		person.setPassword(5627);

		Session session = getSession();
		Transaction tx = session.getTransaction();

		tx.begin();
		session.save(person);
		tx.commit();
		session.close();
	}

	// Fetching data from database based on primary key
	public static void showPerson() {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Person person = session.get(Person.class, 1);
		tx.commit();
		session.close();
		System.out.println(person);

	}
	
	public static void setStudent() {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		student.setStudentId(101);
		student.setStudentName("Emrul");
		student.setMarks(90);
		tx.begin();
		session.save(student);
		tx.commit();
	}
	
	public static void setLaptop() {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		laptop.setLaptopId(1);
		laptop.setLaptopName("Asus");
		tx.begin();
		session.save(laptop);
		tx.commit();
	}
	
}
