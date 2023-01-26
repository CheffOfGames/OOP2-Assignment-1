package util;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorderingPriorityQueue<Student> extends PriorityQueue {

    PriorityQueue<Student> queue;

    public ReorderingPriorityQueue() {
        this.queue = new PriorityQueue<Student>();
    }

    public PriorityQueue setComparator(){
        PriorityQueue<Student> newqueue = new PriorityQueue<Student>((Comparator)new OfferComparator());
        for (Student in: this.queue){
            newqueue.add(in);
        }
        this.queue = newqueue;
        return this.queue;
    }
    
}
