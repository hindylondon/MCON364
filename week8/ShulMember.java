package week8;

import java.time.LocalDate;
import java.util.*;

public class ShulMember implements Comparable<ShulMember> {
	String lastNameOfMember;
	String firstNameOfMember;
	LocalDate birthDateOfMember;
	String spouseFirstName;
	String spouseLastName;
	String[] childrenNames;
	int yearsOfMembership;

	public ShulMember(String lastNameOfMember, String firstNameOfMember, LocalDate birthDateOfMember,
			String spouseFirstName, String spouseLastName, String[] childrenNames, int yearsOfMembership) {
		this.lastNameOfMember = lastNameOfMember;
		this.firstNameOfMember = firstNameOfMember;
		this.birthDateOfMember = birthDateOfMember;
		this.spouseFirstName = spouseFirstName;
		this.spouseLastName = spouseLastName;
		this.childrenNames = childrenNames;
		this.yearsOfMembership = yearsOfMembership;
	}

	public String getLastNameOfMember() {
		return lastNameOfMember;
	}

	public void setLastNameOfMember(String lastNameOfMember) {
		this.lastNameOfMember = lastNameOfMember;
	}

	public String getFirstNameOfMember() {
		return firstNameOfMember;
	}

	public void setFirstNameOfMember(String firstNameOfMember) {
		this.firstNameOfMember = firstNameOfMember;
	}

	public LocalDate getBirthDateOfMember() {
		return birthDateOfMember;
	}

	public void setBirthDateOfMember(LocalDate birthDateOfMember) {
		this.birthDateOfMember = birthDateOfMember;
	}

	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	public void setSpouseFirstName(String spouseFirstName) {
		this.spouseFirstName = spouseFirstName;
	}

	public String getSpouseLastName() {
		return spouseLastName;
	}

	public void setSpouseLastName(String spouseLastName) {
		this.spouseLastName = spouseLastName;
	}

	public String[] getChildrenNames() {
		return childrenNames;
	}

	public void setChildrenNames(String[] childrenNames) {
		this.childrenNames = childrenNames;
	}

	public int getYearsOfMembership() {
		return yearsOfMembership;
	}

	public void setYearsOfMembership(int yearsOfMembership) {
		this.yearsOfMembership = yearsOfMembership;
	}

	public int compareTo(ShulMember other) {
		// for age of member
		return this.birthDateOfMember.compareTo(other.birthDateOfMember);
	}
	
	@Override
    public String toString() {
        return "Last Name: " + lastNameOfMember + 
                ", First Name: " + firstNameOfMember + 
                ", Birth Date: " + birthDateOfMember +
                ", Spouse First Name: " + spouseFirstName + 
                ", Spouse Last Name: " + spouseLastName + 
                ", Children's Names: " + Arrays.toString(childrenNames) +
                ", Years of Memberships: " + yearsOfMembership;
    }
}
