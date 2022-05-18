package implementaciones;

import interfaces.IDatos;
import entidades.Asignacion_Traslado;
import interfaces.ICtrlAsignacionTraslado;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa el control de asignaciones de traslados.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlAsignacionTraslado implements ICtrlAsignacionTraslado{

    private IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlAsignacionTraslado(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Método que llama a los datos para realizar la operación de guardar la
     * asignación de traslado mandandole una lista con estos mismos, devuelve la
     * operación resultante
     *
     * @param list Lista de asignaciones de traslado a registrar.
     * @return true si estas se registraron con exito, false en caso contrario.
     */
    @Override
    public boolean guardarAsignacionTraslado(List<Asignacion_Traslado> list) {
        return this.datos.guardarAsignacionTraslado(list);
    }

    /**
     * Método que recibe el id de una empresa productora para llamar a los datos
     * para que consulten todas las asignaciones de traslados que tiene esa
     * empresa, devuelve la operación resultante
     *
     * @param idEmpresaProductora ID de la empresa de transporte.
     * @return La lista de las asignaciones de traslado de la empresa de
     * transporte.
     */
    @Override
    public List<Asignacion_Traslado> consultarAsignacionTrasladosEmpresaT(ObjectId idEmpresaProductora) {
        return this.datos.consultarAsignacionTrasladosEmpresaT(idEmpresaProductora);
    }

    /**
     * Método que recibe un Id y llama a los datos para que actualicen la
     * asignación que contiene dicho Id, devuelve la operación resultante
     *
      * @param _id ID de la asignacion a actualizar.
     * @return true si esta se actualizo con exito, false en caso contrario.
     */
    @Override
    public boolean actualizarAsignacion(ObjectId _id) {
        return this.datos.actualizarAsignacion(_id);
    }
}
