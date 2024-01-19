import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Shraddha",11);
        map.put("Ghanshyam",20);
        map.put("Khemlata",12);
        map.put("Shraddha",11);
        System.out.println(map);

        System.out.println(map.get("Shraddha"));
        System.out.println(map.containsKey("Subhash"));
        System.out.println(map.entrySet());
        

    }
}