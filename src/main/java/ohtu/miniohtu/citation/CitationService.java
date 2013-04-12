/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import java.util.List;

/**
 *
 * @author pksu
 */
public interface CitationService {
    void addCitation(Citation citation);
    List<Citation> getCitations();
}
