package trabalho;

import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Serelizar {
    
    public Serelizar(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            
            Element compra = document.createElement("compra");
            Attr id = document.createAttribute("id");
            id.setValue("1");
            
            compra.setAttributeNode(id);
            root.appendChild(compra);
            
            Element produtos = document.createElement("produtos");
            produtos.appendChild(document.createTextNode(Carrinho.getInstance().gerarId()));        
            compra.appendChild(produtos);
            
            Element preco = document.createElement("preco");
            preco.appendChild(document.createTextNode(Double.toString(Carrinho.getInstance().gerarTotal())));
            compra.appendChild(preco);
            
            Element pagamento = document.createElement("pagamento");
            pagamento.appendChild(document.createTextNode(Biblioteca.getInstance().metodoPagamento()));
            compra.appendChild(pagamento);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource documentoFonte = new DOMSource(document);
            StreamResult documentoFinal = new StreamResult(new File(System.getProperty("user.dir")+"//src//xmlCompra//Compra" + gerarRandom() + ".xml"));
            
            transformer.transform(documentoFonte, documentoFinal);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Serelizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Serelizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Serelizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String gerarRandom(){
        Random random = new Random();
        String x = "";
        for (int i = 0; i < 3; i++) {
            x += random.nextInt(10);
        }
        return x;
    }
    
}
