package UI.TablesModels;

import Model.DatesSearchModel;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DatesSearchTableModel extends AbstractTableModel {
    private final String[] columnsName = {"OrderID","Order date", "Quantity", "Sell price","Name"};
    private ArrayList<DatesSearchModel> datesSearchModels;

    public DatesSearchTableModel(ArrayList<DatesSearchModel> datesSearchModels) {
        this.datesSearchModels = datesSearchModels;
    }

    @Override
    public int getRowCount() {
        return datesSearchModels.size();
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return switch (columnIndex){
            case 0 -> datesSearchModels.get(rowIndex).getOrderId();
            case 1 -> formatter.format(datesSearchModels.get(rowIndex).getOrderDate().getTime());
            case 2 -> datesSearchModels.get(rowIndex).getQuantity();
            case 3 -> datesSearchModels.get(rowIndex).getSellPrice();
            case 4 -> datesSearchModels.get(rowIndex).getProductName();
            default -> null;
        };
    }
}