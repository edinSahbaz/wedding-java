package Data.Tables;

import Helpers.IdHelper;
import Models.Fotograf;

import java.util.LinkedHashMap;

public class MaticarTable {
    private LinkedHashMap<Integer, Fotograf> fotografTable;

    public MaticarTable() {
        this.fotografTable = new LinkedHashMap<>();
    }

    public void insert (Fotograf newData) {
        fotografTable.put(newData.getId(), newData);
    }

    public void update (int id, Fotograf newData) {
        fotografTable.put(id, newData);
    }

    public void delete (int id) {
        fotografTable.remove(id);
    }

    public LinkedHashMap<Integer, Fotograf> selectAll () {
        return fotografTable;
    }

    public Fotograf selectById (int id) {
        return fotografTable.get(id);
    }

    public int getNewId() {
        return IdHelper.getNewId(fotografTable);
    }
}
