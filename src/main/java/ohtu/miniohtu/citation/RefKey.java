/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class RefKey {

    @Id
    private Integer id;
    
    @ManyToOne
    BibRef bibref;
    
    private String mapkey;

    public RefKey() {
    
    }

    public RefKey(String s) {
        setKey(s); // <- Jottei setKey():lle tarvitse tehdä erikseen testiä.
    }

    public BibRef getBibref() {
        return bibref;
    }

    public void setBibref(BibRef bibref) {
        this.bibref = bibref;
    }
    private String key;

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

    /**
     * @return the mapkey
     */
    public String getMapkey() {
        return mapkey;
    }

    /**
     * @param mapkey the mapkey to set
     */
    public void setMapkey(String mapkey) {
        this.mapkey = mapkey;
    }
}
