package second;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MyHashList {

    private static final int size = 13;

    LinkedList<String>[] arr = new LinkedList[13];

    public boolean add(String value) {
        if (value == null || value.isEmpty())
            return false;
        int index = hashString(value) % size;
        if (arr[index] == null)
            arr[index] = new LinkedList<>();
        return arr[index].add(value);
    }

    public int find(String value) {
        if (value == null || value.isEmpty())
            return -1;
        int index = hashString(value) % size;
        if (arr[index] == null)
            return -1;
        if (!arr[index].contains(value))
            return -1;
        return index;
    }

    public boolean delete(String value) {
        if (value == null || value.isEmpty())
            return false;
        int index = hashString(value) % size;
        if (arr[index] == null)
            return false;
        if (!arr[index].contains(value))
            return false;
        return arr[index].remove(value);
    }

    public int size() {
        int ctr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                ctr += arr[i].size();
        }
        return ctr;
    }

    public static int hashString(String str) {
        int sum = 0;
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sum += str.charAt(i);
            if (i != 0)
                sum <<= 4;
        }
        return sum;
    }

}
