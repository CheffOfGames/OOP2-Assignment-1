package domain;

import java.math.BigDecimal;

import instruments.Instrument;
import static domain.Experience.*;

public class Student implements Comparable<Student> {
	private String name;
	private Instrument instrument;
	private BigDecimal offer;
	private Experience experience;
	
	public Student(String name, Instrument instrument) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = BigDecimal.ZERO;
		this.experience = NONE;
	}
	
	public Student(String name, Instrument instrument, BigDecimal offer) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = offer;
		this.experience = NONE;
	}
	
	public Student(String name, Instrument instrument, Experience experience) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = BigDecimal.ZERO;
		this.experience = NONE;
		this.experience = experience;
	}
	
	public Student(String name, Instrument instrument, BigDecimal offer, Experience experience) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = offer;
		this.experience = NONE;
		this.experience = experience;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public BigDecimal getOffer() {
		return offer;
	}

	public void setOffer(BigDecimal offer) {
		this.offer = offer;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	@Override
    public String toString() {
        return "Student [name=" + name + ", instrument=" + instrument + ", offer=" + offer + ", experience="
                + experience + "]";
    }

    @Override
	public int compareTo(Student o) {
		return this.getExperience().compareTo(o.getExperience());
	}
}
