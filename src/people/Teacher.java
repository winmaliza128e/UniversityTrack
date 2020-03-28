package people;

import java.util.List;

import institution.SClass;
import institution.Salary;
import institution.VinculationType;

public class Teacher extends Person implements Salary {

	//Attributes
	private String universityID;
	private int experienceYears;
	private double baseSalary; //base salary per month
	private int activeHours;
	
	//salary factor helps to determine the salary to be paid to full time teachers,
	//in this case 110%
	private static double salaryFactor = 1.10;
	
	private VinculationType vinculationType;

	//Constructor
	public Teacher(String name, int age, String dni,
			       String universityID, int experienceYears, double baseSalary, VinculationType vinculationType ) {
		super(name, age, dni);
		this.universityID = universityID;
		this.experienceYears = experienceYears;
		this.baseSalary = baseSalary;
		this.vinculationType = vinculationType;
		this.activeHours = 0;
	}
	
	//Setters and getters

	public VinculationType getVinculationType() {
		return vinculationType;
	}

	public void setVinculationType(VinculationType vinculationType) {
		this.vinculationType = vinculationType;
	}	
	
	//Methods
	//Salary Interface Methods implementation
	public double calculateSalary() {
		double salary = 0;
		
		switch (vinculationType) {
		  case FULLTIME:
			  salary = baseSalary*(salaryFactor*experienceYears);  
			  break;
		  case PARTTIME:
			  salary = baseSalary*activeHours;
			  break;
		  default:
			  break;
		}
		return salary;
	}
	
	//Set the active hours based on the classes the teacher is in charge
	public void setActiveHours(List <SClass> classes) {
		int totalActiveHours=0;
		for(int i=0; i < classes.size(); i++) {
			
			//System.out.println("Teacher:"+classes.get(i).getTeacherInCharge().getName());
			if(classes.get(i).getTeacherInCharge().getName().equals(getName())) {
				
				totalActiveHours += classes.get(i).getHourLoad();
			}
		}
		activeHours = totalActiveHours;
		//System.out.println("Total Active Hours:"+activeHours);
	}
	
	//Overriding method toString to print information of the class
	public String toString() {
		return("-------------------------------------------------------------\n"+
	           super.toString() + "\n" +
			   "University ID      :"+universityID +"\n"+
	           "Vinculation Type   :"+getVinculationType()+"\n"+
	           "Years of experience:"+experienceYears+"\n"+
	           "Base salary        :$"+baseSalary+"\n"+
	           "Active Hours       :"+activeHours+"\n"+
	           "Total Salary       :$"+calculateSalary());
	}
	
}
