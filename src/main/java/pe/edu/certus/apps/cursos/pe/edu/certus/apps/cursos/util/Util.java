package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.util;

import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.ResponseDto;



//la carpeta util contiene clases y componentes que brindan funcionalidades y
// utilidades genéricas que pueden ser utilizadas en diferentes partes de la aplicación.


public class Util {

    public static ResponseDto getResponse(boolean success, String mensaje, Object data) {
        ResponseDto response = new ResponseDto();
        String cod = (!success) ? Constante.CODE_FAILED : Constante.CODE_SUCCES;
        response.setCodigo(cod);
        response.setMensaje(mensaje);
        response.setData(data);
        return response;
    }
}
