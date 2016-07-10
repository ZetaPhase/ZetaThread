package com.zetaphase.inteface;

public class Cat implements Talkable, Walkable {

	@Override
	public void talkQuiet() {
		System.out.println("meow");

	}

	@Override
	public void talkLoud() {
		System.out.println("MEOWWWWW");

	}

	@Override
	public void walk() {
		System.out.println("tap tap");
		
	}
	
	

}
