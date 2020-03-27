package institution;

//UClass defines a kind of class belonging to a degree program
//For instance Soil Mechanics belongs to degree of Civil Engineering


public class UClass {
	private String name;
	
	private String degreeProgram; //potential class
	
	//Class hours expected per week
	private int hourLoad;
	//Semester to which the class belongs to
	private int semester;
	
	public UClass(String name, String degreeProgram, int hourLoad, int semester) {
		this.name = name;
		this.degreeProgram = degreeProgram;
		this.hourLoad = hourLoad;
		this.semester = semester;
	}

	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegreeProgram() {
		return degreeProgram;
	}

	public void setDegreeProgram(String degreeProgram) {
		this.degreeProgram = degreeProgram;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public void setHourLoad(int hourLoad) {
		this.hourLoad = hourLoad;
	}
	public int getHourLoad() {
		return hourLoad;
	}
	
	//Overriding method toString to print information of the class
	public String toString() {
		return("-------------------------------------------------------------\n"+
	           "Class              :"+name +"\n"+
	           "Degree Program     :"+degreeProgram+"\n"+
	           "Hour Load (weekly) :"+hourLoad +"\n"+
	           "Semester           :"+semester);
	}

	

}
