import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordBoard {

    // LETTER RE-USE NOT ALLOWED
    public static ArrayList<String> findWordsUseLettersOnce(char [][] board, String [] words){
        ArrayList<String> resL = new ArrayList<>();
        int m = board.length, n = board[0].length; // m rows , n cols

        boolean [][] visited = new boolean[m][n];
        boolean found = false;

        for(String s: words){
            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    found = false;
                    if(findWordV2(board, i, j, s.toCharArray(), 0, visited)){
                        resL.add(s);
                        clear(visited);
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
        }
        return resL;
    }

    private static boolean findWordV2(char [][] board, int i, int j, char[] word, int idx, boolean [][] visited) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] != word[idx] || visited[i][j] || idx >= word.length)
            return false;

        if(word.length == idx + 1){
            if(board[i][j] == word[idx]){
                visited[i][j] = true;
                return true;
            }
            else return false;
        }

        visited[i][j] = true;

        if(findWordV2(board, i - 1, j, word, idx+1, visited) ||
                findWordV2(board, i, j + 1, word, idx+1, visited) ||
                findWordV2(board, i + 1, j, word, idx+1, visited) ||
                findWordV2(board, i, j -1, word, idx+1, visited)){
            return true;
        }else{
            visited[i][j] = false;
            return false;
        }
    }
        // e a n
    // t t i
    // a r a
    private static boolean findWord(char [][] board, int i, int j, String word, boolean [][] visited) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] != word.charAt(0) || visited[i][j] || word.length() == 0)
            return false;

        if(word.length() == 1){
            if(board[i][j] == word.charAt(0)){
                visited[i][j] = true;
                return true;
            }
            else return false;
        }

        visited[i][j] = true;

        if(findWord(board, i - 1, j, word.substring(1), visited) ||
                findWord(board, i, j + 1, word.substring(1), visited) ||
                findWord(board, i + 1, j, word.substring(1), visited) ||
                findWord(board, i, j -1, word.substring(1), visited)){
            return true;
        }else{
            visited[i][j] = false;
            return false;
        }
    }
    private static void clear(boolean [][] b){
        for(int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++) b[i][j] = false;
    }

    // LETTER RE-USE ALLOWED
    public static ArrayList<String> findWords(char [][] board, String [] words){
        Map<Character, ArrayList<String>> h = new HashMap<>();
        ArrayList<String> resL = new ArrayList<>();
        int m = board.length, n = board[0].length; // m rows , n cols
        for(int i = 0; i < words.length; i++){
            ArrayList<String> a = h.getOrDefault(words[i].charAt(0), new ArrayList<>());
            a.add(words[i]);
            h.put(words[i].charAt(0), a);
        }
        boolean [][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<String> arr = h.get(board[i][j]);
                for (int k = 0; arr != null && k < arr.size(); k++) {
                    if(findWord(board, i, j, arr.get(k), visited)){
                        resL.add(arr.get(k));
                        arr.remove(k);
                        clear(visited);
                        i = 0; j = -1;
                        break;
                    }
                    h.put(board[i][j], arr);
                }
            }
        }
        return resL;
    }

}
