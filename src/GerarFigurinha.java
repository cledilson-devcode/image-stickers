import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class GerarFigurinha {

    

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
        try {

            BufferedImage imagemOriginal = ImageIO.read(inputStream);

            // criar uma nova imagem em memória com transparência e com tamanho novo
            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();
            int novaAltura = altura + 50;
            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

            // copiar a imagem original para nova imagem (em memória)
            Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            graphics.drawImage(imagemOriginal, 0, 0, null);

            // configurar a fonte da frase
            Font fonte = new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 24);
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.setFont(fonte);
            // Escrever uma frase na imagem
            graphics.drawString("( ͡` ͜ʖ ͡´)", 16, novaAltura - 15);


            // escrever a nova imagem em um arquivo

            ImageIO.write(novaImagem, "png", new File(nomeArquivo));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de imagem: " + e.getMessage());
        }
    }




}
