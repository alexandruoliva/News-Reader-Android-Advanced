package com.oliva.data.entities;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class ArticleDto {

    public final SourceDto source;
    public final String urlToImage;
    public final String url;
    public final String content;
    public final String description;
    public final String title;
    public final String author;

    public ArticleDto(SourceDto source, String urlToImage, String url, String content, String description, String title, String author) {
        this.source = source;
        this.urlToImage = urlToImage;
        this.url = url;
        this.content = content;
        this.description = description;
        this.title = title;
        this.author = author;
    }
}
