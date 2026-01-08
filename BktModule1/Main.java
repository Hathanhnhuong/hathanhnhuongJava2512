package BktModule1;

public class Main {
    public static void main(String[] args) {
        Warehouse wh = new Warehouse();

        System.out.println(
                wh.addProduct(0, new Product(1, " iphone 15 ", 25000000, 10))
        );
        System.out.println(
                wh.addProduct(0, new Product(2, "TV", 15000000, 5))
        );
        System.out.println(
                wh.addProduct(1, new Product(3, "laptop", 30000000, 3))
        );

        System.out.println("\n=== TÌM KIẾM ===");
        wh.searchByName("iphone");

        System.out.println("\n=== XÓA ===");
        wh.deleteById(2);

    }
}
