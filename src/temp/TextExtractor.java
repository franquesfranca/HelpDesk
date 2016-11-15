package temp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.jsoup.Jsoup;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class TextExtractor extends HTMLEditorKit.ParserCallback {
 
    private StringBuilder s;
 
    public TextExtractor() {
    }
 
   public String parse(String texto) throws Exception {
    byte[] dados = texto.getBytes();
    ByteArrayInputStream bais = new ByteArrayInputStream(dados);
    Reader reader = new InputStreamReader(bais);
    return parse(reader); 
    }
 
    public String parse(Reader in) throws IOException {
        s = new StringBuilder();
        ParserDelegator delegator = new ParserDelegator();
        delegator.parse(in, this, Boolean.TRUE);
        return getText();
    }
 
    @Override
    public void handleText(char[] text, int pos) {
        s.append(text);
        s.append("\n");
    }
 
    public String getText() {
        return Jsoup.parse(s.toString()).text();
    }
}



