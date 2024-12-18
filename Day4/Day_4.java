import java.io.File;
import java.util.*;
import java.util.regex.MatchResult;

public class Day_4 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        int rows = 0;
        int columns = 0;
        int counter = 0;
        String line = "";
        List<MatchResult> list = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                rows++;
                columns = reader.nextLine().split("").length;
            }
            reader.close();
            reader = new Scanner(new File(filePath));
            
            list = reader.findAll("XMAS").toList();
            counter += list.size();

            reader.close();
            reader = new Scanner(new File(filePath));

            list = reader.findAll("SAMX").toList();
            counter += list.size();

            reader.close();
            reader = new Scanner(new File(filePath));

            reader = new Scanner(new File(filePath)); 
            char[][] matrix = new char[rows][columns];

            for(int i = 0; i < rows; i++){
                matrix[i] = reader.nextLine().toCharArray();
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if((i + 3 < rows) && matrix[i][j] == 'X' && matrix[i+1][j] == 'M' &&
                    matrix[i+2][j] == 'A' && matrix[i+3][j] == 'S'){
                        counter++;
                    }
                }
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if((i + 3 < rows) && matrix[i][j] == 'S' && matrix[i+1][j] == 'A' &&
                    matrix[i+2][j] == 'M' && matrix[i+3][j] == 'X'){
                        counter++;
                    }
                }
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if((j + 3 < columns) && (i + 3 < rows) && matrix[i][j] == 'X' && matrix[i+1][j+1] == 'M' &&
                    matrix[i+2][j+2] == 'A' && matrix[i+3][j+3] == 'S'){
                        counter++;
                    }
                }
            }
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if((j + 3 < columns) && (i + 3 < rows) && matrix[i][j] == 'S' && matrix[i+1][j+1] == 'A' &&
                    matrix[i+2][j+2] == 'M' && matrix[i+3][j+3] == 'X'){
                        counter++;
                    }
                }
            }
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if((i + 3 < rows) && (j - 3 >= 0) && matrix[i][j] == 'X' && matrix[i+1][j-1] == 'M' &&
                    matrix[i+2][j-2] == 'A' && matrix[i+3][j-3] == 'S'){
                        counter++;
                    }
                }
            }
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if((i + 3 < rows) && (j - 3 >= 0) && matrix[i][j] == 'S' && matrix[i+1][j-1] == 'A' &&
                    matrix[i+2][j-2] == 'M' && matrix[i+3][j-3] == 'X'){
                        counter++;
                    }
                }
            }

            System.out.println(counter);
            counter = 0;

            for(int i = 1; i < rows-1; i++){
                for(int j = 1; j < columns-1; j++){
                    if(matrix[i][j] == 'A'){
                        if(matrix[i-1][j-1] == 'M' && matrix[i+1][j+1] == 'S' && matrix[i-1][j+1] == 'M' && matrix[i+1][j-1] == 'S' ||
                        matrix[i-1][j-1] == 'S' && matrix[i+1][j+1] == 'M' && matrix[i-1][j+1] == 'S' && matrix[i+1][j-1] == 'M' ||
                        matrix[i-1][j-1] == 'M' && matrix[i+1][j+1] == 'S' && matrix[i-1][j+1] == 'S' && matrix[i+1][j-1] == 'M' ||
                        matrix[i-1][j-1] == 'S' && matrix[i+1][j+1] == 'M' && matrix[i-1][j+1] == 'M' && matrix[i+1][j-1] == 'S'){
                            counter ++;
                        }
                    }
                }
            }

            System.out.println(counter);

            reader.close();
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}