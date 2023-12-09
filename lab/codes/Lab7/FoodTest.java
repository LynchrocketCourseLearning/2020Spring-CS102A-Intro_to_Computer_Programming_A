import java.util.ArrayList;

public class FoodTest {
    public static void main(String[] args) {
        ArrayList<Food> a = new ArrayList<>();

        a.add(new Food());
        a.get(0).setType("Seafood");
        a.get(0).setId(1);
        a.get(0).setName("pizza");
        a.get(0).setSize(11);
        a.get(0).setPrice(12.00);


        a.add(new Food());
        a.get(1).setType("Beef");
        a.get(1).setId(2);
        a.get(1).setName("pizza");
        a.get(1).setSize(9);
        a.get(1).setPrice(10.00);

        a.add(new Food());
        a.get(2).setType("Seafood");
        a.get(2).setId(3);
        a.get(2).setName("fried rice");
        a.get(2).setSize(5);
        a.get(2).setPrice(12.00);

        a.add(new Food());
        a.get(3).setType("Beef");
        a.get(3).setId(4);
        a.get(3).setName("noodles");
        a.get(3).setSize(6);
        a.get(3).setPrice(14.00);


        System.out.println("--------------------welcome, this is Start of the Menu-------------------");
        for(int i = 0; i < 4; i++){
            a.get(i).showInformation();
        }
        System.out.println("--------------------welcome, this is End of the Menu-------------------");
    }
}
