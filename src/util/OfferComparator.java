package util;

import java.util.Comparator;
import domain.Student;

public class OfferComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b){
        System.out.println("comparing");
        int compared = a.getOffer().compareTo(b.getOffer());
        if (compared != 0){ // if offer is not equal, return comparison
            return compared;
        } else { // if offer is equal, return comparison of experience
            return a.getExperience().compareTo(b.getExperience());
        }
    }
}
