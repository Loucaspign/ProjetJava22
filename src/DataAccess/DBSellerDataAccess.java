package DataAccess;

import Model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DBSellerDataAccess implements SellerDataAccess {
    public ArrayList<Seller> getAllSeller() {
        ArrayList<Seller> sellerList = new ArrayList<Seller>();

        try{
            Connection connection = SingletonConnection.getInstance();

            String query = ("select * from seller");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);

            while (data.next()){
                String sellerId = data.getString(1);
                String firstname = data.getString(2);
                String lastname = data.getString(3);
                GregorianCalendar hireDate = new GregorianCalendar();
                hireDate.setTime(data.getDate(4));
                sellerList.add(new Seller(sellerId, firstname, lastname, hireDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sellerList;
    }
}
