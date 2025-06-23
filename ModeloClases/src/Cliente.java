/**
 *
 * @author Jorge Ibargüen
 */

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nombre;
    private String direccion;
    private String contacto;
}
