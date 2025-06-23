/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class GuiaTransporte {
    private Long id;
    private String numeroGuia;
    private Date fechaEmision;
    private String origen;
    private String destino;
}
