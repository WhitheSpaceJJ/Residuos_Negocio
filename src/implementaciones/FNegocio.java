package implementaciones;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Fachada para Negocios
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class FNegocio implements INegocio {

    private CtrlEmpresas ctrlEmpresas;
    private CtrlUsuarios ctrlUsuarios;
    private CtrlAsignacionTraslado ctrlAsignacionTraslado;
    private CtrlQuimicos ctrlQuimicos;
    private CtrlResiduos ctrlResiduos;
    private CtrlSolicitudTraslado ctrlSolicitudTraslado;
    private CtrlTraslado ctrlTraslado;
    private final IDatos datos = FabricaDatos.crearFDatos();

    /**
     * Clase que sirve para crear un control de Asignación Traslado, lo devuelve
     * en caso de que ya exista, en caso de que no exista crea uno nuevo y lo
     * devuelve
     *
     * @return Instancia de la clase CtrlAsignacionTraslado
     */
    public CtrlAsignacionTraslado crearCtrlAsignacionTraslado() {
        if (ctrlAsignacionTraslado != null) {
            return ctrlAsignacionTraslado;
        } else {
            this.ctrlAsignacionTraslado = new CtrlAsignacionTraslado(datos);
            return ctrlAsignacionTraslado;
        }
    }

    /**
     * Clase que sirve para crear un control de empresas, lo devuelve en caso de
     * que ya exista, en caso de que no exista crea uno nuevo y lo devuelve
     *
     * @return Instancia de la clase CtrlEmpresas
     */
    public CtrlEmpresas crearCtrlEmpresas() {
        if (ctrlEmpresas != null) {
            return ctrlEmpresas;
        } else {
            this.ctrlEmpresas = new CtrlEmpresas(datos);
            return ctrlEmpresas;
        }
    }

    /**
     * Clase que sirve para crear un control de químicos, lo devuelve en caso de
     * que ya exista, en caso de que no exista crea uno nuevo y lo devuelve
     *
     * @return Instancia de la clase CtrlQuimicos
     */
    public CtrlQuimicos crearCtrlQuimicos() {
        if (ctrlQuimicos != null) {
            return ctrlQuimicos;
        } else {
            this.ctrlQuimicos = new CtrlQuimicos(datos);
            return ctrlQuimicos;
        }
    }

    /**
     * Clase que sirve para crear un control de residuos, lo devuelve en caso de
     * que ya exista, en caso de que no exista crea uno nuevo y lo devuelve
     *
     * @return Instancia de la clase CtrlResiduos
     */
    public CtrlResiduos crearCtrlResiduos() {
        if (ctrlResiduos != null) {
            return ctrlResiduos;
        } else {
            this.ctrlResiduos = new CtrlResiduos(datos);
            return ctrlResiduos;
        }
    }

    /**
     * Clase que sirve para crear un control de solicitud de traslado, lo
     * devuelve en caso de que ya exista, en caso de que no exista crea uno
     * nuevo y lo devuelve
     *
     * @return Instancia de la clase CtrlSolicitudTraslado
     */
    public CtrlSolicitudTraslado crearCtrlSolicitudTraslado() {
        if (ctrlSolicitudTraslado != null) {
            return ctrlSolicitudTraslado;
        } else {
            this.ctrlSolicitudTraslado = new CtrlSolicitudTraslado(datos);
            return ctrlSolicitudTraslado;
        }
    }

    /**
     * Clase que sirve para crear un control de traslado, lo devuelve en caso de
     * que ya exista, en caso de que no exista crea uno nuevo y lo devuelve
     *
     * @return Instancia de la clase CtrlTraslado
     */
    public CtrlTraslado crearCtrlTraslado() {
        if (ctrlTraslado != null) {
            return ctrlTraslado;
        } else {
            this.ctrlTraslado = new CtrlTraslado(datos);
            return ctrlTraslado;
        }
    }

    /**
     * Clase que sirve para crear un control de usuarios, lo devuelve en caso de
     * que ya exista, en caso de que no exista crea uno nuevo y lo devuelve
     *
     * @return Instancia de la clase CtrlUsuarios
     */
    public CtrlUsuarios crearCtrlUsuarios() {
        if (ctrlUsuarios != null) {
            return ctrlUsuarios;
        } else {
            this.ctrlUsuarios = new CtrlUsuarios(datos);
            return ctrlUsuarios;
        }
    }

    /**
     * Recibe un entero que represente el tipo de usuario, el nombre y la
     * contraseña del usuario, hace una comparación en el cual dependiendo del
     * entero ingresado como parámetro va a consultar a un administrador,
     * transportador o productor.
     *
     * @param tipo Tipo de usuario a consultar.
     * @param nombre Nombre de usuario a consultar.
     * @param contraseña Contraseña del usuario a consultar.
     * @return Dependiendo del usuario este lo devolvera si lo encuentra, null
     * en caso contrario.
     */
    @Override
    public Usuario getUsuario(int tipo, String nombre, String contraseña) {
        if (tipo == 1) {
            return this.crearCtrlUsuarios().consultarAdministrador(nombre, contraseña);
        }
        if (tipo == 2) {
            return this.crearCtrlUsuarios().consultarTransportador(nombre, contraseña);

        }
        if (tipo == 3) {
            return this.crearCtrlUsuarios().consultarProductor(nombre, contraseña);
        }
        return null;
    }

    /**
     * Recibe de parámetro un entero que represente el tipo de usuario y el
     * usuario como tal, dependiendo del entero ingresado como parámetro va a
     * guardar a un administrador, transportador o productor
     *
     * @param tipo Tipo de usuario a guardar.
     * @param usuario Usuario a guardar.
     * @return true si el usario se guardo con exito, false en caso contrario.
     */
    @Override
    public boolean guardarUsuario(int tipo, Usuario usuario) {
        if (tipo == 1) {
            return this.crearCtrlUsuarios().guardarAdministrador((Administrador) usuario);
        } else if (tipo == 2) {
            return this.crearCtrlUsuarios().guardarTransportador((Transportador) usuario);
        }
        return tipo == 3 ? this.crearCtrlUsuarios().guardarProductor((Productor) usuario) : false;
    }

    /**
     * Recibe de parámetro el nombre del usuario y llama al método validar
     * usuario para que realice las validaciones correspondientes
     *
     * @param nombre Nombre a validar.
     * @return true si existe alguno, false en caso contrario.
     */
    @Override
    public boolean validarUsuario(String nombre) {
        return this.crearCtrlUsuarios().validarUsuario(nombre);
    }

    /**
     * Devuelve la lista de químicos
     *
     * @return Lista de quimicos del sistema.
     */
    @Override
    public List<Quimico> getQuimicos() {
        return this.crearCtrlQuimicos().getQuimicos();
    }

    /**
     * Recibe un químico de parámetro y se encarga de guardarlo
     *
     * @param quimico Quimico a guardar.
     * @return true si el quimico se guardo, false en caso contrario.
     */
    @Override
    public boolean guardarQuimico(Quimico quimico) {
        return this.crearCtrlQuimicos().guardarQuimico(quimico);
    }

    /**
     * Recibe de parámetro un entero que represente el tipo de empresa y el id a
     * consultar, dependiendo del entero que sea enviado como parámetro
     * consultara a una empresa productora, transportadora o nulo
     *
     * @param tipo Tipo de empresa a consultar.
     * @param _id ID de la empresa a consultar.
     * @return La empresa consultada si se obtuvo con exito, null en caso
     * contrario.
     */
    @Override
    public Empresa getEmpresa(int tipo, ObjectId _id) {
        if (tipo == 1) {
            return this.crearCtrlEmpresas().getEmpresaProductora(_id);
        }
        return tipo == 3 ? this.crearCtrlEmpresas().getEmpresaTransporte(_id) : null;
    }

    /**
     * Recibe de parámetro un entero que represente el tipo de la empresa y la
     * empresa como tal, dependiendo del entero ingresado guardará una empresa
     * productora o de transporte
     *
     * @param tipo Tipo de empresa a registrar.
     * @param empresa Empresa a registrar.
     * @return true si esta se registro con exito, false en caso contrario.
     */
    @Override
    public boolean guardarEmpresa(int tipo, Empresa empresa) {
        if (tipo == 1) {
            return this.crearCtrlEmpresas().guardarEmpresaProductora((Productora) empresa);
        }
        return tipo == 3 ? this.crearCtrlEmpresas().guardarEmpresaTransporte((Transporte) empresa) : false;
    }

    /**
     * Devuelve la lista de empresas productoras
     *
     * @return Lista de la empresa productoras disponibles.
     */
    @Override
    public List<Productora> getEmpresasProductoras() {
        return this.crearCtrlEmpresas().getEmpresasProductoras();
    }

    /**
     * Devuelve la lista de empresas de transporte
     *
     * @return Lista de las empresas de transporte disponibles.
     */
    @Override
    public List<Transporte> getEmpresasTransportes() {
        return this.crearCtrlEmpresas().getEmpresasTransportes();
    }

    /**
     * Guarda el residuo ingresado como parámetro
     *
     * @param residuo Residuo a guadar.
     * @return true si el residuo se registro con exito, false en caso
     * contrario.
     */
    @Override
    public boolean guardarResiduo(Residuo residuo) {
        return this.crearCtrlResiduos().guardarResiduo(residuo);
    }

    /**
     * Consulta la lista de residuos en base al id del productor ingresado, si
     * encuentra algo lo devuelve, si no encuentra nada devuelve nulo
     *
     * @param _idProductor ID de la empresa productora.
     * @return lista de los residuos de la empresa productora.
     */
    @Override
    public List<Residuo> consultarResiduosProductor(ObjectId _idProductor) {
        List<Residuo> residuos = this.crearCtrlResiduos().consultarResiduosProductor(_idProductor);
        if (!residuos.isEmpty()) {
            return residuos;
        } else {
            return null;
        }
    }

    /**
     * Manda a validar el residuo ingresado como parámetro
     *
     * @param residuo Residuo a validar.
     * @return Mensaje si el residuo es valido o no.
     */
    @Override
    public String validarResiduo(Residuo residuo) {
        return this.crearCtrlResiduos().validarResiduo(residuo);
    }

    /**
     * Manda a guardar la solicitud de traslado ingresada como parámetro
     *
     * @param solicitudDeTraslado Solicitud de traslado.
     * @return true si la solicitud de traslado se registro con exito, false en
     * caso contrario
     */
    @Override
    public boolean guardarSolicitud(Solicitud_de_Traslado solicitudDeTraslado) {
        return this.crearCtrlSolicitudTraslado().guardarSolicitud(solicitudDeTraslado);
    }

    /**
     * Manda a consultar las solicitudes no atendidas, en caso de que no haya
     * ninguna manda una lista nueva, si no, manda la lista de solicitudes no
     * atendidas
     *
     * @return La lista de solicitudes no atendidas.
     */
    @Override
    public List<Solicitud_de_Traslado> consultarSolicitudesNoAtendidas() {
        List<Solicitud_de_Traslado> solicitudesTraslado = this.crearCtrlSolicitudTraslado().consultarSolicitudesNoAtendidas();
        if (solicitudesTraslado.isEmpty()) {
            return new ArrayList<>();
        } else {
            return solicitudesTraslado;
        }
    }

    /**
     * Manda a validar la solicitud ingresada como parámetro
     *
     * @param solicitudDeTraslado Solicitud de traslado a validar.
    * @return El mensaje de la validacion.     */
    @Override
    public String validarSolicitud(Solicitud_de_Traslado solicitudDeTraslado) {
        return this.crearCtrlSolicitudTraslado().validarSolicitud(solicitudDeTraslado);
    }

    /**
     * Manda a actualizar la solicitud con el id y el residuo a transportar como
     * parámetros
     *
     * @param _idSolicitudTraslado ID de la solicitud de traslado
     * @param residuoTransporte Residuo de transporte a actualizar.
     * @return true si este se actualizo con exito, false en caso contrario.
     */
    @Override
    public boolean actualizarSolicitud(ObjectId _idSolicitudTraslado, Residuo_Transporte residuoTransporte) {
        return this.crearCtrlSolicitudTraslado().actualizarSolicitud(_idSolicitudTraslado, residuoTransporte);
    }

    /**
     * Manda a actualizar la solicitud de traslado con el id de la solicitud de
     * traslado como parámetro
     *
     * @param _idSolicitudTraslado ID de la solicitud de traslado a actualizar.
     * @return true si esta se actualizo con exito, false en caso contrario.
     */
    @Override
    public boolean actualizarSolicitudTraslado(ObjectId _idSolicitudTraslado) {
        return this.crearCtrlSolicitudTraslado().actualizarSolicitudTraslado(_idSolicitudTraslado);
    }

    /**
     * Manda a guardar el traslado ingresado como parámetro
     *
     * @param traslado Traslado a guardar.
     * @return true si el traslado se registro con exito, false en caso
     * contrario.
     */
    @Override
    public boolean guardarTraslado(Traslado traslado) {
        return this.crearCtrlTraslado().guardarTraslado(traslado);
    }

    /**
     * Manda a guardar la lista de asignación de traslado ingresada como
     * parámetro
     *
     * @param list Lista de asignaciones de traslado a registrar.
     * @return true si estas se registraron con exito, false en caso contraio.
     */
    @Override
    public boolean guardarAsignacionTraslado(List<Asignacion_Traslado> list) {
        return this.crearCtrlAsignacionTraslado().guardarAsignacionTraslado(list);
    }

    /**
     * Manda a actualizar la asignación por medio del id ingresado como
     * parámetro
     *
       * @param _id ID de la asignacion a actualizar.
     * @return true si esta se actualizo con exito, false en caso contrario.
     */
    @Override
    public boolean actualizarAsignacion(ObjectId _id) {
        return this.crearCtrlAsignacionTraslado().actualizarAsignacion(_id);
    }

    /**
     * Manda a consultar las asignaciones de traslados de la empresa de
     * transporte en base a la id ingresada como parámetro, en caso de que las
     * encuentre, las devuelve en una lista, si no encuentra nada devuelve una
     * lista nueva
       * @param idEmpresaTransporte ID de la empresa de transporte.
     * @return La lista de las asignaciones de traslado de la empresa de
     * transporte.
     */
    @Override
    public List<Asignacion_Traslado> consultarAsignacionTrasladosEmpresaT(ObjectId idEmpresaTransporte) {
        List<Asignacion_Traslado> lista = this.crearCtrlAsignacionTraslado().consultarAsignacionTrasladosEmpresaT(idEmpresaTransporte);
        if (lista.isEmpty()) {
            return new ArrayList<>();
        } else {
            return lista;
        }
    }

    /**
     * Manda a guardar el vehiculo junto con la empresa de transporte que lo
     * tiene
     *
   * @param vehiculo Vehiculo a guardar.
     * @param transporteEmpresa Empresa transportadora a guardar el vehiculo.
     * @return true si el vehiculo se guardo con exito, false en caso contrario.
     */
    @Override
    public boolean guardarVehiculo(Vehiculo vehiculo, Transporte transporteEmpresa) {
        return this.crearCtrlEmpresas().guardarVehiculo(vehiculo, transporteEmpresa);
    }

}
