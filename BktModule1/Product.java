package BktModule1;

import java.security.cert.Extension;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    public Product(int id, String name, double price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity= quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        // So sanh id ca name( khogn phan biet hoa thuong khongdung == cho strin
        Product other = (Product) obj;
        return this.getId() == other.getId() && this.getName().equalsIgnoreCase(other.getName());
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(" | Name: ").append(name)
                .append(" | Price: ").append(price)
                .append(" | Quantity: ").append(quantity);
        return sb.toString();
    }
    //fomatname
    public static String formatName(String name) {
        if (name == null) return "";

        name = name.trim();
        if (name.isEmpty()) return "";

        String[] words = name.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }
}
