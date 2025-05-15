package models;


public class Product {
    String nameProduct;
    float price;
    String establishment;

    public Product(String nameProduct, float price, String establishment) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "models.Products{" +
                "establishment='" + establishment + '\'' +
                ", name='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }
}