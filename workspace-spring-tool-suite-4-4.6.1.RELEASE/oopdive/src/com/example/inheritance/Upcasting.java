package com.example.inheritance;

public class Upcasting {
	
	public static void main(String[] args) {
/*
 * 
 * implicit - compiler -upcasting -child class obj is assigned to parent
 * explicit - developers -downcasting -explicitly we have to say that the parent object needs to be converted to which child
 */
	Object o = new Child(); //reference variable not an obj, ref has limited access whereas obj has access to everything
	System.out.println(o.getClass());
	System.out.println(o.hashCode());
	
	Parent p =(Parent) o; //Downcasting, ref var still
	p.grandParentMethod();
	p.parentMethod();
	System.out.println(p.hashCode());
	
	Child c = (Child)o; //object not ref var
	System.out.println(c.hashCode());
	c.childMethod();
	c.parentMethod();
	c.grandParentMethod();
}
}