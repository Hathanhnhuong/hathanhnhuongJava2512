package Buoi5.bai4;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;



public class Main {
    private static Product[] storage = new Product[100];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- MENU QUẢN LÝ KHO HÀNG ---");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách và Thống kê");
            System.out.println("3. Tìm kiếm sản phẩm rẻ nhất");
            System.out.println("4. Cập nhật thông tin sản phẩm");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. Sắp xếp theo giá giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa dòng mới

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayListAndStats();
                    break;
                case 3:
                    findAndDisplayCheapest();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    sortAndDisplay();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // Chức năng 1: Thêm sản phẩm mới
    private static void addProduct() {
        if (count >= 100) {
            System.out.println("Kho hàng đã đầy!");
            return;
        }

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        // Kiểm tra ID trùng
        for (int i = 0; i < count; i++) {
            if (storage[i].getId().equals(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        name = formatName(name); // Chuẩn hóa tên

        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();

        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Xóa dòng mới

        storage[count] = new Product(id, name, price, quantity);
        count++;
        System.out.println("Thêm sản phẩm thành công!");
    }

    // Hàm chuẩn hóa tên: Viết hoa chữ cái đầu, xóa khoảng trắng thừa
    private static String formatName(String name) {
        name = name.trim().replaceAll("\\s+", " "); // Xóa khoảng trắng thừa
        String[] words = name.split(" ");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                formatted.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return formatted.toString().trim();
    }

    // Chức năng 2: Hiển thị danh sách và Thống kê
    private static void displayListAndStats() {
        if (count == 0) {
            System.out.println("Kho hàng rỗng!");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < count; i++) {
            storage[i].showInfo();
        }

        double totalValue = calculateTotalValue();
        System.out.println("Tổng giá trị kho hàng: " + totalValue);
    }

    // Hàm tính tổng giá trị
    private static double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += storage[i].getPrice() * storage[i].getQuantity();
        }
        return total;
    }

    // Chức năng 3: Tìm kiếm sản phẩm rẻ nhất
    private static void findAndDisplayCheapest() {
        if (count == 0) {
            System.out.println("Kho hàng rỗng!");
            return;
        }

        Product cheapest = findCheapest(storage, count);
        System.out.println("Sản phẩm rẻ nhất:");
        cheapest.showInfo();
    }

    // Hàm tìm sản phẩm rẻ nhất
    private static Product findCheapest(Product[] list, int n) {
        Product min = list[0];
        for (int i = 1; i < n; i++) {
            if (list[i].getPrice() < min.getPrice()) {
                min = list[i];
            }
        }
        return min;
    }

    // Chức năng 4: Cập nhật thông tin sản phẩm
    private static void updateProduct() {
        if (count == 0) {
            System.out.println("Kho hàng rỗng!");
            return;
        }

        System.out.print("Nhập ID hoặc tên sản phẩm: ");
        String search = scanner.nextLine().trim();

        Product found = null;
        for (int i = 0; i < count; i++) {
            if (storage[i].getId().equalsIgnoreCase(search) || storage[i].getName().toLowerCase().contains(search.toLowerCase())) {
                found = storage[i];
                break;
            }
        }

        if (found == null) {
            System.out.println("Sản phẩm không tồn tại!");
            return;
        }

        System.out.println("Thông tin hiện tại:");
        found.showInfo();

        System.out.print("Nhập ID mới (enter để giữ nguyên): ");
        String newId = scanner.nextLine();
        if (!newId.isEmpty()) {
            // Kiểm tra ID mới không trùng
            for (int i = 0; i < count; i++) {
                if (storage[i].getId().equals(newId) && !storage[i].getId().equals(found.getId())) {
                    System.out.println("ID mới đã tồn tại!");
                    return;
                }
            }
            found.setId(newId);
        }

        System.out.print("Nhập tên mới (enter để giữ nguyên): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            newName = formatName(newName);
            found.setName(newName);
        }

        System.out.print("Nhập giá mới (enter để giữ nguyên): ");
        String newPriceStr = scanner.nextLine();
        if (!newPriceStr.isEmpty()) {
            double newPrice = Double.parseDouble(newPriceStr);
            found.setPrice(newPrice);
        }

        System.out.print("Nhập số lượng mới (enter để giữ nguyên): ");
        String newQuantityStr = scanner.nextLine();
        if (!newQuantityStr.isEmpty()) {
            int newQuantity = Integer.parseInt(newQuantityStr);
            found.setQuantity(newQuantity);
        }

        System.out.println("Cập nhật thành công!");
    }

    // Chức năng 5: Xóa sản phẩm
    private static void deleteProduct() {
        if (count == 0) {
            System.out.println("Kho hàng rỗng!");
            return;
        }

        System.out.print("Nhập ID cần xóa: ");
        String id = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (storage[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại!");
            return;
        }

        // Dịch chuyển mảng
        for (int i = index; i < count - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[count - 1] = null; // Xóa phần tử cuối
        count--;
        System.out.println("Xóa thành công!");
    }

    // Chức năng 6: Sắp xếp theo giá giảm dần và hiển thị
    private static void sortAndDisplay() {
        if (count == 0) {
            System.out.println("Kho hàng rỗng!");
            return;
        }

        // Tạo bản sao mảng để sắp xếp (không thay đổi mảng gốc nếu không cần)
        Product[] sorted = Arrays.copyOf(storage, count);

        // Sắp xếp theo giá giảm dần
        Arrays.sort(sorted, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getPrice(), p1.getPrice());
            }
        });

        System.out.println("Danh sách sản phẩm sắp xếp theo giá giảm dần:");
        for (Product p : sorted) {
            p.showInfo();
        }
    }
}

