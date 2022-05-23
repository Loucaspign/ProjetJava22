package DataAccess;

import Model.DetailLine;
import Model.Exception.DeleteDetailLineException;

import java.sql.*;
import java.util.ArrayList;

public class DBDetailLineDataAccess implements DetailLineDataAccess {

    public ArrayList<DetailLine> getAllDetailLine() {
        ArrayList<DetailLine> detailLines = new ArrayList<DetailLine>();

        try {
            Connection connection = SingletonConnection.getInstance();

            String query = ("select * from detail_line");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);

            while (data.next()){
                String orderId = data.getString(1);
                String productId = data.getString(2);
                double reduction = data.getDouble(3);
                double sellPrice = data.getDouble(4);
                int quantity = data.getInt(5);
                detailLines.add(new DetailLine(quantity, reduction, sellPrice, orderId, productId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return detailLines;
    }

    public void deleteDetailLine(String orderId) throws DeleteDetailLineException {
        try{
            Connection connection = SingletonConnection.getInstance();
            String query = ("delete from `detail_line` where order_fk=?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, orderId);

            statement.executeUpdate();
        }
        catch (SQLException throwables) {
            throw new DeleteDetailLineException();
        }
    }

}
