package DataAccess;

import Model.DetailLine;
import Model.Exception.DeleteDetailLineException;

import java.util.ArrayList;

public interface DetailLineDataAccess {
    public abstract ArrayList<DetailLine> getAllDetailLine(); //Read
    public abstract void deleteDetailLine(String orderId) throws DeleteDetailLineException; //delete


}
