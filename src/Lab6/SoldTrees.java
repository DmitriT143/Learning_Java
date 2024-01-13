package Lab6;
import java.util.*;

public class SoldTrees {
    static TreeMap<String,Integer> inOut = new TreeMap<>();
    static ArrayList<Integer>priceTag = new ArrayList<>();
    public static void main(String[] args){
        inOut.put("Bonsai",12);
        priceTag.add(100);
        inOut.put("Maple",100);
        priceTag.add(25);
        inOut.put("Pine",25);
        priceTag.add(50);
        inOut.put("Oak",42);
        priceTag.add(75);
        addToSales("Bonsai",5);
        MostSold(inOut);
        PrintAllPos(inOut);
    }
    public static void MostSold(Map<String,Integer> map){
        ArrayList<Map.Entry<String,Integer>> allPos = new ArrayList<>(map.entrySet());
        allPos.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue())
                    return 1;
                else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else return -1;
            }
        });
        System.out.println("Most sold :: " + allPos.get(allPos.size()-1).getKey());
    }
    public static void PrintAllPos(Map<String,Integer> map){
        List<Object> allKeys = List.of(map.keySet().toArray());
        Integer price = 0;
        for (Object allKey : allKeys) {
            System.out.println(allKey.toString() + " :: "+ map.get(allKey));
        }
        for (int i = 0; i < allKeys.size()-1 && i < priceTag.size() - 1; i++) {
            Integer pricePerItem;
            if(priceTag.get(i)!=null) {
                price = price + (map.get(allKeys.get(i)) * priceTag.get(i));
            }else {
                price = price + map.get(allKeys.get(i)) * 10;
            }
        }
        System.out.println("Price of sold objects :: " + price);
    }
    public static void addToSales(String Tree, Integer Amount){
        if(inOut.get(Tree) != null){inOut.put(Tree,(inOut.get(Tree)+Amount));}
        else inOut.put(Tree,Amount);
    }
}
