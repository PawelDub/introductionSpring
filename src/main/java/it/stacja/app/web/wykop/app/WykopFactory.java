package it.stacja.app.web.wykop.app;

import it.stacja.app.web.wykop.app.image.PageImageResolver;
import it.stacja.app.web.wykop.domain.Wykop;
import it.stacja.app.web.wykop.infrastructure.WykopRepository;
import it.stacja.app.web.wykop.webapp.CreateWykopRequest;
import org.springframework.stereotype.Component;

@Component
public class WykopFactory {

    private PageImageResolver imageResolver;
    private WykopRepository wykopRepository;

    public WykopFactory(PageImageResolver imageResolver, WykopRepository wykopRepository) {
        this.imageResolver = imageResolver;
        this.wykopRepository = wykopRepository;
    }

    public Wykop createWykop(CreateWykopRequest request) {
        Wykop wykop = new Wykop(request.getName(),
                request.getDescription(), request.getUrl(), imageResolver.resolveImageURL(request.getUrl()));
        this.wykopRepository.save(wykop);
        return wykop;
    }
}
