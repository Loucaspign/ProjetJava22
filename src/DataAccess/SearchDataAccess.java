package DataAccess;

import Model.CustomerSearchModel;
import Model.DatesSearchModel;
import Model.Exception.SearchByCustomerException;
import Model.Exception.SearchByDatesException;
import Model.Exception.SearchByLocalityException;
import Model.Exception.SearchByProductException;
import Model.LocalitySearchModel;
import Model.ProductSearchModel;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface SearchDataAccess {
    public abstract ArrayList<LocalitySearchModel> searchByLocality(String localityId) throws SearchByLocalityException;
    public abstract ArrayList<DatesSearchModel> searchByDates(GregorianCalendar date1, GregorianCalendar date2) throws SearchByDatesException;
    public abstract ArrayList<ProductSearchModel> searchByProduct(String code) throws SearchByProductException;
    public abstract ArrayList<CustomerSearchModel> searchByCustomer(String customerId) throws SearchByCustomerException;






}
