import java.io.File;
import java.util.*;

public class Day_6 {
    public static void main(String[] args) {
        String filePath = "input.txt";

        int rows = 0;
        int columns = 0;
        String line = "";
        char[][] map;
        int position[] = {0, 0};
        int c = 0;
        int counter = 1;

        try {
            Scanner reader = new Scanner(new File(filePath));
            
            while(reader.hasNextLine()){
                line = reader.nextLine();
                rows++;
            }
            columns = line.split("").length;
            reader.close();

            reader = new Scanner(new File(filePath));

            map = new char[rows][columns];
            while(reader.hasNextLine()){
                line = reader.nextLine();
                map[c] = line.toCharArray();

                c++;
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<'){
                        position[0] = i;
                        position[1] = j;

                        i = rows;
                        j = columns;
                    }
                }
            }

            while(position[0] > 0 && position[0] < rows-1 && position[1] > 0 && position[1] < columns-1){
                if(map[position[0]][position[1]] == '^'){
                    while(position[0] > 0 && map[position[0]-1][position[1]] != '#'){
                        map[position[0]][position[1]] = 'X';
                        position[0]--;
                    }
                    map[position[0]][position[1]] = '>';
                }
                else if(map[position[0]][position[1]] == 'v'){
                    while(position[0] < rows-1 && map[position[0]+1][position[1]] != '#'){
                        map[position[0]][position[1]] = 'X';
                        position[0]++;
                    }
                    map[position[0]][position[1]] = '<';
                }
                else if(map[position[0]][position[1]] == '>'){
                    while(position[1] < columns-1 && map[position[0]][position[1]+1] != '#'){
                        map[position[0]][position[1]] = 'X';
                        position[1]++;
                    }
                    map[position[0]][position[1]] = 'v';
                }
                else if(map[position[0]][position[1]] == '<'){
                    while(position[1] > 0 &&map[position[0]][position[1]-1] != '#'){
                        map[position[0]][position[1]] = 'X';
                        position[1]--;
                    }
                    map[position[0]][position[1]] = '^';
                }
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(map[i][j] == 'X'){
                        counter++;
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