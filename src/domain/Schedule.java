package domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Schedule {
	private static BigDecimal basePrice = new BigDecimal("10.0");
	private int year;
	private Queue<Student> waitList;
	private Map<Teacher, HashSet<Student>> students;

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
	
	public void withdrawFromList(Student student) {
		waitList.remove(student);
	}

	public void addStudent(Teacher teacher, Student student) {
		teacher.addStudent(student);
	}
	
	public void addTeacher(Teacher teacher) {
		teacher.removeStudents();
		students.put(teacher,teacher.getStudents());
	}
	
	public void removeTeacher(Teacher teacher) {
		students.remove(teacher);
	}
	
	public void endOfYear() {
		this.students = new HashMap<>();
	}
}
