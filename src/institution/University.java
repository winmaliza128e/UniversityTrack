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
			//System.out.println("Teachers get name:"+teachers.get(i).getName());
			if(teachers.get(i).getName().equals(teacherName)) {
				teacherFound = true;
				//System.out.println("Teacher encontrado...");
				break;
			}
		}
		

		if(!teacherFound) {
			return null;
		}
		
		//System.out.println("index before returning:"+i);
		return teachers.get(i);
	}
	
	//Find out the active hours for every teacher in the university
	public static void calculateActiveHours() {
		
		for(int i=0; i<teachers.size();i++) {
			//System.out.println("CAlculating active hours:"+teachers.get(i).getName());
			teachers.get(i).setActiveHours(specificClasses);
		}
		//System.out.println("Calculating active hours finished");
	}
	
	
	//Validate if a universityID is assigned to an actual stakeholder.
	//If so, it returns stakeholder's name

	//TODO: Implement if time available
	public static String validateUniversityId(String universityID) {
		return "";
	}
}
