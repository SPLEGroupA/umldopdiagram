package tokoonlineanimepl.pembayaran;

import tokoonlineanimepl.pembayaran.core.resource.PembayaranResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PembayaranResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(PembayaranResourceFactory.class.getName());

    public PembayaranResourceFactory() {}

    public static PembayaranResource createPembayaranResource(String fullyQualifiedName, Object ... base) {
        PembayaranResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PembayaranResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PembayaranResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PembayaranResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PembayaranResource.");
            System.exit(50);
        }
        return record;
    }
}
