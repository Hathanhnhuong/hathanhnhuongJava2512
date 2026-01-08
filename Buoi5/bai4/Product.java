package Buoi5.bai4;

class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    // Constructor đầy đủ tham số
    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    // Phương thức showInfo
    public void showInfo() {
        double total = price * quantity;
        System.out.println("[ID: " + id + " | Tên: " + name + " | Giá: " + price + " | SL: " + quantity + " | Tổng: " + total + "]");
    }
}
