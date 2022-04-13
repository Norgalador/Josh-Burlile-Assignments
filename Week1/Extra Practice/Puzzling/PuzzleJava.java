import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomNums = new ArrayList<Integer>();
        Random rand = new Random();

        for(int i = 1; i <= 10; i++) {
            randomNums.add(rand.nextInt(20) + 1);
        }

        return randomNums;
    }

    public String getRandomLetter() {
        Random rand = new Random();
        String alphaString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for(int i = 0; i < 26; i++){
            alphabet[i] = String.valueOf(alphaString.charAt(i));
        }
        return alphabet[rand.nextInt(26)];
    }
}
