package Helpers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class IdHelper {
    public static int getNewId(LinkedHashMap linkedHashMap) {
        int size = linkedHashMap.size();

        // Mimics IDENTITY from MSSQL
        if(size == 0) {
            return 1;
        } else {
            List<Integer> keys = new ArrayList<>(linkedHashMap.keySet());
            int id = keys.get(keys.size() - 1) + 1;
            return id;
        }
    }
}
