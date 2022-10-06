import java.util.Random;

public class Repetition {
    private int howManyBox;
    private int trials;
    public Repetition(int howManyBoxes, int trials) {
        this.howManyBox = howManyBoxes;
        this.trials = trials;
    }

    public void allDoIt() {
        int successNumber = 0;
        for(int i = 0; i < trials; i++) {
            if(oneDoIt() == true) {
                successNumber++;
            }
        }
        System.out.println("성공횟수: " + successNumber + "/" + trials);
    }

    private boolean oneDoIt() {
        BoxArray[] boxArray = new BoxArray[howManyBox];
        Random random = new Random();
         int numberOfBoxArray[] = new int[howManyBox];
        int numberOfContentsArray[] = new int[howManyBox]; 

        int numberOfSuccess = 0;

        for(int i = 0; i < howManyBox; i++) {
            numberOfBoxArray[i] = random.nextInt(howManyBox) + 1;
            for(int j = 0; j < i; j++) {
                if(numberOfBoxArray[i] == numberOfBoxArray[j]) {
                    i--;
                }
            }
        }

        for(int i = 0; i < howManyBox; i++) {
            numberOfContentsArray[i] = random.nextInt(howManyBox) + 1;
            for(int j = 0; j < i; j++) {
                if(numberOfContentsArray[i] == numberOfContentsArray[j]) {
                    i--;
                }
            }
        }

        for(int i = 0; i < howManyBox; i++) {
            boxArray[i] = new BoxArray(numberOfBoxArray[i], numberOfContentsArray[i]);
        }

        for(int i = 1; i <= howManyBox; i++) {
            if(onePersonDoIt(i, boxArray) == true) {
                numberOfSuccess++;
            }
        }
        System.out.println(numberOfSuccess);
        if(numberOfSuccess == howManyBox) {
            return true;
        } else {
            return false;
        }
    }

    private boolean onePersonDoIt(int numberOfPerson, BoxArray[] boxArray) {
        int nowHasNumber = numberOfPerson;
        for(int i = 1; i <= boxArray.length / 2; i++) {
            for(int j = 0; j < boxArray.length; j++) {
                if(nowHasNumber == boxArray[j].getNumberOfBox()) {
                    if (numberOfPerson == boxArray[j].getNumberOfContents()) {
                        return true;
                    } else {
                        nowHasNumber = boxArray[j].getNumberOfContents();
                        break;
                    }
                }
            }
        }
        return false;
    }
}
