package DataAccess;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBProductDataAccess implements ProductDataAccess {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> products = new ArrayList<Product>();

        try{
            Connection connection = SingletonConnection.getInstance();


            String query = ("select * from product");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);

            while (data.next()){
                String code = data.getString(1);
                String name = data.getString(2);
                double price = data.getDouble(3);
                double VAT = data.getDouble(4);
                products.add(new Product(code, name, price, VAT));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }





}
