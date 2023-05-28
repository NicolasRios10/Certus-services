package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Dto: permite tansportar datos
//Funcion de esta clase: Si en algun momento el servidor necesita mas espacio este objeto pasasar de la memoria al disco duro y viseversa


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDto {

    private Long id;

    private String descripcion;

    private Boolean estado;
}
