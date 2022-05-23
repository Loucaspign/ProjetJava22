package UI.TablesModels;

import Model.ProductSearchModel;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProductSearchTableModel extends AbstractTableModel {
    private final String[] columnsName = {"Firstname", "Lastname", "Billing street", "Billing street number", "ZipCode", "Locality", "Payment deadline"};
    private ArrayList<ProductSearchModel> productSearchModels;

    public ProductSearchTableModel(ArrayList<ProductSearchModel> productSearchModels) {
        this.productSearchModels = productSearchModels;
    }

    @Override
    public int getRowCount() {
        return productSearchModels.size();
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
            case 0 -> productSearchModels.get(rowIndex).getFirstname();
            case 1 -> productSearchModels.get(rowIndex).getLastname();
            case 2 -> productSearchModels.get(rowIndex).getBillingStreet();
            case 3 -> productSearchModels.get(rowIndex).getBillingStreetNumber();
            case 4 -> productSearchModels.get(rowIndex).getZipCode();
            case 5 -> productSearchModels.get(rowIndex).getLocalityName();
            case 6 -> formatter.format(productSearchModels.get(rowIndex).getPaymentDeadline().getTime());
            default -> null;
        };
    }

}
