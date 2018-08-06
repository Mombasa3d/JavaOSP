package conyersb.junit;

public class Person {
	private static final int maxAge = 978;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isEmpty())
		{
			throw new InvalidPersonNameException("Name cannot be null or empty!");
		}
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 0 || age >  maxAge)
		{
			throw new InvalidPersonAgeException("Age is out of set bounds.");
		}
		this.age = age;
	}
	
	
	
}
