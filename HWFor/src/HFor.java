import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HFor {
    public static void main(String[] args) throws IOException {
       for(int day = 1;day < 5; day++) {
           String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2021-11-" + day);
           int urlBigen = page.lastIndexOf("url");
           int urlEnd = page.lastIndexOf("}");
           String url = page.substring(urlBigen + 6, urlEnd - 1);
           try (InputStream in = new URL(url).openStream()) {
               Files.copy(in, Paths.get(day + "new.jpg"));
           }
           System.out.println("Picture Saved" + day);
       }

    }
    private static String downloadWebPage(String url) throws IOException {

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
