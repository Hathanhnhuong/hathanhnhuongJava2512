package BktModule1;

public class Warehouse {
    private static final int  CATEGORY_COUNT =5;
    private static final int MAX_PRODUCT =  20;

    private Product[][] warehouse = new Product[CATEGORY_COUNT][MAX_PRODUCT];
    private int[] counts = new int[CATEGORY_COUNT];
    //add product

    public String addProduct(int categoryId, Product p){
        StringBuilder sb = new StringBuilder();
        if(counts[categoryId] == MAX_PRODUCT){
            sb.append("Danh muc da day");
            return sb.toString();
        }
        for (int i =0; i< counts[categoryId]; i++){
            if(warehouse[categoryId][i].equals(p)){
                sb.append("Sam pham da ton tai");
                return sb.toString();
            }
        }
        warehouse[categoryId][counts[categoryId]]=p;
        counts[categoryId]++;
        sb.append("Da them san pham")
                .append(p.getName())
                .append(("vao danh muc"))
                .append((categoryId));
        return sb.toString();
    }
    //tim kiem san pham
    public void searchByName(String keyword){
        boolean found = false;
        keyword = keyword.toLowerCase();
        for(int i = 0; i < CATEGORY_COUNT; i++){
            for(int j = 0; j< counts[i]; j++){
                if(warehouse[i][j].getName().toLowerCase().contains(keyword)){
                    System.out.println(warehouse[i][j]);
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println("Khong tim thay san pham");
        }
    }
    //xoa san pham
    public void deleteById(int id){
        for(int i = 0; i < CATEGORY_COUNT; i++){
            for(int j=0 ; j< counts[i]; j++){
                if(warehouse[i][j].getId()== id){
                    for(int k =j; k < counts[i]- 1; k++){
                        warehouse[i][k] = warehouse[i][k +1];
                    }
                    warehouse[i][counts[i]-1]= null;
                    counts[i]--;
                    System.out.println("Da xoa san pham ID:" + id);
                    return;
                }
            }
        }
        System.out.println("Khong tim thay san pham can xoa");
    }
    // sap xep san pham


}
