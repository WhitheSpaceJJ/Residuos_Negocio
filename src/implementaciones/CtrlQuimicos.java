package implementaciones;

import entidades.Quimico;
import java.util.List;
import org.bson.types.ObjectId;
/**
 * Clase que representa el control de quimicos.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlQuimicos {

    private IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar 
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlQuimicos(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Llama a los datos para que devuelvan la lista de químicos
     *
     * @return Lista de quimicos del sistema.
     */
    public List<Quimico> getQuimicos() {
        return datos.getQuimicos();
    }

    /**
     * Llama a los datos para que guarden el químico ingresado como parámetro y
     * devuelva la operación resultante
     *
     * @param quimico Quimico a guardar.
     * @return true si el quimico se guardo, false en caso contrario.
     */
    public boolean guardarQuimico(Quimico quimico) {
        return datos.guardarQuimico(quimico);
    }

}
