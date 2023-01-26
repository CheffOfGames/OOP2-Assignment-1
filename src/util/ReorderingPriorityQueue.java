package util;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorderingPriorityQueue<Student> extends PriorityQueue<Student> {

    PriorityQueue<Student> usedQueue;

    public ReorderingPriorityQueue() {
        this.usedQueue = new PriorityQueue<Student>();
    }

    public PriorityQueue<Student> setComparator(Comparator<Student> c){
        PriorityQueue<Student> newQueue = new PriorityQueue<Student>(c);
        for (Student in: this.usedQueue){
            newQueue.add(in);
        }
        this.usedQueue = newQueue;
        return this.usedQueue;
    }
    
}
