import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FilePractice {

    //desarrollar un programa en Java que, en primer lugar, cree dentro del directorio de trabajo del proyecto una carpeta llamada Datos\Entrada.
    // Una vez creada la carpeta, el programa deberá generar dentro de ella un fichero de texto llamado alumnos.txt.
    // El fichero deberá contener 20 registros de alumnos.
    // Cada registro estará formado por un nombre y una edad, separados por un punto y coma (;).
    // Para generar los nombres, deberéis partir de un array que contenga 6 nombres prefijados y seleccionar aleatoriamente uno de ellos para cada registro.
    // La edad de cada alumno también deberá generarse de forma aleatoria, teniendo que estar comprendida entre 18 y 30 años, ambos incluidos. El contenido del fichero tendrá, por tanto, un formato similar al siguiente: Ana;24 Pedro;19 Laura;27 Carlos;21 Marta;30 Javier;18 ... El fichero deberá contener exactamente 20 líneas, una por cada alumno. El programa deberá: - Crear la carpeta Datos\Entrada dentro del directorio de trabajo. - Crear el fichero alumnos.txt dentro de dicha carpeta. - Utilizar un array predefinido de 5-6 nombres. - Generar aleatoriamente el nombre de cada alumno a partir de ese array. - Generar aleatoriamente una edad entre 18 y 30 años. - Generar un total de 20 alumnos. - Guardar todos los registros en el fichero de texto. - Utilizar el formato nombre;edad, con un alumno por línea. En la clase de mañana veremos como convertir ese fichero de texto en uno de XML utilizando DOM.

    public void crearDirectorio(Path carpeta){
        try{
            if (!Files.exists(carpeta)){
                Files.createDirectories(carpeta);
            }
        } catch (Exception e) {
            System.out.println("[ERROR] al crear directorio" + e.getMessage());
        }
    }

    public void crearArchivo(Path carpeta, Path fichero){
        Path rutaCompleta = carpeta.resolve(fichero);

        if(!Files.exists(rutaCompleta)){
            try{
                Files.createFile(rutaCompleta);
            } catch (Exception e) {
                System.out.println("[ERROR] al crear archivo" + e.getMessage());
            }
        }
    }

    public void escrituraFichero(Path carpeta, Path fichero, ArrayList<String> personas){
        Path rutaCompleta = carpeta.resolve(fichero);
        try {
            for (String persona: personas) {
                Files.writeString(rutaCompleta, persona + ";" + System.lineSeparator(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("[ERROR] en la escritura del ficheros");
        }
    }

}
