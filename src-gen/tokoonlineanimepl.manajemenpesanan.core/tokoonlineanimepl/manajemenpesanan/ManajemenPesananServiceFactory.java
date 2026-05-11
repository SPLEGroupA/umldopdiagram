package tokoonlineanimepl.manajemenpesanan;

import tokoonlineanimepl.manajemenpesanan.core.service.ManajemenPesananService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ManajemenPesananServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ManajemenPesananServiceFactory.class.getName());

    public ManajemenPesananServiceFactory() {}

    public static ManajemenPesananService createManajemenPesananService(String fullyQualifiedName, Object ... base) {
        ManajemenPesananService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ManajemenPesananService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ManajemenPesananService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ManajemenPesananService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ManajemenPesananService.");
            System.exit(50);
        }
        return record;
    }
}
