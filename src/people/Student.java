package people;

import java.util.ArrayList;
import java.util.List;

import institution.SClass;

public class Student extends Person{
	
	//Attributes
	private String universityID;
	private String degreeProgram;

	
	//Constructors
	public Student(String name, int age, String dni, 
			       String universityID, String degreeProgram) {
		super(name, age, dni);
		this.universityID = universityID;
		this.degreeProgram = degreeProgram;
	}
	
	//Getter and setters
	public String getUniversityID() {
		return universityID;
	}

	public void setUniversityID(String universityID) {
		this.universityID = universityID;
	}

	public String getDegreeProgram() {
		return degreeProgram;
	}
	

	public void setDegreeProgram(String degreeProgram) {
		this.degreeProgram = degreeProgram;
	}
	
	//Methods
	
	
	//Get the list of classes a specific student (given its studentID) is attending
	public List<String> getAttendedClasses(List<SClass> classes, String studentID){
		
		List<String> attendedClasses = new ArrayList<String>();
		
		
		
		for(int i = 0; i < classes.size(); i++) {
			
			if(classes.get(i).getAttendants().size() > 0) {
				for(int j=0; j<classes.get(i).getAttendants().size(); j++) {
					if(classes.get(i).getAttendants().get(j).universityID.equals(studentID)){
						attendedClasses.add(classes.get(i).toString());
					}
				}
				
			}
		}

		if(attendedClasses.size()==0) {
			attendedClasses.add("No classes currently attended");	
		}
		
		return attendedClasses;
	}
	
	//Overriding method toString to print information of the class
	public String toString() {
		return("------------------------------------------------------------------\n"+
	           super.toString() + "\n" +
			   "University ID      :" +universityID+"\n"+
	           "Degree Program     :"+degreeProgram);
	}

}
