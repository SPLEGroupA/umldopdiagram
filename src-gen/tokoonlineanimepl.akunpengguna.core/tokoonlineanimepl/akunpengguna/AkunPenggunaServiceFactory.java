package tokoonlineanimepl.akunpengguna;

import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class AkunPenggunaServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(AkunPenggunaServiceFactory.class.getName());

    public AkunPenggunaServiceFactory() {}

    public static AkunPenggunaService createAkunPenggunaService(String fullyQualifiedName, Object ... base) {
        AkunPenggunaService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (AkunPenggunaService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of AkunPenggunaService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to AkunPenggunaService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating AkunPenggunaService.");
            System.exit(50);
        }
        return record;
    }
}
