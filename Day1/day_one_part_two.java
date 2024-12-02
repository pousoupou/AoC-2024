import java.io.File;
import java.util.*;

public class day_one_part_two {
    public static void main(String[] args) {
        String filePath = "input.txt";

        List<Integer> group1 = new ArrayList<Integer>();
        Map<Integer, Integer> group2 = new HashMap<>();
        int listNumber = 0;
        int listSimilarity = 0;

        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                group1.add(reader.nextInt());
                listNumber = reader.nextInt();

                if(group2.containsKey(listNumber)){
                    group2.put(listNumber, group2.get(listNumber) + 1);
                }
                else {
                    group2.put(listNumber, 1);
                }
            }

            reader.close();
        } catch (Exception e) {
            throw new Error(e);
        }

        for(int i = 0; i < group1.size(); i++){
            if(group2.containsKey(group1.get(i))){
                listSimilarity += group1.get(i) * group2.get(group1.get(i));
            }
        }

        System.out.println(listSimilarity);
    }
}