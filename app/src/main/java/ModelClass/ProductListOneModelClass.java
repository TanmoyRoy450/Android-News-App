package ModelClass;

/**
 * Created by wolfsoft5 on 29/5/18.
 */

public class ProductListOneModelClass {

    String title,price;

    public ProductListOneModelClass(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
