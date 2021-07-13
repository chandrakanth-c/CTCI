package companies.amazon.sde2;
import java.util.*;

public class IsWord {
    public static Set<String> dict = new HashSet<>() {{
            add("A");
            add("APP");
            add("APPLE");
            add("AS");
            add("ASK");
            add("PASK");
            add("ELK");
    }};;
    
    public static void main(String[] args) {
        char[][] matrix = {
            {'A', 'P', 'P'},
            {'S', 'K', 'L'},
            {'K', 'E', 'L'}
        };
        System.out.println(printLongestWord(matrix));
    }
    
    public static String printLongestWord(char[][] matrix) {
        Set<String> foundWords = new HashSet<>();
        String max = new String();
        
        int m = matrix.length, n = matrix[0].length;
        
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                dfs(i, j, matrix, new StringBuilder(), foundWords);
        
        System.out.println(foundWords); // Prints [A, APP, AS, APPLE, ELK, ASK, PASK]
        
         for(String word : foundWords)
            if(word.length() > max.length())
                max = word;
        
        return max.toString(); // Prints APPLE
    }
    
    private static void dfs(int i, int j, char[][] matrix, StringBuilder cur, Set<String> foundWords) {
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[i].length) return;
        if(matrix[i][j] == '#') return;
                
        if(isWord(cur.toString()) && !foundWords.contains(cur.toString()))
            foundWords.add(cur.toString());
        
        char temp = matrix[i][j];
        cur.append(temp);
        
        matrix[i][j] = '#';
        
        dfs(i + 1, j, matrix, new StringBuilder(cur), foundWords);
        dfs(i - 1, j, matrix, new StringBuilder(cur), foundWords);
        dfs(i, j + 1, matrix, new StringBuilder(cur), foundWords);
        dfs(i, j - 1, matrix, new StringBuilder(cur), foundWords);
        dfs(i + 1, j + 1, matrix, new StringBuilder(cur), foundWords);
        dfs(i + 1, j - 1, matrix, new StringBuilder(cur), foundWords);
        dfs(i - 1, j + 1, matrix, new StringBuilder(cur), foundWords);
        dfs(i - 1, j - 1, matrix, new StringBuilder(cur), foundWords);
        
        matrix[i][j] = temp;
    }
    
    public static boolean isWord(String word) {
        return dict.contains(word);
    }
}
