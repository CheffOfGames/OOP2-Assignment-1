package domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import instruments.Instrument;
import util.NotYetImplementedException;

public class Teacher {
	private String name;
	private int maxStudents;
	private HashSet<Student> students;
	private Set<Instrument> instruments;
	
	public Teacher(String name, int maxStudents) {
		super();
		this.name = name;
		this.maxStudents = maxStudents;
		this.instruments = new HashSet<>();
		this.students = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public HashSet<Student> getStudents(){
		return this.students;
	}

	public boolean addStudent(Student student){
		if (this.students.size() >= this.maxStudents){
			return false;
		} else {
			return this.students.add(student);
		}
	}

	public void removeStudents(){
		this.students = new HashSet<Student>();
	}
    
	public Set getInstruments() {
		return this.instruments;
	}

	public boolean addInstrument(Instrument instrument) {
		return instruments.add(instrument);
	}
	
	public boolean removeInstrument(Instrument instrument) {
		return instruments.remove(instrument);
	}
	
	public boolean teaches(Instrument instrument) {
		for (Instrument in: instruments) {
			if (in.equals(instrument)) {
				return true;
			}
		}
		return false;
	}
	
	public BigDecimal getHourlyWage() {
		throw new NotYetImplementedException();
	}
}
