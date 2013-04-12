package ohtu.miniohtu.citation;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author pksu
 */
@Component
public class CitationsInMemory implements CitationService {
    private List<Citation> citations;
    
    public CitationsInMemory() {
        citations = new ArrayList<Citation>();
    }
    
    @Override
    public void addCitation(Citation citation) {
        citations.add(citation);
    }

    @Override
    public List<Citation> getCitations() {
        System.out.println(citations);
        return citations;
    }
    
}
