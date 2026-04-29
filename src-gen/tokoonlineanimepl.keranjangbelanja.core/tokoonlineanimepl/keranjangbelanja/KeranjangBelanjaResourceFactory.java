package tokoonlineanimepl.keranjangbelanja;

import tokoonlineanimepl.keranjangbelanja.core.resource.KeranjangBelanjaResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KeranjangBelanjaResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(KeranjangBelanjaResourceFactory.class.getName());

    public KeranjangBelanjaResourceFactory() {}

    public static KeranjangBelanjaResource createKeranjangBelanjaResource(String fullyQualifiedName, Object ... base) {
        KeranjangBelanjaResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (KeranjangBelanjaResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of KeranjangBelanjaResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to KeranjangBelanjaResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating KeranjangBelanjaResource.");
            System.exit(50);
        }
        return record;
    }
}
