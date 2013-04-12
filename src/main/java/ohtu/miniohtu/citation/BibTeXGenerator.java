/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniohtu.citation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXFormatter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pksu
 */
public class BibTeXGenerator {
    public static String generateBibtex(List<Citation> citations) throws IOException {
        BibTeXFormatter btFormatter = new BibTeXFormatter();
        BibTeXDatabase db = new BibTeXDatabase();
        for (Citation c : citations) {
            db.addObject(c.getBibTeXEntry());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringWriter sw = new StringWriter();
        btFormatter.format(db, sw);

        return sw.toString();
    }
}
