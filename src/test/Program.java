package test;

import java.util.ArrayList;
import java.util.List;

import people.*;
import institution.*;

public class Program {

	
	
	public static void main(String[] args) {
		
		createTeachers();
		createStudents();
		scheduleClasses();	
		University.calculateActiveHours();
		
		//System.out.println(University.teachers.get(1).toString());
		getClassesAttendedByStudent("USQ235442");
	}
	
	private static void createTeachers() {
		University.teachers = new ArrayList<Teacher>();
		
		University.teachers.add(new Teacher("Sheldon Cooper", 35, "CC343432344",
			                    "UTF4501", 10, 4500, VinculationType.FULLTIME));
		University.teachers.add(new Teacher("James Blake",   41, "YT9029113",
				                "UTG1231", 15, 700, VinculationType.PARTTIME));
		University.teachers.add(new Teacher("Leonard Hofstadter",   36, "NT56875",
			                    "UT5628", 5, 3500, VinculationType.FULLTIME));
	}
	
	private static void createStudents() {
		University.students = new ArrayList<Student>();
		
		University.students.add(new Student("Valentino Rossi", 40, "S342232", 
			       "USP135455", "Medicine"));
		University.students.add(new Student("Jordan Thompson", 28, "R76557", 
			       "USQ235442", "Physics"));
		University.students.add(new Student("Alex Espalgaro", 24, "TW323422", 
			       "USQ2232", "Physics"));
		University.students.add(new Student("Jorge Lorenzo", 31, "ASW288901", 
			       "USI6577", "Mechanics Engineering"));
		University.students.add(new Student("Casey Stoner", 24, "HJD243578", 
			       "USI7654", "Mechanics Engineering"));
		University.students.add(new Student("Maverick Viñales", 28, "IU98776001", 
			       "USI0987", "Mechanics Engineering"));
	}
	
	private static void scheduleClasses() {
		University.specificClasses = new ArrayList<SClass>();
		
		University.specificClasses.add(new SClass("Quantum Mechanics", "Physics", 8, 3));
		University.specificClasses.get(0).scheduleClass("B501", "2020-I", University.getTeacher("Sheldon Cooper"));
		University.specificClasses.get(0).addAttendant(University.students.get(1));
		University.specificClasses.get(0).addAttendant(University.students.get(2));
		
		University.specificClasses.add(new SClass("Fluids", "Physics", 6, 2));
		University.specificClasses.get(1).scheduleClass("A312", "2020-I", University.getTeacher("Leonard Hofstadter"));
		
		University.specificClasses.add(new SClass("Medical Ethics", "Medicine", 4, 1));
		University.specificClasses.get(2).scheduleClass("A312", "2020-I", University.getTeacher("James Blake"));
		
		University.specificClasses.add(new SClass("General Anatomy", "Medicine", 10, 1));
		University.specificClasses.get(3).scheduleClass("C705", "2020-I", University.getTeacher("James Blake"));
		
	}
	

	//Look for the classes attended by a student, given its universityID
	private static void getClassesAttendedByStudent(String studentID){
		List<String> classes = new ArrayList<String>(); 
		classes = University.students.get(0).getAttendedClasses(University.specificClasses,studentID);
		
		for(int i=0; i < classes.size(); i++) {
			System.out.println(classes.get(i));
		}
		
	}


	
}
