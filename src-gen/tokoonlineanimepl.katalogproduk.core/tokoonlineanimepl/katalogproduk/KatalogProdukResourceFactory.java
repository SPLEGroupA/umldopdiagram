package tokoonlineanimepl.katalogproduk;

import tokoonlineanimepl.katalogproduk.core.resource.KatalogProdukResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KatalogProdukResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(KatalogProdukResourceFactory.class.getName());

    public KatalogProdukResourceFactory() {}

    public static KatalogProdukResource createKatalogProdukResource(String fullyQualifiedName, Object ... base) {
        KatalogProdukResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (KatalogProdukResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of KatalogProdukResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to KatalogProdukResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating KatalogProdukResource.");
            System.exit(50);
        }
        return record;
    }
}
