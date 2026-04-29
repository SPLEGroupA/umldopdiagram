package tokoonlineanimepl.katalogproduk;

import tokoonlineanimepl.katalogproduk.core.resource.ProdukResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ProdukResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ProdukResourceFactory.class.getName());

    public ProdukResourceFactory() {}

    public static ProdukResource createProdukResource(String fullyQualifiedName, Object ... base) {
        ProdukResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ProdukResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ProdukResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ProdukResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ProdukResource.");
            System.exit(50);
        }
        return record;
    }
}
