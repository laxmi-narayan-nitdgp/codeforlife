package com.codeforlife;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static class Person {
        private int age;
        private int salary;
        private String name;
    }

    public static class Manager extends Person {
        private int age;
        private int salary;

        private String name;
    }

    public void solveMe() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
    }

    public static class Sort implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.salary > o2.salary ? -1 : 1;
        }
    }

    public String getMessage() {

        return " say hello world..";
    }
}
