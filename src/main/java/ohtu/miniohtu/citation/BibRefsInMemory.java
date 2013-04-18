package ohtu.miniohtu.citation;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author pksu
 */
@Component
public class BibRefsInMemory implements BibRefService {
    private List<BibRef> citations;
    
    public BibRefsInMemory() {
        citations = new ArrayList<BibRef>();
    }

    @Override
    public void addCitation(BibRef bc) {
        citations.add(bc);
    }

    @Override
    public List<BibRef> getCitations() {
        return citations;
    }
}
