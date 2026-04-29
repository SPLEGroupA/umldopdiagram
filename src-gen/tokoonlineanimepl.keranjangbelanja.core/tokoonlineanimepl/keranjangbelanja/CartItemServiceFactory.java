package tokoonlineanimepl.keranjangbelanja;

import tokoonlineanimepl.keranjangbelanja.core.service.CartItemService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class CartItemServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(CartItemServiceFactory.class.getName());

    public CartItemServiceFactory() {}

    public static CartItemService createCartItemService(String fullyQualifiedName, Object ... base) {
        CartItemService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (CartItemService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CartItemService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to CartItemService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating CartItemService.");
            System.exit(50);
        }
        return record;
    }
}
