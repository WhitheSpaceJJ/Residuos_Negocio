package implementaciones;

import interfaces.IDatos;
import entidades.Administrador;
import entidades.Productor;
import entidades.Transportador;
import interfaces.ICtrlUsuarios;

/**
 * Clase que representa el control de Usuarios.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlUsuarios implements ICtrlUsuarios{

    private final IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlUsuarios(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Llama a los datos para guardar al administrador ingresado como parámetro,
     * devuelve la operación resultante
     *
     * @param administrador Usuario administrador a guardar.
     * @return true si este se guardo con exito, false en caso contrario.
     */
    @Override
    public boolean guardarAdministrador(Administrador administrador) {
        return this.datos.guardarAdministrador(administrador);
    }

    /**
     * Llama a los datos para consultar al administrador por nombre y contraseña
     * ingresados como parámetro, devuelve la operación resultante
     *
     * @param nombre Nombre del usuario a consultar.
     * @param contraseña Contraseña del usuario.
     * @return El usario si este se encontro, null en caso contrario.
     */
    @Override
    public Administrador consultarAdministrador(String nombre, String contraseña) {
        return this.datos.consultarAdministrador(nombre, contraseña);
    }

    /**
     * Llama a los datos para guardar al productor ingresado como parámetro,
     * devuelve la operación resultante Llama a los datos para
     *
     * @param productor Productor a registrar.
     * @return true si el usuario productor se guardo con exito, false en caso
     * contrario
     */
    @Override
    public boolean guardarProductor(Productor productor) {
        return this.datos.guardarProductor(productor);
    }

    /**
     * Llama a los datos para consultar al productor por nombre y contraseña
     * ingresados como parámetro, devuelve la operación resultante
     *
   * @param nombre Nombre del usuario productor a consultar.
     * @param contraseña Contraseña del usuario productor a consultar.
     * @return EL usuario productor si este existe, null en caso contrario.
     */
    @Override
    public Productor consultarProductor(String nombre, String contraseña) {
        return this.datos.consultarProductor(nombre, contraseña);
    }

    /**
     * Llama a los datos para guardar al transportador ingresado como parámetro,
     * devuelve la operación resultante
     *
  * @param transportador Usuario transportador a guardar.
     * @return true si este se guardo con exito, false en caso contrario.
     */
    @Override
    public boolean guardarTransportador(Transportador transportador) {
        return this.datos.guardarTransportador(transportador);
    }

    /**
     * Llama a los datos para consultar al transportador por nombre y contraseña
     * ingresados como parámetro, devuelve la operación resultante
     *
        * @param nombre Nombre del usuario a consultar.
     * @param contraseña Contraseña del usuario.
     * @return El usuario transportado que se obtuvo o null si este no se
     * encontro.
     */
    @Override
    public Transportador consultarTransportador(String nombre, String contraseña) {
        return this.datos.consultarTransportador(nombre, contraseña);
    }

    /**
     * Llama a los datos para validar al usuario ingresado como parámetro,
     * devuelve la operación resultante
     *
    * @param nombre Nombre a validar.
     * @return true si existe alguno, false en caso contrario.
     */
    @Override
    public boolean validarUsuario(String nombre) {
        return this.datos.validarUsuario(nombre);
    }
}
