
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {


        String urlIMDB = "https://imdb-api.com/en/API/Top250Movies/k_1v9iq50y";
        String urlNASA = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-30";

        ClienteHttp http = new ClienteHttp();
        String dadosJson = http.buscandoDados(urlNASA);

//        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB;
        ExtratorDeConteudo extrator = new ExtratorDeConteudoNASA();
        
        List<Conteudo> conteudos = extrator.extraindoConteudo(dadosJson);


        GerarFigurinha geradora = new GerarFigurinha();

        for (int i=0; i < 7; i++){

            Conteudo conteudo = conteudos.get(i);


            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = "D:\\PROJETOS PARA GIT-GITHUB\\SPRING\\movies-stickers\\src\\entrada\\img\\saida\\" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }


//        for (Map<String, String> filme: listaDeConteudo) {
//
//            String titulo = filme.get("title");
//            String nomeArquivo = "D:\\PROJETOS PARA GIT-GITHUB\\SPRING\\movies-stickers\\src\\entrada\\img\\saida\\" + titulo + ".png";
//
//            String urlImagem = filme.get("image");
//            InputStream inputStream = new URL(urlImagem).openStream();
//            GerarFigurinha geradora = new GerarFigurinha();
//            geradora.cria(inputStream, nomeArquivo);
//
//            System.out.println(filme.get("title"));
//            System.out.println();
//        }

    }
}