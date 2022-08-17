import java.util.Scanner;

public class reader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.next();
int j = 0;
        for (int index=0; index<word.length()-1; index++){
            if (word.indexOf(word.charAt(index))==index) {
                System.out.println("Уникальная  "+word.charAt(index));
                break;
            }
        }
        }
    }
