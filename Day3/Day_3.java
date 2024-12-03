import java.io.File;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day_3 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";

        List<String> multiplications = new ArrayList<>();
        int sum = 0;
        
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        
        try {
            Scanner reader = new Scanner(new File(filePath));
            Scanner purifier;
            
            Stream<MatchResult> matches = reader.findAll(pattern);
            
            matches.forEach(match -> multiplications.add(match.group()));
            
            for(String mult : multiplications){
                mult = mult.replace("mul(", "").replace(",", " ").replace(")", "");
                purifier = new Scanner(mult);
                sum += purifier.nextInt() * purifier.nextInt();
                
                purifier.close();
            }

            reader.close();
        } catch (Exception e) {
            throw new Error(e);
        }

        System.out.println(sum);
    }
}
