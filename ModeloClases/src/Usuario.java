/**
 *
 * @author Jorge Ibargüen
 */
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String rol;
    private String contraseña;
}
