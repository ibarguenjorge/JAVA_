/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Maquinaria {
    private Long id;
    private String nombre;
    private String tipo;
    private Date fechaMantenimiento;
}
