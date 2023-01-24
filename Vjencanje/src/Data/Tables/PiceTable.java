package Data.Tables;

import Models.Hrana;
import Models.Pice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PiceTable {
    private LinkedHashMap<Integer, Pice> piceTable;

    public PiceTable() {
        this.piceTable = new LinkedHashMap<>();
    }

    public void insert (Pice newData) {
        piceTable.put(newData.getId(), newData);
    }

    public void update (int id, Pice newData) {
        piceTable.put(id, newData);
    }

    public void delete (int id) {
        piceTable.remove(id);
    }

    public LinkedHashMap<Integer, Pice> selectAll () {
        return piceTable;
    }

    public Pice selectById (int id) {
        return piceTable.get(id);
    }

    public int getNewId() {
        int size = piceTable.size();

        // Mimics IDENTITY from MSSQL
        if(size == 0) {
            return 1;
        } else {
            List<Integer> keys = new ArrayList<>(piceTable.keySet());
            int id = keys.get(keys.size() - 1) + 1;
            return id;
        }

    }
}
