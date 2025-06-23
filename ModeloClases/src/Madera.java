/**
 *
 * @author Jorge Ibargüen
 */

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Madera {
    private Long id;
    private String tipoMadera;
    private String especie;
    private Double volumen;
    private Date fechaIngreso;
    private String origen;
    private GuiaTransporte guiaTransporte;
    private Lote lote;
    
    
}

