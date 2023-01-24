package Data;

import Data.Tables.HranaTable;
import Data.Tables.PiceTable;
import Data.Tables.UlogaTable;

public class VjencanjeData {
    private HranaTable hranaTable;
    private PiceTable piceTable;
    private UlogaTable ulogaTable;

    public VjencanjeData() {
        this.hranaTable = new HranaTable();
        this.piceTable = new PiceTable();
        this.ulogaTable = new UlogaTable();
    }

    public HranaTable getHranaTable() {
        return hranaTable;
    }

    public PiceTable getPiceTable() {
        return piceTable;
    }

    public UlogaTable getUlogaTable() {
        return ulogaTable;
    }
}
