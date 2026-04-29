package tokoonlineanimepl.keranjangbelanja;

import tokoonlineanimepl.keranjangbelanja.core.service.KeranjangBelanjaService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KeranjangBelanjaServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(KeranjangBelanjaServiceFactory.class.getName());

    public KeranjangBelanjaServiceFactory() {}

    public static KeranjangBelanjaService createKeranjangBelanjaService(String fullyQualifiedName, Object ... base) {
        KeranjangBelanjaService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (KeranjangBelanjaService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of KeranjangBelanjaService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to KeranjangBelanjaService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating KeranjangBelanjaService.");
            System.exit(50);
        }
        return record;
    }
}
