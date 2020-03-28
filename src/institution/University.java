package institution;

import java.util.List;

import people.Student;
import people.Teacher;

public class University {
	public static List<Teacher> teachers;
	public static List<Student> students;
	public static List<UClass> classes;
	public static List<SClass> specificClasses;

	//Look for a teacher based on its name
	public static Teacher getTeacher(String teacherName) {
		int i = 0;
		boolean teacherFound = false;
		
		for(i=0; i < teachers.size(); i++) {
			if(teachers.get(i).getName().equals(teacherName)) {
				teacherFound = true;
				break;
			}
		}
		

		if(!teacherFound) {
			return null;
		}

		return teachers.get(i);
	}
	
	//Look for a student based on its universityID
	public static Student getStudent(String universityID) {
		int i = 0;
		boolean studentFound = false;
		
		for(i=0; i < students.size(); i++) {
			if(students.get(i).getUniversityID().equals(universityID)) {
				studentFound = true;
				break;
			}
		}
		

		if(!studentFound) {
			return null;
		}
		
		return students.get(i);
	}
	
	
	//Look for a specific class based on its name
	public static SClass getSpecificClass(String className) {
		int i = 0;
		boolean classFound = false;
		
		for(i=0; i < specificClasses.size(); i++) {
			if(specificClasses.get(i).getName().equals(className)) {
				classFound = true;
				break;
			}
		}
		

		if(!classFound) {
			return null;
		}
		
		return specificClasses.get(i);
	}
	
	//Get the index of a class based on its name
	public static int getSpecificClassIndex(String className) {
		int i = 0;
		boolean classFound = false;
		
		for(i=0; i < specificClasses.size(); i++) {
			if(specificClasses.get(i).getName().equals(className)) {
				classFound = true;
				break;
			}
		}
		

		if(!classFound) {
			i = -1;
		}
		
		return i;
	}
	
	//Look for a specific class based on its index
	public static SClass getSpecificClass(int index) {
		
		SClass clase = null;
		
		if(index <=  specificClasses.size()) {
			clase = specificClasses.get(index);
		}
		return clase;
	}
	
	//Find out the active hours for every teacher in the university
	public static void calculateActiveHours() {
		
		for(int i=0; i<teachers.size();i++) {
			teachers.get(i).setActiveHours(specificClasses);
		}
		
	}
	
}
