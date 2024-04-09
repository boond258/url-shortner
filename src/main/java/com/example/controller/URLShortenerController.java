@RestController
@RequestMapping("/api/v1/urls")
public class URLShortenerController {
    private final URLShortenerService urlShortenerService;

    @Autowired
    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortenedURL> shortenURL(@RequestBody URL url) {
        ShortenedURL shortenedURL = urlShortenerService.shortenURL(url);
        return ResponseEntity.ok(shortenedURL);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalURL(@PathVariable String shortUrl, HttpServletResponse response) {
        String originalURL = urlShortenerService.getOriginalURL(shortUrl);
        if (originalURL != null) {
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("Location", originalURL);
            return ResponseEntity.status(HttpServletResponse.SC_MOVED_PERMANENTLY).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}