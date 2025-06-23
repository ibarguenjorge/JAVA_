/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ProductoFinal {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private Date fechaProduccion;
    private Lote lote;
}
