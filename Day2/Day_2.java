import java.io.File;
import java.util.Scanner;

public class Day_2 {
    public static void main(String[] args) {
        String filePath = "input.txt";

        String report = "";
        int diff = 0;
        Boolean safe = null;
        Boolean ascending = null;
        int safeReports = 0;

        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                safe = true;
                report = reader.nextLine();
                String levels[] = report.split(" ");
    
                diff = Integer.valueOf(levels[0]) - Integer.valueOf(levels[1]);
                if(diff > 0){
                    ascending = false;
                }
                else if (diff < 0){
                    ascending = true;
                }
                else {
                    continue;
                }
                
                for(int i = 1; i < levels.length; i++){
                    diff = Integer.valueOf(levels[i-1]) - Integer.valueOf(levels[i]);
                         
                    if(!ascending && (diff >= 1 && diff <= 3)){
                        continue;
                    }
                    else if(ascending && (diff <= -1 && diff >= -3)){
                        continue;
                    }
                    else {
                        safe = false;
                        break;
                    }
                }

                if(safe){
                    safeReports++;
                }
            }

            reader.close();
        } catch (Exception e) {
            throw new Error(e);
        }

        System.out.println(safeReports);
    }
}
