package implementaciones;

import interfaces.IDatos;
import entidades.Traslado;
import interfaces.ICtrlTraslado;
import org.bson.types.ObjectId;
/**
 * Clase que representa el control de traslados.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlTraslado implements ICtrlTraslado{

    private IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlTraslado(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Llama a los datos para guardar el traslado ingresado como parámetro,
     * devuelve la operación resultante
     *
     * @param traslado Traslado a guardar.
     * @return true si el traslado se registro con exito, false en caso
     * contrario.
     */
    @Override
    public boolean guardarTraslado(Traslado traslado) {
        return datos.guardarTraslado(traslado);
    }
}
