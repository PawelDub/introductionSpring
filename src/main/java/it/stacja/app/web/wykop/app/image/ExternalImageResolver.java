package it.stacja.app.web.wykop.app.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExternalImageResolver implements PageImageResolver {

    private static final Logger LOGGER
            = LogManager.getLogger(ExternalImageResolver.class.getName());


    @Override
    public String resolveImageURL(String pageURL) {
        try {
            Document document = Jsoup.connect(pageURL).get();
            Elements metas = document.getElementsByTag("meta");
            Elements meta = metas.select("[property=og:image]");
            return meta.stream()
                    .findFirst()
                    .map(element -> element
                            .attr("content"))
                    .orElse("/images/cross.png");
        } catch (IOException e) {
            LOGGER.error(() ->
                            e.getLocalizedMessage()
                    , e);
        }
        return "/images/cross.png";
    }
}
