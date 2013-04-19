package ohtu.miniohtu;

import com.avaje.ebean.EbeanServer;
import java.util.HashMap;
import java.util.Map;
import ohtu.miniohtu.citation.BibRef;
import ohtu.miniohtu.citation.BibRefService;
import ohtu.miniohtu.citation.RefKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    BibRefService bs;
    
    @Autowired
    DBService db;
    
    @RequestMapping("/")
    public String indexPage(ModelMap model) {
        return "index";
    }

    @RequestMapping("/list")
    public String listPage(ModelMap model) {
        model.addAttribute("citationList", db.getCitations());
        System.out.println(db.getCitations().get(0));
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
    public String addEntry(@RequestParam Map<String,String> entries) {
        db.addCitation(handlePost(entries));
        return "redirect:list";
    }
    private BibRef handlePost(Map<String,String> postData) {
        BibRef br = new BibRef();
        br.setShorthand(postData.remove("shorthand"));
        br.setType(postData.remove("type"));
        HashMap<String, RefKey> hm = new HashMap<String,RefKey>();
        for(Map.Entry<String,String> es : postData.entrySet()) {
            RefKey r = new RefKey(es.getValue());
            hm.put(es.getKey(), r);
        }
        br.setEntries(hm);
        return br;
    }
}