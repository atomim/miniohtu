/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu;

import java.util.List;
import ohtu.miniohtu.citation.BibRef;

/**
 *
 * @author pksu
 */
public interface DBService {
    void addCitation(BibRef bc);
    List<BibRef> getCitations();
}
