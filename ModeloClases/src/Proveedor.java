/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Proveedor {
    private Long id;
    private String nombre;
    private String direccion;
    private String contacto;
}
