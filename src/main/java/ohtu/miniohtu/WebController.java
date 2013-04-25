package ohtu.miniohtu;

import com.avaje.ebean.EbeanServer;
import java.util.HashMap;
import java.util.Map;
import ohtu.miniohtu.citation.BibRef;
import ohtu.miniohtu.citation.RefKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    
    @Autowired
    DBService db;
    
    @RequestMapping("/")
    public String indexPage(ModelMap model) {
        return "index";
    }

    @RequestMapping("/list")
    public String listPage(ModelMap model) {
        model.addAttribute("citationList", db.getCitations());
        return "list";
    }


    @RequestMapping(value = "/list/sort/{type}", method = RequestMethod.GET) 
    public String sortedList(ModelMap model, @PathVariable String type) {
        model.addAttribute("citationList", db.getSortedBy(type));
        return "list";
    }
    
    @RequestMapping(value = "/remove/{item}", method = RequestMethod.GET) 
    public String removeItem(ModelMap model, @PathVariable String item) {
        db.removeCitation(item);
        return "list";
    }
    
    @RequestMapping(value = "/edit/{item}", method = RequestMethod.GET) 
    public String getEditForm(ModelMap model, @PathVariable String item) {
        model.addAttribute("existingData", db.getCitation(item));
        model.addAttribute("validTypes", BibRef.getValidTypes());
        return "edit";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST) 
    public String saveEditedItem(ModelMap model, @RequestParam Map<String,String> entries) {
        db.updateCitation(handlePost(entries));
        model.addAttribute("citationList", db.getCitations());
        return "list";
    }
    
    @RequestMapping("/bibtex")
    public String showBibtex(ModelMap model) {
        String bibtex = "";
        for(BibRef br : db.getCitations()) {
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
    public String addEntry(ModelMap model,@RequestParam Map<String,String> entries) {
        try{
            db.addCitation(handlePost(new HashMap(entries)));
            return "redirect:list";
        }catch(IllegalArgumentException e){
            model.addAttribute("message", e.getMessage());
            model.addAttribute("existingData", handlePost(entries));
            model.addAttribute("validTypes", BibRef.getValidTypes());
            return "edit";
        }
    }
    
    private BibRef handlePost(Map<String,String> postData) {
        BibRef br = new BibRef();
        br.setShorthand(postData.remove("shorthand"));
        br.setType(postData.remove("type"));
        HashMap<String, RefKey> hm = new HashMap<String,RefKey>();
        for(Map.Entry<String,String> es : postData.entrySet()) {
            RefKey r = new RefKey(es.getValue());
            
            hm.put(es.getKey().toLowerCase(), r);
        }
        br.setEntries(hm);
        return br;
    }
}