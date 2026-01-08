package Buoi5.bài1;

public class DataCleaner {
    public static String formatName(String name) {
        if( name == null) return
        name = name.trim();
        String[] words = name.split("\\s+");
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

    public static String generateID(String name, int index) {
        String formattedName = formatName(name);
        String[] words = formattedName.split(" ");
        StringBuilder id = new StringBuilder();
        for (String word : words) {
            id.append(Character.toUpperCase(word.charAt(0)));
        }
        id.append(index);
        return id.toString();
    }

    public static void main(String[] args) {
        // Test
        String name = "ha thanh nhuong";
        System.out.println("Tên chuẩn hóa: " + formatName(name));
        System.out.println("ID: " + generateID(name, 1));
    }
}
