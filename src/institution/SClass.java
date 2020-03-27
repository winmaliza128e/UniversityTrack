package institution;

import java.util.ArrayList;
import java.util.List;

import people.*;

//SClass defines a specific class to be held for a term
//in a classroom, given by a teacher and attended by many students 
//For instance Soil Mechanics is a class scheduled for 2020-I, held in Classromm B5, 
//given by professor Thompson and attended by specific students of Civil Engineering degree

public class SClass extends UClass{
	String classroom;
	String term;
	//Teacher assigned to give the class
	Teacher teacherInCharge;
	List<Student> attendants;

	public SClass(String name, String degreeProgram, int hourLoad, int semester) {
		super(name, degreeProgram, hourLoad, semester);
		this.attendants = new ArrayList<Student>();
	}


	//Setters and Getters
	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Teacher getTeacherInCharge() {
		return teacherInCharge;
	}

	public void setTeacherInCharge(Teacher teacherInCharge) {
		this.teacherInCharge = teacherInCharge;
	}

	//Return the students attending the class
	public List<Student> getAttendants() {
		return attendants;
	}

	// Methods
	//Return the basic information of students attending classes 
	public List<String> getAttendantsList(){
		List<String> list = new ArrayList<String>();
		
		if(attendants.size() == 0) {
			list.add("No students attending the class");
		}
		else {
			for(int i=0; i < attendants.size(); i++) {
				list.add(attendants.get(i).getName() + "  UnivID:"+attendants.get(i).getDegreeProgram());
			}			
		}	
		return list;
	}

	//Schedule a class means assigning a specific classroom, term and teacher in charge
	public void scheduleClass(String classroom, String term, Teacher teacher) {
		this.classroom = classroom;
		this.term = term;
		this.teacherInCharge = teacher;
	}
	
	//Add a new student to attend the class
	public void addAttendant(Student student) {
		this.attendants.add(student);
	}
    
	
	//Overriding method toString to print information of the class
	public String toString() {
		return("-------------------------------------------------------------\n"+
			   super.toString() + "\n" +
			   "Classroom          :"+classroom +"\n"+
	           "Term               :"+term+"\n"+
	           "Assigned Teacher   :"+teacherInCharge.getName());
	}	
	
	


}
