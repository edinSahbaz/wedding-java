package Data;

import Data.Tables.HranaTable;
import Models.Hrana;

import java.util.ArrayList;

public class VjencanjeData {
    private HranaTable hranaTable;

    public VjencanjeData() {
        this.hranaTable = new HranaTable();
    }

    public HranaTable getHranaTable() {
        return hranaTable;
    }
}
