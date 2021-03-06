package mapper;

import androidx.annotation.NonNull;

import com.oliva.data.model.Article;
import com.oliva.data.model.entities.local.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;


public class EntitiesToArticlesMapper implements Function<List<ArticleEntity>, List<Article>> {

    private static final String DEFAULT_TITLE = "Default title";
    private static final String DEFAULT_CONTENT = "Default content";
    private static final String DEFAULT_DESCRIPTION = "Default description";
    private static final String DEFAULT_IMAGE_URL = "www.imageurl.com";


    @Override
    public List<Article> apply(@NonNull List<ArticleEntity> articleEntityList) throws Exception {
        List<Article> articles = new ArrayList<>();

        for (ArticleEntity articleEntity : articleEntityList) {
            Article article = new Article();

            article.setDescription(!articleEntity.description.equals("") ? articleEntity.description : DEFAULT_DESCRIPTION);
            article.setContent(!articleEntity.content.equals("") ? articleEntity.content : DEFAULT_CONTENT);
            article.setImageUrl(!articleEntity.imageUrl.equals("") ? articleEntity.imageUrl : DEFAULT_IMAGE_URL);
            article.setTitle(!articleEntity.title.equals("") ? articleEntity.title : DEFAULT_TITLE);

        }

        return articles;
    }
}
