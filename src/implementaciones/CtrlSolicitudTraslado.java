package implementaciones;

import interfaces.IDatos;
import entidades.Residuo_Transporte;
import entidades.Solicitud_de_Traslado;
import interfaces.ICtrlSolicitudTraslado;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
/**
 * Clase que representa el control de solicitud de traslado.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlSolicitudTraslado implements ICtrlSolicitudTraslado{

    private IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlSolicitudTraslado(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Método que llama a los datos para guardar la solicitud de traslado
     * indicada por el parámetro recibido, devuelve la operación resultante
     *
     * @param solicitudDeTraslado Solicitud de traslado.
     * @return true si la solicitud de traslado se registro con exito, false en
     * caso contrario
     */
    @Override
    public boolean guardarSolicitud(Solicitud_de_Traslado solicitudDeTraslado) {
        return this.datos.guardarSolicitud(solicitudDeTraslado);
    }

    /**
     * Método que llama los datos para consultar las solicitudes que no han sido
     * atendidas
     *
     * @return La lista de solicitudes no atendidas.
     */
    @Override
    public List<Solicitud_de_Traslado> consultarSolicitudesNoAtendidas() {
        return this.datos.consultarSolicitudesNoAtendidas();
    }

    /**
     * Método que llama a los datos para validar la solicitud de traslado
     * ingresada y devolver la operación resultante
     *
     * @param solicitudDeTraslado Solicitud de traslado a validar.
    * @return El mensaje de la validacion.     */
    @Override
    public String validarSolicitud(Solicitud_de_Traslado solicitudDeTraslado) {
        return this.datos.validarSolicitud(solicitudDeTraslado);
    }

    /**
     * Método que llama a los datos para actualiizar la solicitud de traslado,
     * recibe el id de la solicitud de traslado y el residuo a transportar,
     * devuelve la operación resultante
     *
    * @param _idSolicitudTraslado ID de la solicitud de traslado
     * @param residuoTransporte Residuo de transporte a actualizar.
     * @return true si este se actualizo con exito, false en caso contrario.
     */
    @Override
    public boolean actualizarSolicitud(ObjectId _idSolicitudTraslado, Residuo_Transporte residuoTransporte) {
        return this.datos.actualizarSolicitud(_idSolicitudTraslado, residuoTransporte);
    }

    /**
     * Método que llama a los datos para actualizar el traslado que le
     * corresponda al id de solicitud de traslado ingresado, devuelve la
     * operación resultante
     *
   * @param _idSolicitudTraslado ID de la solicitud de traslado a actualizar.
     * @return true si esta se actualizo con exito, false en caso contrario.
     */
    @Override
    public boolean actualizarSolicitudTraslado(ObjectId _idSolicitudTraslado) {
        return this.datos.actualizarSolicitudTraslado(_idSolicitudTraslado);
    }

}
