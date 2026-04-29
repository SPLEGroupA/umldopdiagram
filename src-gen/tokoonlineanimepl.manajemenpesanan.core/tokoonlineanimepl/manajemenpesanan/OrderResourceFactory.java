package tokoonlineanimepl.manajemenpesanan;

import tokoonlineanimepl.manajemenpesanan.core.resource.OrderResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class OrderResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(OrderResourceFactory.class.getName());

    public OrderResourceFactory() {}

    public static OrderResource createOrderResource(String fullyQualifiedName, Object ... base) {
        OrderResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (OrderResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of OrderResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to OrderResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating OrderResource.");
            System.exit(50);
        }
        return record;
    }
}
