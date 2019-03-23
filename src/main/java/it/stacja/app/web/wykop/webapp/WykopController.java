package it.stacja.app.web.wykop.webapp;

import it.stacja.app.web.wykop.app.WykopService;
import it.stacja.app.web.wykop.domain.Wykop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wykop")
public class WykopController {

    private WykopService wykopService;

    public WykopController(WykopService wykopService) {
        this.wykopService = wykopService;
    }

    //    @RequestMapping(value = "main", method = RequestMethod.GET)
    @GetMapping("main")
    public void mainController(){

    }

    @PostMapping("add")
    public String add(CreateWykopRequest request) {
        wykopService.createWykop(request);
        return "redirect:list";
    }

    @GetMapping("list")
    public void list(Map pageMap) {
        List<Wykop> list = wykopService.selectAll();
        pageMap.put("list", list);
    }
}
