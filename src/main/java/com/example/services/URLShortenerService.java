import redis.RedisTemplate;

@Service
public class URLShortenerService {
    private final RedisTemplate<String, String> redisTemplate;
    private final URLShortenerUtils urlShortenerUtils;

    @Autowired
    public URLShortenerService(RedisTemplate<String, String> redisTemplate, URLShortenerUtils urlShortenerUtils) {
        this.redisTemplate = redisTemplate;
        this.urlShortenerUtils = urlShortenerUtils;
    }

    public ShortenedURL shortenURL(URL url) {
        String shortUrl = urlShortenerUtils.generateShortUrl();
        redisTemplate.opsForValue().set(shortUrl, url.toString());
        return new ShortenedURL(shortUrl, url);
    }

    public String getOriginalURL(String shortUrl) {
        return redisTemplate.opsForValue().get(shortUrl);
    }
}