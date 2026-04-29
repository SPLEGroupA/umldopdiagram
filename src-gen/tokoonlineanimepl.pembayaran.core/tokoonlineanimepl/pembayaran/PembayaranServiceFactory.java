package tokoonlineanimepl.pembayaran;

import tokoonlineanimepl.pembayaran.core.service.PembayaranService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PembayaranServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(PembayaranServiceFactory.class.getName());

    public PembayaranServiceFactory() {}

    public static PembayaranService createPembayaranService(String fullyQualifiedName, Object ... base) {
        PembayaranService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (PembayaranService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of PembayaranService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to PembayaranService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating PembayaranService.");
            System.exit(50);
        }
        return record;
    }
}
