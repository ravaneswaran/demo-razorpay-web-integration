package rc.demo.app.models.session;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<String> productIds;

    public Cart(){
        this.productIds = new ArrayList<>();
    }

    public void addProductId(String id){
        if(!this.productIds.contains(id)) {
            this.productIds.add(id);
        }
    }

    public void removeProductId(String id){
        this.productIds.remove(id);
    }

    public List<String> getProductIds() {
        return this.productIds;
    }
}
