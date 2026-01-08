package Buoi5.bài2;

import Buoi5.bài1.DataCleaner;

class Product {
    String id;
    String name;
    double price;
    int quantity;
    public Product(String id, String name, double price, int quntity){
        this.id = id;
        this.name = DataCleaner.formatName(name);
        this.price= price;
        this.quantity = quantity;
    }
}