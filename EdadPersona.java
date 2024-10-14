package EdadPersona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class EdadPersona {

    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");


    public static <T> int calcularEdad(String fechaNacimiento) throws Exception{

        Date fechaActual = new Date();

        Date fechaNacimientoFormateada;

        try {
            fechaNacimientoFormateada = new EdadPersona().darFormatoFechaNacimiento(fechaNacimiento);

            long diferenciaMilise = Math.abs(fechaActual.getTime() - fechaNacimientoFormateada.getTime());
            long differenciaDias = TimeUnit.DAYS.convert(diferenciaMilise, MILLISECONDS);

            return (int) (differenciaDias / 365);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private  <T> Date darFormatoFechaNacimiento(String fechaNacimiento) throws Exception {
        try {
            return formatoFecha.parse(fechaNacimiento);
        } catch (ParseException | ClassCastException e) {
            throw new Exception("Error al convertir la fecha");
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println(calcularEdad("28/07/2003"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
