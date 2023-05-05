import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNASA implements ExtratorDeConteudo {

    public List<Conteudo> extraindoConteudo (String dadosJson){

        // Extraindo os dados que interessam( titulo, poster, classificação)
        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeAtributos = parser.parse(dadosJson);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de contudos
        for ( Map<String, String> atributos : listaDeAtributos ) {

            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");

            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }

        return conteudos;

    }

}
