package src.test.java;

import org.junit.jupiter.api.Test;

import src.main.java.Person;
import src.main.java.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Student Class Tests")
public class StudentTest {
    private Student student;
    private Student studentWithParams;

    @BeforeEach
    void setUp() {
        student = new Student();
        studentWithParams = new Student("Jane Doe", 20, 3.8);
    }

    @Test
    @DisplayName("Default constructor should create Student with default Person values and GPA 3.0")
    void testDefaultConstructor() {
        assertEquals("John Doe", student.getName());
        assertEquals(42, student.getAge());
        assertEquals(3.0, student.getGPA(), 0.001);
    }

    @Test
    @DisplayName("Parameterized constructor should create Student with specified name, age, and GPA")
    void testParameterizedConstructor() {
        assertEquals("Jane Doe", studentWithParams.getName());
        assertEquals(20, studentWithParams.getAge());
        assertEquals(3.8, studentWithParams.getGPA(), 0.001);
    }

    @Test
    @DisplayName("getGPA() should return the current GPA value")
    void testGetGPA() {
        assertEquals(3.0, student.getGPA(), 0.001);
        assertEquals(3.8, studentWithParams.getGPA(), 0.001);
    }

    @Test
    @DisplayName("setGPA() should update the student's GPA")
    void testSetGPA() {
        student.setGPA(3.5);
        assertEquals(3.5, student.getGPA(), 0.001);
    }

    @Test
    @DisplayName("toString() should return formatted string with name, age, and GPA")
    void testToString() {
        String expected = "My name is John Doe and I am 42 years old.\nI have a GPA of 3.0";
        assertEquals(expected, student.toString());
        
        String expectedParams = "My name is Jane Doe and I am 20 years old.\nI have a GPA of 3.8";
        assertEquals(expectedParams, studentWithParams.toString());
    }

    @Test
    @DisplayName("Student should inherit all Person methods correctly")
    void testInheritedMethods() {
        studentWithParams.setName("New Name");
        assertEquals("New Name", studentWithParams.getName());
        
        studentWithParams.setAge(25);
        assertEquals(25, studentWithParams.getAge());
        
        int originalAge = studentWithParams.getAge();
        studentWithParams.hasBirthday();
        assertEquals(originalAge + 1, studentWithParams.getAge());
    }

    @Test
    @DisplayName("compareTo() should compare students by age (inherited from Person)")
    void testCompareTo() {
        Student younger = new Student("Young Student", 18, 3.5);
        Student older = new Student("Old Student", 25, 2.8);
        Student sameAge = new Student("Same Age Student", 20, 3.2);
        
        assertTrue(studentWithParams.compareTo(younger) > 0);
        assertTrue(studentWithParams.compareTo(older) < 0);
        assertEquals(0, studentWithParams.compareTo(sameAge));
    }

    @Test
    @DisplayName("Student should work correctly with polymorphism (Student as Person)")
    void testPolymorphism() {
        Person personRef = new Student("Poly Student", 21, 3.9);
        assertEquals("Poly Student", personRef.getName());
        assertEquals(21, personRef.getAge());
        
        String expected = "My name is Poly Student and I am 21 years old.\nI have a GPA of 3.9";
        assertEquals(expected, personRef.toString());
    }
}