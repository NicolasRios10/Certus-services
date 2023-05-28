package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.service;


import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.CursoDto;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.ResponseDto;

public interface CursoService {

    //CRUD: C=CREATE, R=READ, U=UPDATE, D=DELETE
    public ResponseDto getAllCurso();
    public ResponseDto getCurso(Long id);
    public ResponseDto createCurso(CursoDto curso);
    public ResponseDto updateCurso(CursoDto curso);
    public ResponseDto deleteCurso(Long id);

}
