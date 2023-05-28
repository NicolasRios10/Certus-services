package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String codigo;
    private String mensaje;
    private Object data;

}
