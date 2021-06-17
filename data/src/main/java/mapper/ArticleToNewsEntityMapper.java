package mapper;

import androidx.annotation.NonNull;

import com.oliva.data.model.Article;
import com.oliva.data.model.entities.local.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;


public class ArticleToNewsEntityMapper implements Function<List<Article>, List<ArticleEntity>> {

    private static final String DEFAULT_TITLE = "Default title";
    private static final String DEFAULT_CONTENT = "Default content";
    private static final String DEFAULT_IMAGE_URL = "www.imageurl.com";


    @Override
    public List<ArticleEntity> apply(@NonNull List<Article> articles) throws Exception {
        List<ArticleEntity> articleEntityList = new ArrayList<>();

        for (Article currentArticle : articles) {
            ArticleEntity articleEntity = new ArticleEntity();

            articleEntity.setContent(!currentArticle.content.equals("") ? currentArticle.content : DEFAULT_CONTENT);
            articleEntity.setContent(!currentArticle.imageUrl.equals("") ? currentArticle.imageUrl : DEFAULT_IMAGE_URL);
            articleEntity.setContent(!currentArticle.title.equals("") ? currentArticle.title : DEFAULT_TITLE);

            articleEntityList.add(articleEntity);
        }

        return  articleEntityList;
    }
}
