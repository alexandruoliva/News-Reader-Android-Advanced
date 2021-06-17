package mapper;

import androidx.annotation.NonNull;

import com.oliva.data.model.Article;
import com.oliva.data.model.entities.local.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;


public class ArticleToNewsEntityMapper implements Function<List<Article>, List<ArticleEntity>> {

    private static final String DEFAULT_TITLE = "Default title";
    private static final String DEFAULT_DESCRIPTION = "Default description";
    private static final String DEFAULT_CONTENT = "Default content";
    private static final String DEFAULT_IMAGE_URL = "www.imageurl.com";


    @Override
    public List<ArticleEntity> apply(@NonNull List<Article> articles) throws Exception {
        List<ArticleEntity> articleEntityList = new ArrayList<>();

        for (Article currentArticle : articles) {
            ArticleEntity articleEntity = new ArticleEntity();

            articleEntity.setContent(!currentArticle.content.equals("") ? currentArticle.content : DEFAULT_CONTENT);
            articleEntity.setImageUrl(!currentArticle.imageUrl.equals("") ? currentArticle.imageUrl : DEFAULT_IMAGE_URL);
            articleEntity.setTitle(!currentArticle.title.equals("") ? currentArticle.title : DEFAULT_TITLE);
            articleEntity.setDescription(!currentArticle.description.equals("") ? currentArticle.description : DEFAULT_DESCRIPTION);

            articleEntityList.add(articleEntity);
        }

        return  articleEntityList;
    }
}
