package domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import util.NotYetImplementedException;

public class Schedule {
	private static BigDecimal basePrice = new BigDecimal("10.0");
	private int year;
	private Queue waitList;
	private Map students; // Make generic

	public Schedule(int year) {
		this.year = year;
		this.waitList = new ConcurrentLinkedQueue<>();
		this.students = new HashMap<>();
	}

	public static BigDecimal getBasePrice() {
		return basePrice;
	}

	public static void setBasePrice(BigDecimal basePrice) {
		Schedule.basePrice = basePrice;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void addToList(Student student) {
		waitList.add(student);
	}
	
	public void withdrawFromList(Student student) { // Implement
		throw new NotYetImplementedException();
	}

	public void addStudent(Teacher teacher, Student student) { // Make generic and implement
		throw new NotYetImplementedException();
	}
	
	public void addTeacher(Teacher teacher) { // Make generic and implement
		throw new NotYetImplementedException();
	}
	
	public void removeTeacher(Teacher teacher) { // Make generic and implement
		throw new NotYetImplementedException();
	}
	
	public void endOfYear() { // Implement
		throw new NotYetImplementedException();
	}
}
