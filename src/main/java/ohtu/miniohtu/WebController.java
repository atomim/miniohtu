package ohtu.miniohtu;

import com.avaje.ebean.EbeanServer;
import java.io.IOException;
import ohtu.miniohtu.citation.BibRef;
import ohtu.miniohtu.citation.BibRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    BibRefService bs;
    
    @Autowired
    EbeanServer server;
    
    @RequestMapping("/")
    public String indexPage(ModelMap model) {
        return "index";
    }

    @RequestMapping("/list")
    public String listPage(ModelMap model) {
        model.addAttribute("citationList", bs.getCitations());
        return "list";
    }

    @RequestMapping("/bibtex")
    public String showBibtex(ModelMap model) {
        String bibtex = "";
        for(BibRef br : bs.getCitations()) {
            bibtex += br.toString();
        }
        model.addAttribute("bibtexSource", bibtex);
        return "bibtex";
    }
    
    @RequestMapping("/add")
    public String addPage(ModelMap model) {
        model.addAttribute("validTypes", BibRef.getValidTypes());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEntry(@ModelAttribute BibRef cit) {
        //cs.addCitation(cit);
        return "redirect:list";
    }
}