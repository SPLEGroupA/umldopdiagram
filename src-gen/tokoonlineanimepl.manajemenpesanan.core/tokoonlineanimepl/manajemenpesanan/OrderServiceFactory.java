package tokoonlineanimepl.manajemenpesanan;

import tokoonlineanimepl.manajemenpesanan.core.service.OrderService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class OrderServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(OrderServiceFactory.class.getName());

    public OrderServiceFactory() {}

    public static OrderService createOrderService(String fullyQualifiedName, Object ... base) {
        OrderService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (OrderService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of OrderService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to OrderService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating OrderService.");
            System.exit(50);
        }
        return record;
    }
}
