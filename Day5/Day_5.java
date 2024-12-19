import java.io.File;
import java.util.*;

public class Day_5 {
    public static void main(String[] args) {
        String filePath = "input.txt";

        String line = "";
        String rule[];
        int page = 0;
        Map<Integer, ArrayList<Integer>> rules = new HashMap<>();
        String update[];
        Boolean valid = false;
        int v_sum = 0;
        int i_sum = 0;

        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                line = reader.nextLine();
                if(line.equals("")){
                    break;
                }

                rule = line.split("\\|");
                page = Integer.parseInt(rule[0]);

                if(rules.containsKey(page)){
                    rules.get(page).add(Integer.parseInt(rule[1]));
                }
                else {
                    rules.put(page, new ArrayList<Integer>());
                    rules.get(page).add(Integer.parseInt(rule[1]));
                }
            }

            while(reader.hasNextLine()){
                line = reader.nextLine();
                valid = true;

                update = line.split(",");

                for(int i = 0; i < update.length-1; i++){
                    if(!rules.containsKey(Integer.parseInt(update[i]))){
                        valid = false;
                        break;
                    }
                    else if(!rules.get(Integer.parseInt(update[i])).contains(Integer.parseInt(update[i+1]))){
                        valid = false;
                        break;
                    }
                }

                if(valid){
                    v_sum += Integer.parseInt(update[update.length/2]);
                }
                else {
                    for(int i = 0; i < update.length-1; i++){
                        if(!rules.containsKey(Integer.parseInt(update[i])) ||
                        !rules.get(Integer.parseInt(update[i])).contains(Integer.parseInt(update[i+1]))){
                            String temp = update[i];
                            update[i] = update[i+1];
                            update[i+1] = temp;

                            i = -1;
                        }
                    }

                    i_sum += Integer.parseInt(update[update.length/2]);
                }
            }
            reader.close();

            System.out.println(v_sum + " " + i_sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
