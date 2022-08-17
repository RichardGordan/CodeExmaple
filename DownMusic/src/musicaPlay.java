import java.io.IOException;
import java.util.Scanner;

public class musicaPlay {
    public static void main(String[] args) throws IOException {
iTinesDown itunesPlayer = new iTinesDown();
        Scanner scan = new Scanner(System.in);
        System.out.println("Что хотите найти?");
        String serach = scan.nextLine();
itunesPlayer.playSong(serach);
    }
}
