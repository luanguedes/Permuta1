package trabalho;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pojo.Produto;

public class Desserelizar {
   
    
    public Desserelizar(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(System.getProperty("user.dir")+"//src//trabalho//Produtos.xml");
            NodeList listaProduto = document.getElementsByTagName("Produto");  
            for(int i = 0; i < listaProduto.getLength(); i++){
                Produto produto = new Produto();
                Node nodeProduto = listaProduto.item(i);
                if(nodeProduto.getNodeType() == Node.ELEMENT_NODE){
                    Element elementoProduto = (Element)nodeProduto;
                    produto.setId(Integer.parseInt(elementoProduto.getAttribute("id")));
                    NodeList listaSubProdutos = elementoProduto.getChildNodes();
                    for(int x = 0; x < listaSubProdutos.getLength(); x++){
                        Node nodeSubProdutos = listaSubProdutos.item(x);
                        if(nodeSubProdutos.getNodeType() == Node.ELEMENT_NODE){
                            Element elementoSubProdutos = (Element)nodeSubProdutos;
                            switch(elementoSubProdutos.getTagName()){
                                case "Nome":
                                   produto.setNome(elementoSubProdutos.getTextContent());
                                   break;
                                case "Preco":
                                   produto.setPreco(Double.parseDouble(elementoSubProdutos.getTextContent()));
                                   break;
                                default:
                                   break;
                            }
                        }
                    }
                }
                Main.prod.add(produto);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Desserelizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Desserelizar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Desserelizar.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }   
    
    
}
