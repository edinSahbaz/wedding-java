package Data.Tables;

import Helpers.IdHelper;
import Models.Hrana;

import java.util.LinkedHashMap;

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
        return IdHelper.getNewId(hranaTable);
    }
}
