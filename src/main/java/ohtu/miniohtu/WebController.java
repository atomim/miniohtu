package ohtu.miniohtu;

import ohtu.miniohtu.citation.Citation;
import ohtu.miniohtu.citation.CitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    CitationService cs;

    @RequestMapping("/")
    public String indexPage(ModelMap model) {
        return "index";
    }

    @RequestMapping("/list")
    public String listPage(ModelMap model, @ModelAttribute Citation cit) {
        model.addAttribute("citationList", cs.getCitations());
        return "list";
    }

    @RequestMapping("/add")
    public String addPage(ModelMap model) {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEntry(@ModelAttribute Citation cit) {
        cs.addCitation(cit);
        return "redirect:list";
    }
}