import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class iTines {
    public static void main(String[] args) throws IOException {
String url = downloadWebPage(" https://itunes.apple.com/search?term=jack+johnson");
System.out.println(url);
    }
    static String downloadWebPage(String url) throws IOException {

        StringBuilder result = new StringBuilder();
        String line;

        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }
    public static String writeToFile(String str) throws IOException{


        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\mypag2e.html"));
        writer.write(str);
        writer.close();

        return str;
    }
}
