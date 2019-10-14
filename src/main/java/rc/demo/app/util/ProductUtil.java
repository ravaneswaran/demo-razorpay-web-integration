package rc.demo.app.util;

import rc.demo.app.models.Product;
import rc.demo.app.service.local.ProductLocalService;

import java.util.logging.Logger;

public class ProductUtil {

    private static final Logger LOGGER = Logger.getLogger(ProductUtil.class.getName());

    public static final void registerProduct(String id, int rowId, String name, long price, String displayPrice, String performance, String display, String storage, String camera, String battery, String ram, String launchDate, String imageLocation){
        Product product = new Product();

        product.setId(id);
        product.setRowId(rowId);
        product.setName(name);
        product.setPrice(price);
        product.setFormattedPrice(displayPrice);
        product.setPerformance(performance);
        product.setDisplay(display);
        product.setStorage(storage);
        product.setCamera(camera);
        product.setBattery(battery);
        product.setRam(ram);
        product.setLaunchDate(launchDate);
        product.setImageLocation(imageLocation);

        ProductLocalService.registerProduct(product);
    }

    public static final void deRegisterProductById(String id){
        try {
            ProductLocalService.deRegisterProductUsingId(id);
        } catch(IllegalArgumentException iae){
            LOGGER.severe(iae.getMessage());
        }
    }
}
