package app;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

import domain.Experience;
import domain.Schedule;
import domain.Student;
import domain.Teacher;
import instruments.ElectricalStringedInstrument;
import instruments.Flute;
import instruments.Note;
import instruments.StringedInstrument;
import util.OfferComparator;

public class School {
	private static HashSet<Student> studentCollection;
	private static HashSet<Teacher> teacherCollection;
	private static Schedule yearSchedule;

	public static void main(String[] args) {
		studentCollection = new HashSet<>();
		teacherCollection = new HashSet<>();

		StringedInstrument piano = new StringedInstrument("Piano", 2, 164, 3);
		
		StringedInstrument classicalGuitar = new StringedInstrument("Classical Guitar", 4, 6);
		StringedInstrument steelString = new StringedInstrument("Steelstring Guitar", 4, 6);
		StringedInstrument fentrop = new ElectricalStringedInstrument("Fentrop electrical guitar", 4, 6, 60, 100);
		
		Flute garklein = new Flute("Garklein", 5, 2, 17, Note.C);
		Flute soprano = new Flute("Soprano flute", 5, 6, 32, Note.C);
		Flute tenor = new Flute("Tenor flute", 5, 12, 62, Note.C);
		Flute bass = new Flute("Bass flute", 5, 22, 93, Note.F);
		Flute contrabass = new Flute("Contrabass flute", 5, 40, 200, Note.F);
		
		Student jan = new Student("Jan", classicalGuitar);
		Student piet = new Student("Piet", steelString);
		Student fatima = new Student("Fatima", garklein);
		Student imane = new Student("Imane", soprano);
		Student mary = new Student("Mary", piano, Experience.NONE);
		Student skye = new Student("Skye", piano, BigDecimal.valueOf(53), Experience.MEDIUM);
		Student titas = new Student("Titas", bass, BigDecimal.valueOf(13));
		Student adi = new Student("Adi", contrabass, BigDecimal.valueOf(95));

		addStudent(jan);
		addStudent(piet);
		addStudent(fatima);
		addStudent(skye);
		addStudent(titas);
		addStudent(adi);
		addStudent(imane);
		addStudent(mary);
		
		Teacher bob = new Teacher("Bob", 6); // Make generic
		bob.addInstrument(fentrop);
		bob.addInstrument(steelString);
		
		Teacher alice = new Teacher("Alice", 12); // Make generic
		alice.addInstrument(garklein);
		alice.addInstrument(soprano);
		alice.addInstrument(tenor);

		Teacher carrie = new Teacher("Carrie", 1);
		carrie.addInstrument(piano);

		Teacher damian = new Teacher("Damian", 0);
		damian.addInstrument(fentrop);

		addTeacher(bob);
		addTeacher(alice);
		addTeacher(carrie);
		addTeacher(damian);


		yearSchedule = newSchedule(2022);
		System.out.println(yearSchedule);
		yearSchedule.setComparator(new OfferComparator());
		yearSchedule = newSchedule(yearSchedule);
		System.out.println(yearSchedule);
	}

	private static void addStudent(Student s){
		studentCollection.add(s);
	}

	private static void addTeacher(Teacher t){
		teacherCollection.add(t);
	}

	private static Schedule newSchedule(int year){
		yearSchedule = new Schedule(year);

		addTeachersToSchedule(yearSchedule, teacherCollection);
		addStudentsToTeacher(teacherCollection, studentCollection, yearSchedule);

		return yearSchedule;
	}

	private static Schedule newSchedule(Schedule oldSchedule){
		while (oldSchedule.getWaitList().peek() != null){
			addStudent(oldSchedule.getWaitList().poll());
		}
		yearSchedule = new Schedule(oldSchedule.getYear()+1);

		addTeachersToSchedule(yearSchedule, teacherCollection);
		addStudentsToTeacher(teacherCollection, studentCollection, yearSchedule);

		return yearSchedule;
	}

	private static void addTeachersToSchedule(Schedule schedule, Collection<Teacher> teachers){
		for (Teacher in: teachers){
			schedule.addTeacher(in);
		}
	}

	private static void addStudentsToTeacher(Collection<Teacher> teachers, Collection<Student> students, Schedule schedule){
		for (Student in: students){
			int i = 0;
			while (i == 0) {
				for (Teacher teacher: teachers){
					if (teacher.addStudent(in)){
						i++;
					}
					i++;
				}
			}
			schedule.addToList(in);
		}
	}
}
