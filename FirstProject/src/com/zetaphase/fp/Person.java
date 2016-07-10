package com.zetaphase.fp;

import java.util.HashMap;

public class Person {
	
	private String name;
	private int age;
	private String gender;
	private String ssn;
	
	private static HashMap<String, Person> allPersons = 
			new HashMap<String, Person>();
	
	public Person(String name, int age, String gender, String ssn) throws Exception {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.ssn = ssn;
		if (allPersons.containsKey(ssn)) {
			throw new Exception("SSN already taken.");
		} else {
			allPersons.put(ssn, this);
		};
	}

	public static Person getBySSN(String ssn) {
		return allPersons.get(ssn);
	};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	public static void main(String[] args) throws Exception {
		Person dave = new Person("Dave", 15, "M", "12345");
		Person ricky = new Person("Ricky", 50, "M", "12345");
		Person christie = new Person("Christie", 20, "F", "45678");
		System.out.println(dave);
		System.out.println(ricky);
		System.out.println(christie);
		System.out.println(Person.getBySSN("45678"));
	}
	
}
