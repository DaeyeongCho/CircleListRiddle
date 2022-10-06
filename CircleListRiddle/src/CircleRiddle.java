import java.util.Scanner;

public class CircleRiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int howManyBoxes, trials;
        System.out.print("상자의 개수와 시행횟수 입력: ");
        howManyBoxes = scanner.nextInt();
        trials = scanner.nextInt();

        Repetition go = new Repetition(howManyBoxes, trials);
        
        go.allDoIt();

        scanner.close();
    }
}
