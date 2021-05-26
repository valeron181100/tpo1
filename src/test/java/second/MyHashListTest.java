package second;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for MyHashList")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyHashListTest {

    private MyHashList list = new MyHashList();

    @Before
    public void initList() {
        list.setLogger(log -> System.out.flush());
        list.add("q");
        list.add("qw");
        list.add("qwe");
        list.add("qwer");
        list.add("qwert");
        list.add("qwerty");
    }

    @Test
    @DisplayName("тест на добавление пустой строки")
    public void testAddEmptyString() {
        String expected = "add: operation began\n" +
                "add: value is null or empty\n";
        String realOutput = "";
        StringBuilder stringBuilder = new StringBuilder();
        list.setLogger( log -> stringBuilder.append(log).append("\n"));
        list.add("");
        realOutput = stringBuilder.toString();
        assertEquals(expected, realOutput);
    }

    @Test
    @DisplayName("тест на добавление null")
    public void testAddNothing() {
        String expected = "add: operation began\n" +
                "add: value is null or empty\n";
        String realOutput = "";
        StringBuilder stringBuilder = new StringBuilder();
        list.setLogger( log -> stringBuilder.append(log).append("\n"));
        list.add(null);
        realOutput = stringBuilder.toString();
        assertEquals(expected, realOutput);
    }

    @Test
    @DisplayName("тест на разрешение коллизий")
    public void testResolveCollisions() {
        String expected = "add: operation began\n" +
                "add: hash of the given string = 440711\n" +
                "add: bucket index = 11\n" +
                "add: value was added\n" +
                "find: hash of the given string = 440711\n" +
                "find: bucket index = 11\n" +
                "find: value was found in bucket with index = 11\n" +
                "find: hash of the given string = 494817\n" +
                "find: bucket index = 11\n" +
                "find: value was found in bucket with index = 11\n";
        String realOutput = "";
        StringBuilder stringBuilder = new StringBuilder();
        list.setLogger( log -> stringBuilder.append(log).append("\n"));
        list.add("wasd");
        list.find("wasd");
        list.find("qwer");
        realOutput = stringBuilder.toString();
        assertEquals(expected, realOutput);
    }

    @Test
    @DisplayName("тест на хеширование")
    public void testHashStrings() {
        assertEquals(134974689, MyHashList.hashString("qwerty"));
    }

}
