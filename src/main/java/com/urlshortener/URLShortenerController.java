package com.urlshortener;
import org.springframework.web.bind.annotation.*;
@RestController
public class URLShortenerController {

    private final URLShortener shortener = new URLShortener();

    @PostMapping("/shorten")

    public String shorten(@RequestBody String url){
       if(!url.startsWith("http://") && !url.startsWith("https://")){
           throw new InvalidURLException("Must start with http:// or https://");
       }
       return shortener.shorten(url);
    }

    @GetMapping("/{slug}")
    public String expand (@PathVariable String slug){
        String url = shortener.expand(slug);
        if(url == null){
            return "Slug not found";
        }
        return url;
    }

    @GetMapping("/health")
    public String health(){
        return "OK";
    }
}

