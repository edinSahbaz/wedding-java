package Data;

import Data.Tables.HranaTable;
import Data.Tables.PiceTable;
import Models.Hrana;

import java.util.ArrayList;

public class VjencanjeData {
    private HranaTable hranaTable;
    private PiceTable piceTable;

    public VjencanjeData() {
        this.hranaTable = new HranaTable();
        this.piceTable = new PiceTable();
    }

    public HranaTable getHranaTable() {
        return hranaTable;
    }

    public PiceTable getPiceTable() {
        return piceTable;
    }
}
