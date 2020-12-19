package controller;

import entity.cart.Cart;
import entity.order.Order;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This class controls the flow of place rush order use case in our AIMS project
 * @author san.dl170111
 */
public class PlaceRushOrderController extends PlaceOrderController{
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());

    /**
     * Kiem tra so ngay giao hang nhanh, phai la so nguyen tu 1 den 20
     * @param rushDay: so ngay can giao hang
     * @return
     */
    public boolean validateRushDeliveryDay(String rushDay) {
        try {
            int deliveryDay = Integer.parseInt(rushDay);
            if (deliveryDay < 1 || deliveryDay > 20) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Input must be an integer");
            return  false;
        }
    }

    /**
     * Tinh gia tien khi yeu cau giao hang nhanh
     * @param order
     * @param rushDay: so ngay can cho de giao hang
     * @return
     */
    public int calculateShippingFee(Order order, String rushDay) {
        Random rand = new Random();
        int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getAmount());
        int additionalFee = (int)( ( (rand.nextFloat()*10)/100 ) * (20 - Integer.parseInt(rushDay)));
        fees += additionalFee;
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
        return fees;
    }
}
