package com.zetapase.ap;

public class Female extends Person{
	
	public Female(String name, int age, String school) {
		super(name, age, school);
		// TODO Auto-generated constructor stub
	}
	
	public String getName(){
		return "I'm a female. My name is " + this.name;
	}
	
	public static void main(String[] args) {
		Female christie = new Female("christie", 20, "Colombia");
		System.out.println(christie.greeting());

	}
	
}
