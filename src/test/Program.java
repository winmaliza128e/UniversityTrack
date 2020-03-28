package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import people.*;
import institution.*;

public class Program {

	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
        // Setting initial objects
		createTeachers();
		createStudents();
		scheduleClasses();	
		University.calculateActiveHours();
		
		//Executing menu
		menu();
	}
	
	// ------------------   METHODS TO INITIALIZE DATA ----------------------
	
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
		University.specificClasses.get(0).addAttendant(University.students.get(0));
		University.specificClasses.get(0).addAttendant(University.students.get(1));
		University.specificClasses.get(0).addAttendant(University.students.get(2));
		University.specificClasses.get(0).addAttendant(University.students.get(3));
		University.specificClasses.get(0).addAttendant(University.students.get(4));
		University.specificClasses.get(0).addAttendant(University.students.get(5));
		
		University.specificClasses.add(new SClass("Fluids", "Physics", 6, 2));
		University.specificClasses.get(1).scheduleClass("A312", "2020-I", University.getTeacher("Leonard Hofstadter"));
		University.specificClasses.get(1).addAttendant(University.students.get(5));
		
		University.specificClasses.add(new SClass("Medical Ethics", "Medicine", 4, 1));
		University.specificClasses.get(2).scheduleClass("A312", "2020-I", University.getTeacher("James Blake"));
		
		University.specificClasses.add(new SClass("General Anatomy", "Medicine", 10, 1));
		University.specificClasses.get(3).scheduleClass("C705", "2020-I", University.getTeacher("James Blake"));
		
	}
	
	//-------------------------------------------------------------------------
	//-------------------------------------------------------------------------
	//---------------------------- METHODS FOR MENU  --------------------------------
			private static void menu() {
				System.out.println("***************  UNIVERSITY TRACK SYSTEM EMARINLI*****************\n\n\n\n");
				System.out.println("[1] VIEW PROFESSORS");
				System.out.println("[2] VIEW CLASSES");
				System.out.println("[3] CREATE STUDENT");
				System.out.println("[4] CREATE CLASSES");
				System.out.println("[5] VIEW STUDENTS");
				System.out.println("[9] EXIT\n");
				System.out.print("Please enter your option --->");
				String option = userInput.nextLine();
				executeOption(option);

			}
			
			private static void executeOption(String option) {
				switch (option) {
					case "1":
						printTeachersStaff();
						break;
						
					case "2":
						printSpecificClasses();
						Scanner localInput = new Scanner(System.in);
						System.out.println("View details (y/n):");
						if(localInput.nextLine().equalsIgnoreCase("y")){
							System.out.println("Enter name of the class to see details--->");
							printAttendants(localInput.nextLine());
						}
						break;
					case "3":
						createStudent();
						break;	
					case "4":
						createClass();
						break;	
					case "5":
						printStudents();
						Scanner localInput2 = new Scanner(System.in);
						System.out.println("View details (y/n):");
						if(localInput2.nextLine().equalsIgnoreCase("y")){
							System.out.println("Enter universityID to see details--->");
							getClassesAttendedByStudent(localInput2.nextLine());
						}
						break;	

					default:
						System.out.println("Invalid option. Please try again");
				}
				System.out.println("Do you want to come back to main menu (y/n):");
				if(userInput.nextLine().equalsIgnoreCase("y")) {
					menu();
				}
				else
				{
					System.out.println("Thanks. See you!!");
				}
			}
	
	// ------------------   METHODS TO PERFORM ACTIONS ----------------------
	
	//Look for the classes attended by a student, given its universityID
	private static void getClassesAttendedByStudent(String studentID){
		List<String> classes = new ArrayList<String>(); 
		classes = University.students.get(0).getAttendedClasses(University.specificClasses,studentID);
		
		for(int i=0; i < classes.size(); i++) {
			System.out.println(classes.get(i));
		}
		
	}
	
	//Print all teachers (professors)
	private static void printTeachersStaff() {
		System.out.println("------------  TEACHERS STAFF --------------\n");
		for(int i=0; i < University.teachers.size(); i++) {
			System.out.println(University.teachers.get(i));
		}
	}
	
	//Print all classes scheduled for degree Programs
		private static void printSpecificClasses() {
		
			System.out.println("------------  CLASSES --------------\n");
			for(int i=0; i < University.specificClasses.size(); i++) {
				System.out.println("["+(i+1)+"] "+University.specificClasses.get(i).getName() + 
						           " ["+University.specificClasses.get(i).getDegreeProgram()+"]");
			}
		}

		
		private static void printStudents() {
			System.out.println("------------  STUDENTS --------------\n");
			for(int i=0; i < University.students.size(); i++) {
				System.out.println(University.students.get(i));
			}			
		}
    //Print attendants of a specific class
		private static void printAttendants(String className) {
			
			SClass specificClass =  University.getSpecificClass(className);
			
			if(specificClass != null) {
				System.out.println(specificClass.getName());
				List<String> attendants = new ArrayList<String>();
				attendants = specificClass.getAttendantsList();
				
				for(int i=0; i < attendants.size(); i++) {
					System.out.println(attendants.get(i));
				}
				
				
			}
		}
		//-------------------------------------------------------------------------
		//-------------------------------------------------------------------------
		
		
		
		private static void createStudent() {
			Scanner localInput = new Scanner(System.in);
			System.out.println("Name:");
			String name = localInput.nextLine();
			System.out.println("Age:");
			int age=0;
			try {
			  age = localInput.nextInt();
			}catch(Exception e) {};
			System.out.println("Dni:");
			String dni = localInput.nextLine();
			System.out.println("UniversityID:");
			String universityID = localInput.nextLine();
			System.out.println("Degree Program:");
			String degreeProgram = localInput.nextLine();
			
			University.students.add(new Student(name, age, dni, universityID,degreeProgram));
			System.out.println("Student added successfully");
			System.out.println("Do you add them to a class (y/n)");
			
			if(localInput.nextLine().equalsIgnoreCase("y")) {
				printSpecificClasses();
				System.out.println("Enter name of the class to add:");
				String specificClass = localInput.nextLine();
				int classIndex = University.getSpecificClassIndex(specificClass);
				University.specificClasses.get(classIndex).addAttendant(University.students.get(University.students.size()-1));
				printAttendants(specificClass);
			}
			else
			{
				menu();
			}			
			
		}
		

	
		private static void createClass() {
			Scanner localInput = new Scanner(System.in);
			System.out.println("Name:");
			String name = localInput.nextLine();
			System.out.println("Degree Program:");
			String degreeProgram = localInput.nextLine();		
			System.out.println("Hour Load:");
			int hourLoad=0;
			try {
			  hourLoad = localInput.nextInt();
			}catch(Exception e) {};

            int semester=0;
			try {
				  semester = localInput.nextInt();
			}catch(Exception e) {};
	
			University.specificClasses.add(new SClass(name,degreeProgram,hourLoad,semester));
			System.out.println("Class added successfully");


		}		

	
}
