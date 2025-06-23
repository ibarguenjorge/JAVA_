/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Lote {
    private Long id;
    private Date fechaCreacion;
    private EstadoLote estado; // Enum para los estados
    private List<Madera> maderas;
    private Proceso proceso;
}
