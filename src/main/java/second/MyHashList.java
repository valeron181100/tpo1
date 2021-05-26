package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHashList {

    private static final int size = 13;
    private MyLogger logger;

    private List<String> logs = new ArrayList<>();

    LinkedList<String>[] arr = new LinkedList[13];

    public MyHashList() {
        logger = new MyLogger() {
            @Override
            public void log(String curRec) {
                System.out.println(curRec);
            }
        };
    }

    public boolean add(String value) {
        logger.log("add: operation began");
        if (value == null || value.isEmpty()) {
            logger.log("add: value is null or empty");
            return false;
        }
        int hash = hashString(value);
        logger.log("add: hash of the given string = " + hash);
        int index = hash % size;
        logger.log("add: bucket index = " + index);
        if (arr[index] == null)
            arr[index] = new LinkedList<>();
        boolean res = arr[index].add(value);
        logger.log("add: value was " + (res ? "" : "not ") + "added");
        return res;
    }

    public int find(String value) {
        if (value == null || value.isEmpty()){
            logger.log("find: value is null or empty");
            return -1;
        }
        int hash = hashString(value);
        logger.log("find: hash of the given string = " + hash);
        int index = hash % size;
        logger.log("find: bucket index = " + index);
        if (arr[index] == null) {
            logger.log("find: value is not exist");
            return -1;
        }
        if (!arr[index].contains(value)) {
            logger.log("find: value is not exist");
            return -1;
        }
        logger.log("find: value was found in bucket with index = " + index);
        return index;
    }

    public boolean delete(String value) {
        if (value == null || value.isEmpty()) {
            logger.log("delete: value is null or empty");
            return false;
        }
        int hash = hashString(value);
        logger.log("delete: hash of the given string = " + hash);
        int index = hash % size;
        logger.log("delete: bucket index = " + index);
        if (arr[index] == null) {
            logger.log("delete: value is not exist");
            return false;
        }
        if (!arr[index].contains(value)) {
            logger.log("delete: value is not exist");
            return false;
        }
        boolean res = arr[index].remove(value);
        logger.log("delete: value was " + (res ? "" : "not ") + "removed");
        return res;
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

    public void setLogger(MyLogger logger) {
        this.logger = logger;
    }
}
