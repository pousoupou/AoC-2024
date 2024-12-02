import java.io.File;
import java.util.*;

public class Day_1{
    public static void main(String[] args){
        String filePath = "input.txt";
        
        List<Integer> group1 = new ArrayList<Integer>();
        List<Integer> group2 = new ArrayList<Integer>();
        int distance = 0;

        Map<Integer, Integer> _group2 = new HashMap<>();
        int listNumber = 0;
        int listSimilarity = 0;
        
        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                group1.add(reader.nextInt());
                listNumber = reader.nextInt();
                group2.add(listNumber);

                group1.sort(null);
                group2.sort(null);


                if(_group2.containsKey(listNumber)){
                    _group2.put(listNumber, _group2.get(listNumber) + 1);
                }
                else {
                    _group2.put(listNumber, 1);
                }
            }

            reader.close();
        } catch (Exception e) {
            throw new Error(e);
        }

        for(int i = 0; i < group1.size(); i++){
            distance += Math.abs(group1.get(i) - group2.get(i));
        }

        for(int i = 0; i < group1.size(); i++){
            if(_group2.containsKey(group1.get(i))){
                listSimilarity += group1.get(i) * _group2.get(group1.get(i));
            }
        }

        System.out.println(distance + "\t" + listSimilarity);
    }
}