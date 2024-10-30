
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class LinkShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;
    private static final int SHORT_URL_LENGTH = 6;
    public LinkShortener() {
        this.shortToLongMap = new HashMap<>();
        this.longToShortMap = new HashMap<>();
    }
    public String shortenUrl(String longUrl) {
        if (longToShortMap.containsKey(longUrl)) {
            return longToShortMap.get(longUrl);
        }
        String shortUrl = generateShortUrl();
        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);
        return shortUrl;
    }
    public String expandUrl(String shortUrl) {
        return shortToLongMap.getOrDefault(shortUrl, "URL not found");
    }
    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = rand.nextInt(characters.length());
            shortUrl.append(characters.charAt(index));
        }
        return shortUrl.toString();
    }
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        String longUrl = "https://www.javaprograming.com";
        String shortUrl = linkShortener.shortenUrl(longUrl);
        System.out.println("Shortened URL: " + shortUrl);
        String expandedUrl = linkShortener.expandUrl(shortUrl);
        System.out.println("Expanded URL: " + expandedUrl);
    }
}
