package people;

public abstract class Person {
	
	//Attributes
	private String name;
	private int age;
	private String dni; //national id
	
	
	//Constructors
	public Person(String name, int age, String dni) {
		super();
		this.name = name;
		this.age = age;
		this.dni = dni;
	}
	
	//Setters and Getters
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
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	//Methods
	public String toString() {
		return("-------------------------------------------------------------\n"+
		           "Name               :"+name+"\n" +
				   "Age                :"+age+"\n"+
		           "DNI                :"+dni+"\n");
	}

}
