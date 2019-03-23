package it.stacja.app.web.wykop.app;

import it.stacja.app.web.wykop.domain.Wykop;
import it.stacja.app.web.wykop.infrastructure.WykopRepository;
import it.stacja.app.web.wykop.webapp.CreateWykopRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultWykopService implements WykopService {

    private WykopFactory wykopFactory;

    private WykopRepository wykopRepository;


    public DefaultWykopService(WykopFactory wykopFactory, WykopRepository wykopRepository) {
        this.wykopFactory = wykopFactory;
        this.wykopRepository = wykopRepository;
    }

    @Override
    public void createWykop(CreateWykopRequest request) {
        this.wykopFactory.createWykop(request);
    }

    @Override
    public List<Wykop> selectAll() {
        return wykopRepository.findAll();
    }

    @Autowired
    public void setWykopFactory(WykopFactory wykopFactory) {
        this.wykopFactory = wykopFactory;
    }
}
