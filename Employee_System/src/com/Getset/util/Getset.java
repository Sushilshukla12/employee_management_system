package com.Getset.util;

public class Getset {
	private int id;
	private String First_name;
	private String Last_name;
	private int Age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String toString() {
		String ret="\n Id = "+this.getId()
		+"\n = First_name"+this.getFirst_name()
		+"\n Last_name = "+this.getLast_name()
		+"\n Age = "+this.getAge();
		return ret;
		
	}
}
