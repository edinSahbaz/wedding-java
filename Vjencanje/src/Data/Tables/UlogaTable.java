package Data.Tables;

import Helpers.IdHelper;
import Models.Uloga;

import java.util.LinkedHashMap;

public class UlogaTable {
    private LinkedHashMap<Integer, Uloga> ulogaTable;

    public UlogaTable() {
        this.ulogaTable = new LinkedHashMap<>();
    }

    public void insert (Uloga newData) {
        ulogaTable.put(newData.getId(), newData);
    }

    public void update (int id, Uloga newData) {
        ulogaTable.put(id, newData);
    }

    public void delete (int id) {
        ulogaTable.remove(id);
    }

    public LinkedHashMap<Integer, Uloga> selectAll () {
        return ulogaTable;
    }

    public Uloga selectById (int id) {
        return ulogaTable.get(id);
    }

    public int getNewId() {
        return IdHelper.getNewId(ulogaTable);
    }
}
