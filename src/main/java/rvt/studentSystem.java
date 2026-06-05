package rvt;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class StudentSystem {
    private static final String FILE_NAME = "students.csv";
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadFromFile();
        while (true) {
            System.out.println("\nCommands: register, show, remove, edit, exit");
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("exit")) break;
            
            switch (command) {
                case "register": register(); break;
                case "show": show(); break;
                case "remove": remove(); break;
                case "edit": edit(); break;
                default: System.out.println("Nezinama komanda!");
            }
        }
    }

    private static void register() {
        try {
            System.out.print("First Name: ");
            String fName = validateInput("^[a-zA-Z]{3,}$", "Min 3 letters.");
            System.out.print("Last Name: ");
            String lName = validateInput("^[a-zA-Z]{3,}$", "Min 3 letters.");
            System.out.print("Email: ");
            String email = validateInput("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "Invalid email.");
            System.out.print("Personal Code: ");
            String pCode = validateInput("^\\d{6}-\\d{5}$", "Format: 123456-12345");

            String date = new java.util.Date().toString();
            students.add(new Student(fName, lName, email, pCode, date));
            saveToFile();
            System.out.println("Regisraciaja veiksmiga!");
        } catch (Exception e) {
            System.out.println("Kļuda: " + e.getMessage());
        }
    }

    private static void show() {
        System.out.println("+------------+------------+----------------------+-----------------+---------------------------+");
        System.out.println("| Vards      | Uzvards    | Email                | Personal Code   | Registration Date         |");
        System.out.println("+------------+------------+----------------------+-----------------+---------------------------+");
        for (Student s : students) System.out.println(s);
        System.out.println("+------------+------------+----------------------+-----------------+---------------------------+");
    }

    private static void remove() {
        System.out.print("Ievadi personalo kodu lai izdzēstu: ");
        String pCode = scanner.nextLine();
        for (Student s : students) {
            if (s.personalKods.equals(pCode)) {
                System.out.print("Jaunais email: ");
                s.email = scanner.nextLine();
                saveToFile();
                return;
            }
        }
        System.out.println("Nav atrasts.");
    }

    private static void edit() {
        System.out.print("Enter Personal Code to edit: ");
        String code = scanner.nextLine();
        for (Student s : students) {
            if (s.personalKods.equals(code)) {
                System.out.print("New Email: ");
                s.email = scanner.nextLine();
                saveToFile();
                return;
            }
        }
        System.out.println("Not found.");
    }

    private static String validateInput(String regex, String error) throws Exception {
        String input = scanner.nextLine();
        if (!Pattern.matches(regex, input)) throw new Exception(error);
        return input;
    }

    private static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) pw.println(s.toCsv());
        } catch (IOException e) {
            System.out.println("Kļuda saglabājot failu: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                String[] data = fs.nextLine().split(",");
                if (data.length == 5) students.add(new Student(data[0], data[1], data[2], data[3], data[4]));
            }
        } catch (IOException e) {
            System.out.println("Kļuda ielādējot failu: " + e.getMessage());
        }
    }
}

class Student {
    String Vards;
    String Uzvards;
    String email;
    String personalKods;
    String registracijasDatums;

    Student(String vards, String uzvards, String email, String personalKods, String registracijasDatums) {
        this.Vards = vards;
        this.Uzvards = uzvards;
        this.email = email;
        this.personalKods = personalKods;
        this.registracijasDatums = registracijasDatums;
    }

    public String toCsv() {
        return Vards + "," + Uzvards + "," + email + "," + personalKods + "," + registracijasDatums;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-20s | %-15s | %-20s |", 
        Vards, Uzvards, email, personalKods, registracijasDatums);
    }
}