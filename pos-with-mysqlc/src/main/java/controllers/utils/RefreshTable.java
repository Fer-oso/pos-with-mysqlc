package controllers.utils;

import javax.swing.table.DefaultTableModel;

public class RefreshTable {

    private RefreshTable() {
    }

    public static void refreshTable(DefaultTableModel table) {

        for (int i = 0; i < table.getRowCount(); i++) {

            table.removeRow(i);

            i = i - 1;
        }
    }
}
