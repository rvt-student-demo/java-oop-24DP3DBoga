package rvt.ToDoUzdevumi;

import java.util.*;

public class ToDoList {
    public static void main(String[] args) {

        ToDoList list = new ToDoList();
        list.add("read the course material");
        list.add("watch the latest fool us");
        list.add("take it easy");

        list.print();
        list.remove(2);

        System.out.println();
        list.print();
    }

    private ArrayList<String> tasks;

        ToDoList() {
            this.tasks = new ArrayList<>();
    }


    public void add(String task) {
        tasks.add(task);
    }


    public void print() {
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }

    }

    public void remove(int number) {
        tasks.remove(number - 1);
    }

}