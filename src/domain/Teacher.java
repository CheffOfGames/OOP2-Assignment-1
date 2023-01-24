package domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import instruments.Instrument;
import util.NotYetImplementedException;

public class Teacher { // Make generic {
	private String name;
	private int maxStudents;
	private Set instruments; // Make generic
	
	public Teacher(String name, int maxStudents) {
		super();
		this.name = name;
		this.maxStudents = maxStudents;
		this.instruments = new HashSet<>();
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

	public Set getInstruments() { // Make generic
		throw new NotYetImplementedException();
	}

	public boolean addInstrument(Object instrument) { // Make generic
		return instruments.add(instrument);
	}
	
	public boolean removeInstrument(Object instrument) { // Make generic
		return instruments.remove(instrument);
	}
	
	public boolean teaches(Object instrument) { // Make generic
		for (Object in: instruments) {
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
