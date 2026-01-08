package Buoi5.bài2;

import Buoi5.bài1.DataCleaner;


public class QL {
    public static Product findCheapest(Product[] list){
        if (list == null || list.length == 0) return null;
        Product cheapest = list[0];
        for(Product p : list){
            if( p != null && p.price < cheapest.price){
                cheapest = p;
            }
        }
        return cheapest;
    }
    public static double calculateTotalValue(Product[] list){
        double total = 0;
        for(Product p : list){
            if( p !=null){
                total += p.price * p.quantity;
            }
        }
        return total;
    }
    public static void main( String[] args){
        Product [] products = new Product[ 100 ];
        products[0] = new Product("A1", " tivi ", 5000, 2);
        products[1] = new Product("A2", " chuot ", 200, 10);

        System.out.println("Tên chuẩn hóa SP1: " + products[0].name);
        System.out.println("Tên chuẩn hóa SP2: " + products[1].name);

        Product cheapest = findCheapest(products);
        System.out.println("Sản phẩm rẻ nhất: " + cheapest.name + " (" + cheapest.price + ")");

        double totalValue = calculateTotalValue(products);
        System.out.println("Tổng giá trị kho: " + totalValue);
    }
}
