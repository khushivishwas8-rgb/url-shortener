package com.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import java.net.URI;

@RestController
public class URLShortenerController {

    // Spring automatically gives us a working UrlRepository
    // — we never write "new UrlRepository()" ourselves
    @Autowired
    private UrlRepository repository;

    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random = new Random();

    @PostMapping("/shorten")
    public String shorten(@RequestBody String url) {

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new InvalidURLException("Must start with http:// or https://");
        }

        // STEP 1: check if this URL was already shortened before
        Optional<UrlEntity> existing = repository.findByOriginalUrl(url);
        if (existing.isPresent()) {
            return existing.get().getSlug();   // reuse old slug
        }

        // STEP 2: generate a new unique slug
        String slug;
        do {
            slug = generateSlug();
        } while (repository.findBySlug(slug).isPresent());

        // STEP 3: save to database
        UrlEntity entity = new UrlEntity(slug, url);
        repository.save(entity);

        return slug;
    }

    @GetMapping("/{slug}")
     public ResponseEntity <Void> expand(@PathVariable String slug) {
        Optional<UrlEntity> result = repository.findBySlug(slug);

        if(result.isPresent()){
        String originalUrl = result.get().getOriginalUrl();
        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl))
                .build();

        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    private String generateSlug() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}

