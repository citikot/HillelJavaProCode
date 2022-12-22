package lesson08.list;

import java.util.LinkedList;

public class MainLinkedList {
    public static void main(String[] args) {
        addExample();

        removeExample();
    }

    private static void addExample() {
        LinkedList<String> linkedList1 = new LinkedList<String>();
        System.out.println("1: Initial list of elements: " + linkedList1);
        linkedList1.add("Ravi");
        linkedList1.add("Vijay");
        linkedList1.add("Ajay");
        System.out.println("2: After invoking add(E e) method: " + linkedList1);

        //Adding an element at the specific position  
        linkedList1.add(1, "Gaurav");
        System.out.println("3: After invoking add(int index, E element) method: " + linkedList1);

        LinkedList<String> linkedList2 = new LinkedList<String>();
        linkedList2.add("Sonoo");
        linkedList2.add("Hanumat");

        //Adding second list elements to the first list  
        linkedList1.addAll(linkedList2);
        System.out.println("4: After invoking addAll(Collection<? extends E> c) method: " + linkedList1);
        LinkedList<String> ll3 = new LinkedList<String>();
        ll3.add("John");
        ll3.add("Rahul");

        //Adding second list elements to the first list at specific position  
        linkedList1.addAll(1, ll3);
        System.out.println("5: After invoking addAll(int index, Collection<? extends E> c) method: " + linkedList1);

        //Adding an element at the first position  
        linkedList1.addFirst("Lokesh");
        System.out.println("6: After invoking addFirst(E e) method: " + linkedList1);

        //Adding an element at the last position  
        linkedList1.addLast("Harsh");
        System.out.println("7: After invoking addLast(E e) method: " + linkedList1);
    }
    
    private static void removeExample() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Ravi");
        linkedList.add("Vijay");
        linkedList.add("Ajay");
        linkedList.add("Anuj");
        linkedList.add("Gaurav");
        linkedList.add("Harsh");
        linkedList.add("Virat");
        linkedList.add("Gaurav");
        linkedList.add("Harsh");
        linkedList.add("Amit");
        System.out.println("8: Initial list of elements: " + linkedList);
        
        //Removing specific element from arraylist  
        linkedList.remove("Vijay");
        System.out.println("9: After invoking remove(object) method: " + linkedList);
        
        //Removing element on the basis of specific position  
        linkedList.remove(0);
        System.out.println("10: After invoking remove(index) method: " + linkedList);
        
        LinkedList<String> linkedList2 = new LinkedList<String>();
        linkedList2.add("Ravi");
        linkedList2.add("Hanumat");
        
        // Adding new elements to arraylist  
        linkedList.addAll(linkedList2);
        System.out.println("11: Updated list : " + linkedList);
        
        //Removing all the new elements from arraylist  
        linkedList.removeAll(linkedList2);
        System.out.println("12: After invoking removeAll() method: " + linkedList);
        
        //Removing first element from the list  
        linkedList.removeFirst();
        System.out.println("13: After invoking removeFirst() method: " + linkedList);
        
        //Removing first element from the list  
        linkedList.removeLast();
        System.out.println("14: After invoking removeLast() method: " + linkedList);
        
        //Removing first occurrence of element from the list  
        linkedList.removeFirstOccurrence("Gaurav");
        System.out.println("15: After invoking removeFirstOccurrence() method: " + linkedList);
        
        //Removing last occurrence of element from the list  
        linkedList.removeLastOccurrence("Harsh");
        System.out.println("16: After invoking removeLastOccurrence() method: " + linkedList);

        //Removing all the elements available in the list       
        linkedList.clear();
        System.out.println("17: After invoking clear() method: " + linkedList);
    }
}
