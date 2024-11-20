import java.io.*;
import java.util.*;

public class Person {
    String fullName;
    String gender;
    Date birthDate;
    public Person(String fullName, String gender, Date birthDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return fullName + ", " + gender + ", " + birthDate;
    }
}
