package Data.Tables;

import Helpers.IdHelper;
import Models.Maticar;

import java.util.LinkedHashMap;

public class MaticarTable {
    private LinkedHashMap<Integer, Maticar> maticarTable;

    public MaticarTable() {
        this.maticarTable = new LinkedHashMap<>();
    }

    public void insert (Maticar newData) {
        maticarTable.put(newData.getId(), newData);
    }

    public void update (int id, Maticar newData) {
        maticarTable.put(id, newData);
    }

    public void delete (int id) {
        maticarTable.remove(id);
    }

    public LinkedHashMap<Integer, Maticar> selectAll () {
        return maticarTable;
    }

    public Maticar selectById (int id) {
        return maticarTable.get(id);
    }

    public int getNewId() {
        return IdHelper.getNewId(maticarTable);
    }
}
