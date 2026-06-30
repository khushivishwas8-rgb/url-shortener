package com.urlshortener;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface  UrlRepository  extends JpaRepository<UrlEntity,Long>{

    Optional<UrlEntity> findBySlug(String slug);
    Optional<UrlEntity> findByOriginalUrl(String originalUrl);
}
