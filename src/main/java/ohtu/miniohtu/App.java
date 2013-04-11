package ohtu.miniohtu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import org.jbibtex.*;

public class App {

    static public void main(String... args) throws Exception {
        Tools tools = new Tools();
        File input = new File("sigproc.bib");

        BibTeXDatabase database = tools.parseBibTeX(input);

        Key key = new Key("title");

        Collection<BibTeXEntry> entries = (database.getEntries()).values();
        for (BibTeXEntry entry : entries) {
            Value value = entry.getField(key);

            // The field is not defined
            if (value == null) {
                continue;
            }

            try {
                String latexString = value.toUserString();
               // System.out.println(latexString);

                List<LaTeXObject> objects = tools.parseLaTeX(latexString);

                String plainTextString = tools.printLaTeX(objects);
                System.out.println(plainTextString);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

            System.out.println();
        }
        BibTeXFormatter bf = new BibTeXFormatter();
        BibTeXDatabase db = new BibTeXDatabase();
        BibTeXEntry bs = new BibTeXEntry(new Key("book"), new Key("666BOOK"));
        bs.addField(BibTeXEntry.KEY_AUTHOR, new KeyValue("jarno kalmari"));
        bs.addField(BibTeXEntry.KEY_BOOKTITLE, new KeyValue("jarno afganistanissa"));
        
        db.addObject(bs);
        bf.format(db, new PrintWriter(System.out));
    }

    
}
