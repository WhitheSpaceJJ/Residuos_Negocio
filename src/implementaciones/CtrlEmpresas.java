/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IDatos;
import entidades.Productora;
import entidades.Transporte;
import entidades.Vehiculo;
import interfaces.ICtrlEmpresas;
import java.util.List;
import org.bson.types.ObjectId;
/**
 * Clase que representa el control de Empresas.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlEmpresas implements ICtrlEmpresas{

    private IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlEmpresas(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Método que devuelve las empresas productoras de los datos
     *
     * @return Lista de la empresa productoras disponibles.
     */
    @Override
    public List<Productora> getEmpresasProductoras() {
        return datos.getEmpresasProductoras();
    }

    /**
     * Método que devuelve las empresas de transporte de los datos
     *
     * @return Lista de las empresas de transporte disponibles.
     */
    @Override
    public List<Transporte> getEmpresasTransportes() {
        return datos.getEmpresasTransportes();
    }

    /**
     * Método que devuelve las empresas productoras de los datos a través de su
     * Id
     *
       * @param _id ID de la empresa productora.
     * @return La empresa productora obtenida.
     */
    @Override
    public Productora getEmpresaProductora(ObjectId _id) {
        return datos.getEmpresaProductora(_id);
    }

    /**
     * Método que devuelve las empresas de transporte de los datos a través de
     * su Id
     *
         * @param _id El id de la empresa de transporte.
     * @return La empresa de transporte obtenida.
     */
    @Override
    public Transporte getEmpresaTransporte(ObjectId _id) {
        return datos.getEmpresaTransporte(_id);
    }

    /**
     * Método que llama a los datos para guardar una empresa productora,
     * devuelve la operación resultante
     *
         * @param productora La empresa productora a guardar.
     * @return true si la empresa empresa productora se guardo con exito, false
     * en caso contrario.
     */
    @Override
    public boolean guardarEmpresaProductora(Productora productora) {
        return datos.guardarEmpresaProductora(productora);
    }

    /**
     * Método que llama a los datos para guardar una empresa de transporte,
     * devuelve la operación resultante
     *
  * @param transporte La empresa de transporte a regisstrar.
     * @return true si la empresa de transporte registrada se guardo con exito,
     * false en caso contrario.
     */
    @Override
    public boolean guardarEmpresaTransporte(Transporte transporte) {
        return datos.guardarEmpresaTransporte(transporte);
    }

    /**
     * Método que llama a los datos para realizar la operación de guardar un
     * vehiculo, devuelve la operación resultante
     *
     * @param vehiculo Vehiculo a guardar.
     * @param transporteEmpresa Empresa transportadora a guardar el vehiculo.
     * @return true si el vehiculo se guardo con exito, false en caso contrario.
     */
    @Override
    public boolean guardarVehiculo(Vehiculo vehiculo, Transporte transporteEmpresa) {
        return datos.guardarVehiculo(vehiculo, transporteEmpresa);
    }
}
