package tokoonlineanimepl.preorder;

import tokoonlineanimepl.preorder.core.service.PreOrderService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PreOrderServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(PreOrderServiceFactory.class.getName());

    public PreOrderServiceFactory() {}

    public static PreOrderService createPreOrderService(String fullyQualifiedName, Object ... base) {
        PreOrderService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PreOrderService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PreOrderService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PreOrderService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PreOrderService.");
            System.exit(50);
        }
        return record;
    }
}
