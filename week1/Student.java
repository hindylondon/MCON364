package week1;

import java.util.Objects;

//student class, a student has a name and grade
public class Student implements Comparable<Student> {
	// fields
	private String name;
	private int grade;

	// constructor
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	// compares students by their grades
	@Override
	public int compareTo(Student o) {
		return this.getGrade() - o.getGrade();
	}

	// toString displays neatly name and grade
	@Override
	public String toString() {
		return "Name: " + name + " Grade: " + grade;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    Student student = (Student) obj;
	    return grade == student.grade && Objects.equals(name, student.name);
	}



}