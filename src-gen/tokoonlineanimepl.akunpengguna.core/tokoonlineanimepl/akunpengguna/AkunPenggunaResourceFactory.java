package tokoonlineanimepl.akunpengguna;

import tokoonlineanimepl.akunpengguna.core.resource.AkunPenggunaResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class AkunPenggunaResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(AkunPenggunaResourceFactory.class.getName());

    public AkunPenggunaResourceFactory() {}

    public static AkunPenggunaResource createAkunPenggunaResource(String fullyQualifiedName, Object ... base) {
        AkunPenggunaResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (AkunPenggunaResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of AkunPenggunaResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to AkunPenggunaResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating AkunPenggunaResource.");
            System.exit(50);
        }
        return record;
    }
}
