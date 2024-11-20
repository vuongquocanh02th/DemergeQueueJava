import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DemergeQueue {
    public static List<Person> readFromFile(String fileName) throws IOException {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String fullName = parts[0];
                String gender = parts[1];
                Date birthDate = parseDate(parts[2]);
                people.add(new Person(fullName, gender, birthDate));
            }
        }
        return people;
    }
    public static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void writeToFile(String fileName, Queue<Person> queueNU, Queue<Person> queueNAM) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Ghi dữ liệu nữ trước
            while (!queueNU.isEmpty()) {
                writer.write(queueNU.poll().toString());
                writer.newLine();
            }
            // Ghi dữ liệu nam sau
            while (!queueNAM.isEmpty()) {
                writer.write(queueNAM.poll().toString());
                writer.newLine();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        List<Person> people = readFromFile("input.txt");
        Queue<Person> queueNU = new LinkedList<>();
        Queue<Person> queueNAM = new LinkedList<>();
        for (Person person : people) {
            if (person.gender.equals("NU")) {
                queueNU.add(person);
            } else if (person.gender.equals("NAM")) {
                queueNAM.add(person);
            }
        }
        writeToFile("output.txt", queueNU, queueNAM);
    }
}
