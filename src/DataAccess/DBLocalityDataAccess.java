package DataAccess;

import Model.Locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBLocalityDataAccess implements LocalityDataAccess {
    public ArrayList<Locality> getAllLocality() {
        ArrayList<Locality> localityList = new ArrayList<Locality>();

        try{
            Connection connection = SingletonConnection.getInstance();
            String query = ("select * from locality");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);

            while (data.next()){
                String localityId = data.getString(1);
                int zipCode = data.getInt(2);
                String name = data.getString(3);
                localityList.add(new Locality(localityId, zipCode, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return localityList;
    }

}
