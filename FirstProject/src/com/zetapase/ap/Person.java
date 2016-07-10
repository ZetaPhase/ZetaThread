package com.zetapase.ap;

public abstract class Person {

	protected String name;
	protected int age;
	protected String school;
	
	public Person(String name, int age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}
	
	public abstract String getName();
	
	public String greeting(){
		return "Hi, " + this.getName();
	}

}
