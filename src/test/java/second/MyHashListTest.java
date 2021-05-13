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
        assertFalse(list.add(""));
    }

    @Test
    @DisplayName("тест на добавление null")
    public void testAddNothing() {
        assertFalse(list.add(null));
    }

    @Test
    @DisplayName("тест на разрешение коллизий")
    public void testResolveCollisions() {
        list.add("wasd");
        int wasdBucketIndex = list.find("wasd");
        int qwerBucketIndex = list.find("qwer");
        System.out.println(list.size());
        assertEquals(qwerBucketIndex, wasdBucketIndex);
    }

}
