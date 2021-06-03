package com.keith.stream;

public class Emp {
	public  int id;
	public String name;
	public double sal;
	
	public Emp(int id, String name, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	
	public Emp() {
	}
		
	public static void printEmp(Emp emp) {
		System.out.println(
				"Id="+emp.id+" Name="+emp.name+" Sal="+emp.sal);
	}

	public String toString() {
		return "Id= "+this.id + ", Name="+ this.name+ ", Sal="+this.sal;
	}
}
