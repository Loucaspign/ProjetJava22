package Test;

import BusinessLogic.OrderBusiness;
import Model.DetailLine;
import Model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class OrderBusinessTest {

    private static OrderBusiness orderBusiness;
    @BeforeEach
    void setUp() {
        System.out.println("Setting up for test");
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<DetailLine> detailLines = new ArrayList<>();

        orders.add(new Order("TESTORDER1", new GregorianCalendar(), new GregorianCalendar(),null,new GregorianCalendar(),new GregorianCalendar(), 2, true, true, "Rue du centre", "2b", "CH2", "SH2", "LH2"));
        orders.add(new Order("TESTORDER2", new GregorianCalendar(), new GregorianCalendar(),null,new GregorianCalendar(),null, 2, true, false, null, null, "CH2", "SH2", null));
        orders.add(new Order("TESTORDER3", new GregorianCalendar(), new GregorianCalendar(),null,new GregorianCalendar(),null, 2, true, false, null, null, "CH2", "SH2", null));
        orders.add(new Order("TESTORDER4", new GregorianCalendar(), new GregorianCalendar(),null,new GregorianCalendar(),null, 2, true, false, null, null, "CH2", "SH2", null));


        detailLines.add(new DetailLine(3, 0, 10, "TESTORDER2", "VBS"));
        detailLines.add(new DetailLine(3, 1, 10, "TESTORDER3", "VBS"));
        detailLines.add(new DetailLine(3, 0, 10, "TESTORDER4", "VBS"));
        detailLines.add(new DetailLine(3, 1, 10, "TESTORDER4", "VBS"));
        detailLines.add(new DetailLine(3, 0.5, 10, "TESTORDER4", "VBS"));
        detailLines.add(new DetailLine(3, 0.25, 12, "TESTORDER4", "VBS"));

        orderBusiness = new OrderBusiness();
        orderBusiness.setOrders(orders);
        orderBusiness.setDetailLines(detailLines);

    }

    @Test
    void calculateOrder_noLines_test() {
        //Act
        double price = orderBusiness.calculateOrders("TESTORDER1");
        //Assert
        assertEquals(0, price);
    }

    @Test
    void calculateOrder_noReduction_test() {
        //Act
        double price = orderBusiness.calculateOrders("TESTORDER2");
        //Assert
        assertEquals(30, price);
    }

    @Test
    void calculateOrder_freeLine_test() {
        //Act
        double price = orderBusiness.calculateOrders("TESTORDER3");
        //Assert
        assertEquals(0, price);
    }

    @Test
    void calculateOrder_trivialCase_test() {
        //Act
        double price = orderBusiness.calculateOrders("TESTORDER4");
        //Assert
        assertEquals(72, price);
    }
}