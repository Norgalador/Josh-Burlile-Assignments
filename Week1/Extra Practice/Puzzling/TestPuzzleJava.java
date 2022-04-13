import java.util.Random;
import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        // Randomizer Tests //
        
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);
        
        System.out.println(generator.getRandomLetter());
    }
}
