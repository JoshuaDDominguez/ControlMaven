package org.eclipse.jgit.controlmaven;

import java.io.IOException;
import org.jsoup.Jsoup;
import static org.jsoup.Jsoup.connect;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static sun.util.logging.LoggingSupport.log;

/**
 * Añadimos las dependecias.
 *
 * @author Joshua
 */
public class ControlMaven {

    public static void main(String[] args) throws IOException {
        /**
         * Conectamos con la pagina web.
         */
        try {

            // Conexion
            Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();

            // Mostramos titulo de la pagina
            System.out.println("Titulo de la página: " + doc.title());

            // Recogemos la temperatura y el tiempo.
            Element temperatura = doc.select("div.today_nowcard-temp").first();

            Element descTiempo = doc.select("div.today_nowcard-phrase").first();

            // Mostramos lo el tiempo y la temperatura anteriormente recogidas
            System.out.println("Temperatura: " + temperatura.text());

            System.out.println("Tiempo: " + descTiempo.text());

        } catch (IOException ex) {

            // Mensaje por si sucede algun error.
            System.out.println("Error al conectarse con la pagina web");

        }
    }
}
