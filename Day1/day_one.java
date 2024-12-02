import java.io.File;
import java.util.*;

public class day_one{
    public static void main(String[] args){
        String filePath = "input.txt";
        
        List<Integer> group1 = new ArrayList<Integer>();
        List<Integer> group2 = new ArrayList<Integer>();
        int distance = 0;
        
        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                group1.add(reader.nextInt());
                group2.add(reader.nextInt());

                group1.sort(null);
                group2.sort(null);
            }
        } catch (Exception e) {
            throw new Error(e);
        }

        for(int i = 0; i < group1.size(); i++){
            distance += Math.abs(group1.get(i) - group2.get(i));
        }

        System.out.println(distance);
    }
}