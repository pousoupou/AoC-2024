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
        String switchRegex = "(do\\(\\))|(don't\\(\\))|mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        String line = "";
        Boolean enabled = true;

        List<String> multiplications = new ArrayList<>();
        int sum = 0;
        
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Pattern switchPattern = Pattern.compile(switchRegex, Pattern.MULTILINE);

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
            
            /**
             * SECOND PART
             * HOLLY FUCKING SHIT THIS GOD DAMN LANGUAGE AND ITS INPUT HANDLERS
             */

            sum = 0;
            List<String> _multiplications = new ArrayList<>();
            reader = new Scanner(new File(filePath));
            line = reader.nextLine();
            Scanner _line = new Scanner(line);
            Matcher switchMatcher = switchPattern.matcher(line);
            
            int counter = 0;

            while(reader.hasNextLine()){
                while(switchMatcher.find()){
                    if(switchMatcher.group().equals("don't()")){
                        counter++;
                        enabled = false;
                    }
                    else if(switchMatcher.group().equals("do()")){
                        counter++;
                        enabled = true;                        
                    }
                    else if(enabled){
                        _multiplications.add(switchMatcher.group());
                    }
                }

                line = reader.nextLine();
                switchMatcher = switchPattern.matcher(line);
                _line.close();
                _line = new Scanner(line);
            }

            while(switchMatcher.find()){
                if(switchMatcher.group().equals("don't()")){
                    counter++;
                    enabled = false;
                }
                else if(switchMatcher.group().equals("do()")){
                    counter++;
                    enabled = true;                        
                }
                else if(enabled){
                    _multiplications.add(switchMatcher.group());
                }
            }

            _line.close();

            for(String mult : _multiplications){
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
