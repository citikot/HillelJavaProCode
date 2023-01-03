package lesson10.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MainQueue {
    public static void main(String[] args) {
        //FIFO
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        System.out.println("1: " + queue);

        int removedElement = queue.remove();
        System.out.println("2: " + removedElement);
        System.out.println("3: " + queue);

        System.out.println("4: " + queue.peek());

        
        //LIFO
        Deque<Integer> deque = (Deque<Integer>) queue;
        
        System.out.println("2: " + deque);
        
        removedElement = deque.removeLast();
        System.out.println("3: " + removedElement);
        System.out.println("4: " + deque);

        System.out.println("5: " + deque.peekLast());
        
        //ArrayDeque<E>
        //Stack<E>
        //PriorityQueue<E>
    }
}
