package Data.Tables;

import Helpers.IdHelper;
import Models.Pice;

import java.util.LinkedHashMap;

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
        return IdHelper.getNewId(piceTable);
    }
}
