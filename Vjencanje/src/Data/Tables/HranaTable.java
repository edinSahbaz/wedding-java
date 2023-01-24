package Data.Tables;

import Models.Hrana;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HranaTable {
    private LinkedHashMap<Integer, Hrana> hranaTable;

    public HranaTable() {
        this.hranaTable = new LinkedHashMap<>();
    }

    public void insert (Hrana newData) {
        hranaTable.put(newData.getId(), newData);
    }

    public void update (int id, Hrana newData) {
        hranaTable.put(id, newData);
    }

    public void delete (int id) {
        hranaTable.remove(id);
    }

    public LinkedHashMap<Integer, Hrana> selectAll () {
        return hranaTable;
    }

    public Hrana selectById (int id) {
        return hranaTable.get(id);
    }

    public int getNewId() {
        int size = hranaTable.size();

        // Mimics IDENTITY from MSSQL
        if(size == 0) {
            return 1;
        } else {
            List<Integer> keys = new ArrayList<>(hranaTable.keySet());
            int id = keys.get(keys.size() - 1) + 1;
            return id;
        }

    }
}
