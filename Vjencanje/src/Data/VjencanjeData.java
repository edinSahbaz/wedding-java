package Data;

import Data.Tables.*;

public class VjencanjeData {
    private HranaTable hranaTable;
    private PiceTable piceTable;
    private UlogaTable ulogaTable;
    private FotografTable fotografTable;
    private MaticarTable maticarTable;

    public VjencanjeData() {
        this.hranaTable = new HranaTable();
        this.piceTable = new PiceTable();
        this.ulogaTable = new UlogaTable();
        this.fotografTable = new FotografTable();
        this.maticarTable = new MaticarTable();
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

    public FotografTable getFotografTable() {
        return fotografTable;
    }

    public MaticarTable getMaticarTable() {
        return maticarTable;
    }
}
