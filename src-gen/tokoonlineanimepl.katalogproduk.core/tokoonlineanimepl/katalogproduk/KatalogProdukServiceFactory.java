package tokoonlineanimepl.katalogproduk;

import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KatalogProdukServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(KatalogProdukServiceFactory.class.getName());

    public KatalogProdukServiceFactory() {}

    public static KatalogProdukService createKatalogProdukService(String fullyQualifiedName, Object ... base) {
        KatalogProdukService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (KatalogProdukService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of KatalogProdukService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to KatalogProdukService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating KatalogProdukService.");
            System.exit(50);
        }
        return record;
    }
}
