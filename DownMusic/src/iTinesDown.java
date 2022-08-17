import javax.print.DocFlavor;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class iTinesDown {
    void playSong(String serachRequest) throws IOException {
playSongInternal(serachRequest,1);
    }
    void playSong(String serachRequest,int limit) throws IOException {
playSongInternal(serachRequest,limit);
    }
    void playSongInternal(String serachRequest,int limit) throws IOException {
        String url = buildUrl(serachRequest,limit);
        String page = downloadWebPage(url);
        String artistName = getTag(page, "artistName");
        String trackName = getTag(page, "trackName");
        String previewURL = getTag(page, "previewUrl");
        System.out.println(page);
        try (InputStream in = new URL(previewURL).openStream()) {
            Files.copy(in, Paths.get(trackName + "m4a"));
        }

        if (!Desktop.isDesktopSupported()) {
            System.out.println("not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File(trackName + "m4a");
        desktop.open(file);

        System.out.println(artistName + " - " + trackName);
    }

    private String getTag(String page,String tagName) {
        int start = page.indexOf(tagName) + tagName.length() + 3;
        int end = page.indexOf("\"",start);
        String value = page.substring(start,end);
        return value;
    }


    private String buildUrl(String serachRequest,int limit) {
        String term = serachRequest.replaceAll(" ", "+");
        String itunesApi = " https://itunes.apple.com/search?term=";
        String limitedParam = "&limit=" + limit;
        String mediaParam = "&media=music";
        StringBuilder builder = new StringBuilder();
        builder.append(itunesApi);
        builder.append(term);
        builder.append(limitedParam);
        builder.append(mediaParam);
        return builder.toString();
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
}
