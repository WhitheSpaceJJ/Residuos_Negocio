package implementaciones;

import interfaces.IDatos;
import entidades.Residuo;
import interfaces.ICtrlResiduos;
import java.util.List;
import org.bson.types.ObjectId;
/**
 * Clase que representa el control de residuos.
 *
 * @author Equipo 1 Jose,Abraham y Oroz
 */
public class CtrlResiduos implements ICtrlResiduos{

    private IDatos datos;

    /**
     * Constructor que inicializa los datos para que la clase se pueda comunicar
     * con los repositorios de datos
     *
     * @param datos Fachada de datos
     */
    public CtrlResiduos(IDatos datos) {
        this.datos = datos;
    }

    /**
     * Llama a los datos para poder guardar el residuo ingresado como parámetro
     * y devolver la operación resultante
     *
      * @param residuo Residuo a guadar.
     * @return true si el residuo se registro con exito, false en caso
     * contrario.
     */
    @Override
    public boolean guardarResiduo(Residuo residuo) {
        return this.datos.guardarResiduo(residuo);
    }

    /**
     * Llama a los datos para poder consultar los residuos en base a la empresa
     * productora y devolver la operación resultante
     *
   * @param idEmpresaProductora ID de la empresa productora.
     * @return lista de los residuos de la empresa productora.
     */
    @Override
    public List<Residuo> consultarResiduosProductor(ObjectId idEmpresaProductora) {
        return this.datos.consultarResiduosProductor(idEmpresaProductora);
    }

    /**
     * Llama a los datos para realizar la validación del residuo que fue
     * ingresado como parámetro y devolver la operación resultante
     *
   * @param residuo Residuo a validar.
     * @return Mensaje si el residuo es valido o no.
     */
    @Override
    public String validarResiduo(Residuo residuo) {
        return this.datos.validarResiduo(residuo);
    }

}
