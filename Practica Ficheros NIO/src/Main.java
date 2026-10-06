import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //LLAMAR A LA CLASE
        FilePractice file = new FilePractice();
        //CREAR LA CARPETA
        Path carpeta = Path.of("src","Datos","Entrada");
        file.crearDirectorio(carpeta);

        //CREAR EL ARCHIVO QUE QUIERO
        Path fichero = Path.of("alumnos.txt");
        file.crearArchivo(carpeta, fichero);

        // ARRAY CON LOS NOMBRES PREFIJADOS
        String[] nombres = {
                "Laura",
                "Pepe",
                "Julio",
                "Bernarda",
                "Cristian",
                "Claudia"
        };

        // CREAR ARRAYLIST DE PERSONAS
        ArrayList<String> listaPersonas = new ArrayList<>();

        // GENERAR 20 ALUMNOS
        for (int i = 0; i < 20; i++) {

            // Elegir nombre aleatorio
            int posicion = (int)(Math.random() * nombres.length);
            String nombre = nombres[posicion];

            // Generar edad entre 18 y 30
            int edad = (int)(Math.random() * 13) + 18;

            listaPersonas.add(nombre + " " + edad);
        }
        
        //CREO LA RUTA COMPLETA DEL ARCHIVO DONDE QUIERO METERLO
        file.escrituraFichero(carpeta, fichero, listaPersonas);
    }
}
