
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Hangman {
    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("what is your name?");
        String player = keyboard.nextLine();

        String word;

        Scanner scanner = new Scanner(new File("words_alpha.txt"));
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();
        word = words.get(rand.nextInt(words.size()));

        List<Character> playerGuesses = new ArrayList<>();

        int wrongCount = 0;
        boolean game = true;
        while(game) {
            printHangedMan(wrongCount);

            printWordState(word, playerGuesses);
            if (!getPlayerGuess(word, playerGuesses)) {
                wrongCount++;
            }

            if(printWordState(word, playerGuesses)) {
                history(player,wrongCount);
                System.out.println("do you want to play again? y or n");
                Scanner check =new Scanner(System.in);
                String yesOrNo = check.nextLine();
                game = replay(yesOrNo);
                wrongCount=0;
                playerGuesses.clear();
                word = words.get(rand.nextInt(words.size()));
            }
            if (wrongCount >= 6) {
                System.out.println(player+" You lose!");
                System.out.println("The word was: " + word);
                System.out.println("do you want to play again? y or n");
                Scanner check =new Scanner(System.in);
                String yesOrNo = check.nextLine();
                game = replay(yesOrNo);
                wrongCount=0;
                playerGuesses.clear();
                word = words.get(rand.nextInt(words.size()));
            }
            System.out.println("");
        }
    }

    public static void printHangedMan(Integer wrongCount) {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            }

        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            }
        }System.out.println("");
    }

    public static boolean getPlayerGuess(String word, List<Character> playerGuesses) {
        Scanner key = new Scanner(System.in);
        String letterGuess = "";
        try{
            System.out.println("Please enter a letter:");
            letterGuess = key.nextLine();
            playerGuesses.add(letterGuess.charAt(0));
        }catch(Exception e){
            System.out.println("exception in getPlayerGuess method");
        }
        return word.contains(letterGuess);
    }

    public static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }

        return (word.length() == correctCount);
    }
    public  static void history(String name, int wrongCount) {
        try{
            File out = new File("output.txt");
            out.createNewFile();
            String readIN= Files.readString(Paths.get("output.txt"));
            String [] temp=readIN.split(" ");
            List<String> hist= Arrays.stream(temp).filter(x -> x.length() == 1).sorted().toList();
            if(Integer.parseInt(hist.get(0))>wrongCount)
                System.out.println("congratulations "+name+"! you win!");
            Files.writeString(Path.of("output.txt"), readIN+" "+name+" "+wrongCount );
        }
        catch (Exception e)
        {   System.out.println("!!!!!! here is history function !!!!!!");
            e.printStackTrace();
        }
    }
    public static boolean replay(String yesOrNo){

        return !Objects.equals(yesOrNo, "n");
    }
}
