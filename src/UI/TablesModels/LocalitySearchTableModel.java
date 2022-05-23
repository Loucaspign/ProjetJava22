package UI.TablesModels;

import Model.LocalitySearchModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class LocalitySearchTableModel extends AbstractTableModel {
    private final String[] columnsName = {"Order ID", "Customer firstname", "Customer lastname", "Seller firstname", "Seller lastname"};
    private ArrayList<LocalitySearchModel> localitySearchModels;

    public LocalitySearchTableModel(ArrayList<LocalitySearchModel> localitySearchModels) {
        this.localitySearchModels = localitySearchModels;
    }

    @Override
    public int getRowCount() {
        return localitySearchModels.size();
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex){
            case 0 -> localitySearchModels.get(rowIndex).getOrderId();
            case 1 -> localitySearchModels.get(rowIndex).getCustomerFirstname();
            case 2 -> localitySearchModels.get(rowIndex).getCustomerLastname();
            case 3 -> localitySearchModels.get(rowIndex).getSellerFirstname();
            case 4 -> localitySearchModels.get(rowIndex).getSellerLastname();
            default -> null;
        };
    }
}
