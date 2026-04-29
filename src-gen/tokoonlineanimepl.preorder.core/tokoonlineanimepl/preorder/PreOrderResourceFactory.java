package tokoonlineanimepl.preorder;

import tokoonlineanimepl.preorder.core.resource.PreOrderResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PreOrderResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(PreOrderResourceFactory.class.getName());

    public PreOrderResourceFactory() {}

    public static PreOrderResource createPreOrderResource(String fullyQualifiedName, Object ... base) {
        PreOrderResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PreOrderResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PreOrderResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PreOrderResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PreOrderResource.");
            System.exit(50);
        }
        return record;
    }
}
