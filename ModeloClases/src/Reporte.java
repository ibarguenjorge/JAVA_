/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Reporte {
    private Long id;
    private TipoReporte tipoReporte; // Enum para los tipos de reporte
    private Date fechaGeneracion;
    private Usuario usuario;
    // ... otros atributos según el tipo de reporte
}
