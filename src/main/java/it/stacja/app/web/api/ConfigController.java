package it.stacja.app.web.api;

import it.stacja.app.web.api.domain.Config;
import it.stacja.app.web.api.repository.ConfigRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("config")
public class ConfigController {

    private ConfigRepository configRepository;

    public ConfigController(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    @PutMapping("{name}")
    public String save(@PathVariable("name") String name, @RequestBody String body) {
        Config config = new Config();
        config.setName(name);
        config.setConfig(body);
        configRepository.save(config);
        return "";
    }

    @GetMapping("{name}")
    public String loadConfig(@PathVariable("name") String name){
        Config config = configRepository.findById(name).orElse(new Config());
        return config.getConfig();

    }
}
