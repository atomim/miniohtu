/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author pksu
 */
@Entity
public class RefKey {

    @Id
    private Integer id;
    @ManyToOne
    BibRef bibref;

    public RefKey() {
    }

    public RefKey(String s) {
        key = s;
    }

    public BibRef getBibref() {
        return bibref;
    }

    public void setBibref(BibRef bibref) {
        this.bibref = bibref;
    }
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return key;
    }
}
