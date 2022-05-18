package interfaces;

import entidades.Administrador;
import entidades.Asignacion_Traslado;
import entidades.Empresa;
import entidades.Productor;
import entidades.Productora;
import entidades.Quimico;
import entidades.Residuo;
import entidades.Residuo_Transporte;
import entidades.Solicitud_de_Traslado;
import entidades.Transportador;
import entidades.Transporte;
import entidades.Traslado;
import entidades.Usuario;
import entidades.Vehiculo;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interface para la fachada de Negocio
 */
public interface INegocio {

    /**
     * Obtiene al usuario en base al tipo de usuario, nombre y contraseña
     *
     * @param tipo Tipo de usuario a consultar.
     * @param nombre Nombre de usuario a consultar.
     * @param contraseña Contraseña del usuario a consultar.
     * @return Dependiendo del usuario este lo devolvera si lo encuentra, null
     * en caso contrario.
     */
    public Usuario getUsuario(int tipo, String nombre, String contraseña);

    /**
     * Guarda al usuario en base al tipo de usuario que sea, recibiendo de
     * parámetros el entero que especifique el tipo y el usuario en si
     *
     * @param tipo Tipo de usuario a guardar.
     * @param usuario Usuario a guardar.
     * @return true si el usario se guardo con exito, false en caso contrario.
     */
    public boolean guardarUsuario(int tipo, Usuario usuario);

    /**
     * Obtiene la empresa en base al tipo de empresa que sea y su id
     *
     * @param tipo Tipo de empresa a consultar.
     * @param _id ID de la empresa a consultar.
     * @return La empresa consultada si se obtuvo con exito, null en caso
     * contrario.
     */
    public Empresa getEmpresa(int tipo, ObjectId _id);

    /**
     * Guarda la empresa en base al tipo de empresa que sea, recibiendo de
     * parámetros el entero que especifique el tipo y la empresa en si
     *
     * @param tipo Tipo de empresa a registrar.
     * @param empresa Empresa a registrar.
     * @return true si esta se registro con exito, false en caso contrario.
     */
    public boolean guardarEmpresa(int tipo, Empresa empresa);

    /**
     * Guarda la solicitud de traslado que sea ingresada de parámetro
     *
     * @param solicitudDeTraslado Solicitud de traslado.
     * @return true si la solicitud de traslado se registro con exito, false en
     * caso contrario
     */
    public boolean guardarSolicitud(Solicitud_de_Traslado solicitudDeTraslado);

    /**
     * Consulta una lista de solicitudes que no hayan sido atendidas
     *
     * @return La lista de solicitudes no atendidas.
     */
    public List<Solicitud_de_Traslado> consultarSolicitudesNoAtendidas();

    /**
     * Valida la solicitud de traslado ingresada como parámetro
     *
     * @param solicitudDeTraslado Solicitud de traslado a validar.
    * @return El mensaje de la validacion.     */
    public String validarSolicitud(Solicitud_de_Traslado solicitudDeTraslado);

    /**
     * Actualiza la solicitud de traslado en base al id y el residuo a
     * tranportar especificados en los parámetros
     *
     * @param _idSolicitudTraslado ID de la solicitud de traslado
     * @param residuoTransporte Residuo de transporte a actualizar.
     * @return true si este se actualizo con exito, false en caso contrario.
     */
    public boolean actualizarSolicitud(ObjectId _idSolicitudTraslado, Residuo_Transporte residuoTransporte);

    /**
     * Actualiza la solicitud de traslado especificada en base al id y al
     * residuo a transportar
     *
     * @param _idSolicitudTraslado ID de la solicitud de traslado a actualizar.
     * @return true si esta se actualizo con exito, false en caso contrario.
     */
    public boolean actualizarSolicitudTraslado(ObjectId _idSolicitudTraslado);

    /**
     * Actualiza la solicitud de traslado en base al id especificado como
     * parámetro
     *
     * @param list Lista de asignaciones de traslado a registrar.
     * @return true si estas se registraron con exito, false en caso contraio.
     */
    public boolean guardarAsignacionTraslado(List<Asignacion_Traslado> list);

    /**
     * Consulta las asignaciones de traslados de la empresa de transporte
     * especificada en base a su id
     *
     * @param idEmpresaTransporte ID de la empresa de transporte.
     * @return La lista de las asignaciones de traslado de la empresa de
     * transporte.
     */
    public List<Asignacion_Traslado> consultarAsignacionTrasladosEmpresaT(ObjectId idEmpresaTransporte);

    /**
     * Actualiza la asignación en base al id especificado como parámetro
     *
     * @param _id ID de la asignacion a actualizar.
     * @return true si esta se actualizo con exito, false en caso contrario.
     */
    public boolean actualizarAsignacion(ObjectId _id);

    /**
     * Guarda el traslado ingresado como parámetro
     *
     * @param traslado Traslado a guardar.
     * @return true si el traslado se registro con exito, false en caso
     * contrario.
     */
    public boolean guardarTraslado(Traslado traslado);

    /**
     * Obtiene una lista de químicos
     *
     * @return Lista de quimicos del sistema.
     */
    public List<Quimico> getQuimicos();

    /**
     * Guarda el químico especificado como parámetro
     *
     * @param quimico Quimico a guardar.
     * @return true si el quimico se guardo, false en caso contrario.
     */
    public boolean guardarQuimico(Quimico quimico);

    /**
     * Valida el usuario especificado como parámetro
     *
     * @param nombre Nombre a validar.
     * @return true si existe alguno, false en caso contrario.
     */
    public boolean validarUsuario(String nombre);

    /**
     * Obtiene una lista de empresas productoras
     *
     * @return Lista de la empresa productoras disponibles.
     */
    public List<Productora> getEmpresasProductoras();

    /**
     * Obtiene una lista de empresas de transporte
     *
     * @return Lista de las empresas de transporte disponibles.
     */
    public List<Transporte> getEmpresasTransportes();

    /**
     * Guarda el vehiculo en base al vehiculo especificado y la empresa de
     * transporte dentro de los parámetros
     *
     * @param vehiculo Vehiculo a guardar.
     * @param transporteEmpresa Empresa transportadora a guardar el vehiculo.
     * @return true si el vehiculo se guardo con exito, false en caso contrario.
     */
    public boolean guardarVehiculo(Vehiculo vehiculo, Transporte transporteEmpresa);

    /**
     * Guarda el residuo especificado como parámetro
     *
     * @param residuo Residuo a guadar.
     * @return true si el residuo se registro con exito, false en caso
     * contrario.
     */
    public boolean guardarResiduo(Residuo residuo);

    /**
     * Consulta los residuos hechos por una empresa productora en base al id de
     * dicha empresa
     *
     * @param idEmpresaProductora ID de la empresa productora.
     * @return lista de los residuos de la empresa productora.
     */
    public List<Residuo> consultarResiduosProductor(ObjectId idEmpresaProductora);

    /**
     * Valida el residuo especificado como parámetro
     *
     * @param residuo Residuo a validar.
     * @return Mensaje si el residuo es valido o no.
     */
    public String validarResiduo(Residuo residuo);
}
