package tokoonlineanimepl.manajemenpesanan;

import tokoonlineanimepl.manajemenpesanan.core.resource.OrderItemResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class OrderItemResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(OrderItemResourceFactory.class.getName());

    public OrderItemResourceFactory() {}

    public static OrderItemResource createOrderItemResource(String fullyQualifiedName, Object ... base) {
        OrderItemResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (OrderItemResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of OrderItemResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to OrderItemResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating OrderItemResource.");
            System.exit(50);
        }
        return record;
    }
}
