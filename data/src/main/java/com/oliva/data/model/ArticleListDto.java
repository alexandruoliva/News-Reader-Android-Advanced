package com.oliva.data.model;

import java.util.List;

public class ArticleListDto {

    public final int totalResults;
    public final List<ArticleDto> articles;

    ArticleListDto(int totalResults, List<ArticleDto> articles) {
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
