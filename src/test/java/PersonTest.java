import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person Class Tests")
public class PersonTest {
    private Person person;
    private Person personWithParams;

    @BeforeEach
    void setUp() {
        person = new Person();
        personWithParams = new Person("Alice Smith", 25);
    }

    @Test
    @DisplayName("Default constructor should create Person with 'John Doe' name and age 42")
    void testDefaultConstructor() {
        assertEquals("John Doe", person.getName());
        assertEquals(42, person.getAge());
    }

    @Test
    @DisplayName("Parameterized constructor should create Person with specified name and age")
    void testParameterizedConstructor() {
        assertEquals("Alice Smith", personWithParams.getName());
        assertEquals(25, personWithParams.getAge());
    }

    @Test
    @DisplayName("setName() should update the person's name")
    void testSetName() {
        person.setName("Bob Johnson");
        assertEquals("Bob Johnson", person.getName());
    }

    @Test
    @DisplayName("getName() should return the current name")
    void testGetName() {
        assertEquals("John Doe", person.getName());
        assertEquals("Alice Smith", personWithParams.getName());
    }

    @Test
    @DisplayName("setAge() should update the person's age")
    void testSetAge() {
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    @DisplayName("getAge() should return the current age")
    void testGetAge() {
        assertEquals(42, person.getAge());
        assertEquals(25, personWithParams.getAge());
    }

    @Test
    @DisplayName("hasBirthday() should increment age by 1")
    void testHasBirthday() {
        int originalAge = person.getAge();
        person.hasBirthday();
        assertEquals(originalAge + 1, person.getAge());
    }

    @Test
    @DisplayName("toString() should return formatted string with name and age")
    void testToString() {
        String expected = "My name is John Doe and I am 42 years old.";
        assertEquals(expected, person.toString());
    }

    @Test
    @DisplayName("compareTo() should compare persons by age correctly")
    void testCompareTo() {
        Person younger = new Person("Young Person", 20);
        Person older = new Person("Old Person", 50);
        Person sameAge = new Person("Same Age", 25);
        
        assertTrue(personWithParams.compareTo(younger) > 0);
        assertTrue(personWithParams.compareTo(older) < 0);
        assertEquals(0, personWithParams.compareTo(sameAge));
    }
}