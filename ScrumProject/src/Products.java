import java.util.ArrayList;
import java.util.Scanner;


public class Products {
    String nameProduct;
    Float price;
    String establishment;

    public Products(String nameProduct,Float price, String establishment) {
        this.establishment = establishment;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getName() {
        return nameProduct;
    }

    public void setName(String name) {
        this.nameProduct = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "establishment='" + establishment + '\'' +
                ", name='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }
}