package com.urlshortener;
import jakarta.persistence.*;
@Entity
@Table(name = "url")

public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(nullable = false)
    private String originalUrl;

    // constructor
    public UrlEntity(){}

    public UrlEntity (String slug, String originalUrl){
        this.slug = slug;
        this.originalUrl = originalUrl;
    }

    //getter and setter
     public long getId(){return id;}
    public String getSlug(){return slug;}
    public String getOriginalUrl(){return originalUrl;}
    public void setSlug(String url) {this.slug = slug;}
    public void setOriginalUrl(String url){this.originalUrl = originalUrl;}

}
