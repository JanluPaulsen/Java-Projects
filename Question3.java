package question.pkg3;

import java.util.*;//imports libraries

public class Question3 {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQ1 = new PriorityQueue<String>();//creates priority

        priorityQ1.add("Riaan");//adds to priority
        priorityQ1.add("Kabelo");
        priorityQ1.add("Palesa");
        priorityQ1.add("Thando");
        priorityQ1.add("Marianne");
        priorityQ1.add("Andile");
        
        System.out.println("Elements in the First Priority Queue:");//prints to console
        System.out.println(priorityQ1);

        PriorityQueue<String> priorityQ2 = new PriorityQueue<String>();//creates priority

        priorityQ2.add("Charles");//adds to priority
        priorityQ2.add("Palesa");
        priorityQ2.add("Tshifhiwa");
        priorityQ2.add("Xolisa");
        priorityQ2.add("Andries");
        priorityQ2.add("Thando");
        
        System.out.println("Elements in the Second Priority Queue:");
        System.out.println(priorityQ1);
        
        Object[] tempQ1 = priorityQ1.toArray();//creates arrays from priorities
        Object[] tempQ2 = priorityQ2.toArray();
        
        PriorityQueue<String> priorityQ3 = new PriorityQueue<String>();
        
        //loops through array to check what names are in both priorities
        for (int i = 0; i < tempQ1.length; i++) {

            for (int j = 0; j < tempQ2.length; j++) {

                if (tempQ1[j] == tempQ2[i]) {

                    priorityQ3.add(tempQ1[j].toString());//adds it to the last set

                }

            }

        }
        
        System.out.println("Elements in the Third Priority Queue:");
        System.out.println(priorityQ3);//displays set

    }
    
}
