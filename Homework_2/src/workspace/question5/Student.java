package workspace.question5;

public class Student {
	int id;
	String firstName, lastName, course;
	
	
	
	
	public Student(int iD, String firstName, String lastName, String course) {
		id = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
	}
	
	
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + "]";
	}
	
	
	
	
	
	
}
