package tokoonlineanimepl.katalogproduk;

import tokoonlineanimepl.katalogproduk.core.service.ProdukService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ProdukServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ProdukServiceFactory.class.getName());

    public ProdukServiceFactory() {}

    public static ProdukService createProdukService(String fullyQualifiedName, Object ... base) {
        ProdukService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ProdukService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ProdukService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ProdukService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ProdukService.");
            System.exit(50);
        }
        return record;
    }
}
