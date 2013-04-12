package ohtu.miniohtu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.List;
import ohtu.miniohtu.citation.Citation;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.LaTeXObject;
import org.jbibtex.LaTeXParser;
import org.jbibtex.LaTeXPrinter;
import org.jbibtex.ParseException;

public class Tools {
   
    public List<LaTeXObject> parseLaTeX(String string) throws IOException, ParseException {
        Reader reader = new StringReader(string);

        try {
            LaTeXParser parser = new LaTeXParser();

            return parser.parse(reader);
        } finally {
            reader.close();
        }
    }

    public String printLaTeX(List<LaTeXObject> objects) {
        LaTeXPrinter printer = new LaTeXPrinter();

        return printer.print(objects);
    }
    
    public BibTeXDatabase parseBibTeX(File file) throws IOException, ParseException {
        Reader reader = new FileReader(file);

        try {
            BibTeXParser parser = new BibTeXParser() {
                @Override
                public void checkStringResolution(Key key, BibTeXString string) {

                    if (string == null) {
                        System.err.println("Unresolved string: \"" + key.getValue() + "\"");
                    }
                }

                @Override
                public void checkCrossReferenceResolution(Key key, BibTeXEntry entry) {

                    if (entry == null) {
                        System.err.println("Unresolved cross-reference: \"" + key.getValue() + "\"");
                    }
                }
            };

            return parser.parse(reader);
        } finally {
            reader.close();
        }
    }
    public void formatBibTeX(BibTeXDatabase database, File file) throws IOException {
        Writer writer = (file != null ? new FileWriter(file) : new OutputStreamWriter(System.out));

        try {
            BibTeXFormatter formatter = new BibTeXFormatter();
            formatter.format(database, writer);
        } finally {
            writer.close();
        }
    }   
}
