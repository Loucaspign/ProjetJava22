package UI.TablesModels;

import Model.CustomerSearchModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CustomerSearchTableModel extends AbstractTableModel {

    private final String[] columnsName = {"Order Id","Product", "Quantity", "Reduction", "Sell price"};
    private ArrayList<CustomerSearchModel> customerSearchModels;

    public CustomerSearchTableModel(ArrayList<CustomerSearchModel> customerSearchModels) {
        this.customerSearchModels = customerSearchModels;
    }

    @Override
    public int getRowCount() {
        return customerSearchModels.size();
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
            case 0 -> customerSearchModels.get(rowIndex).getOrderId();
            case 1 -> customerSearchModels.get(rowIndex).getProductName();
            case 2 -> customerSearchModels.get(rowIndex).getQuantity();
            case 3 -> customerSearchModels.get(rowIndex).getReduction();
            case 4 -> customerSearchModels.get(rowIndex).getSellPrice();
            default -> null;
        };
    }



}
