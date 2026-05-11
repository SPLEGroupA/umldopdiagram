package tokoonlineanimepl.cartitem;

import tokoonlineanimepl.cartitem.core.resource.CartItemResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CartItemResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(CartItemResourceFactory.class.getName());

    public CartItemResourceFactory() {}

    public static CartItemResource createCartItemResource(String fullyQualifiedName, Object ... base) {
        CartItemResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (CartItemResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CartItemResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to CartItemResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating CartItemResource.");
            System.exit(50);
        }
        return record;
    }
}
