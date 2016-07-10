package com.zetapase.ap;

public class Male extends Person{
	
	public Male(String name, int age, String school) {
		super(name, age, school);
		// TODO Auto-generated constructor stub
	}

	public String getName(){
		return "I'm a male. My name is " + this.name;
	}
	
	public static void main(String[] args) {
		Male dave = new Male("Dave", 15, "Valley Christian");
		System.out.println(dave.greeting());

	}

}
