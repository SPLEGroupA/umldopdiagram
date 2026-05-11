package tokoonlineanimepl.orderitem;

import tokoonlineanimepl.orderitem.core.service.OrderItemService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class OrderItemServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(OrderItemServiceFactory.class.getName());

    public OrderItemServiceFactory() {}

    public static OrderItemService createOrderItemService(String fullyQualifiedName, Object ... base) {
        OrderItemService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (OrderItemService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of OrderItemService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to OrderItemService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating OrderItemService.");
            System.exit(50);
        }
        return record;
    }
}
