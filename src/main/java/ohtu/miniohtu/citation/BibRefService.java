/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import java.util.List;

/**
 *
 * @author ppurokur
 */
public interface BibRefService {
    void addCitation(BibRef bc);
    List<BibRef> getCitations();
}
