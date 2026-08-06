package com.urlshortener;


import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.Pattern;

 public class ShortenRequest {
@NotBlank(message = "Url cannot be empty")
@Pattern(regexp = "https?://.*", message = "Must start with https:// or http://")
    private String url;
public String getUrl(){
return url;
}

public void setUrl(String url){
        this.url = url;
}
 }


