package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.CursoDto;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.ResponseDto;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.entity.CursoEntity;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.repository.CursoRepository;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.service.CursoService;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.util.Constante;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.util.Util;

import java.util.ArrayList;
import java.util.List;



//aqui se configuran e implementan las configuraciones conplejas e internas de las funciones creadas en el controller

@Slf4j
@Service
public class CursoServicelmpl implements CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public ResponseDto getAllCurso() {
        try {
            List<CursoEntity> listCursoEntity = cursoRepository.findAll();
            if(listCursoEntity.isEmpty()) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<CursoDto> list = new ArrayList<CursoDto>();
            for (CursoEntity cursoEntity : listCursoEntity) {
                list.add(CursoDto.builder()
                        .id(cursoEntity.getId())
                        .descripcion(cursoEntity.getDescripcion())
                        .estado(cursoEntity.getEstado())
                        .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }

    }

    @Override
    public ResponseDto getCurso(Long id) {
        try {
            CursoEntity cursoEntity = cursoRepository.findById(id).orElse(null);
            if(null == cursoEntity) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            CursoDto cursoDto = CursoDto.builder()
                    .id(cursoEntity.getId())
                    .descripcion(cursoEntity.getDescripcion())
                    .estado(cursoEntity.getEstado())
                    .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, cursoDto);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createCurso(CursoDto curso) {
        try {
            CursoEntity cursoEntity = CursoEntity.builder()
                    .descripcion(curso.getDescripcion())
                    .estado(true)
                    .build();
            cursoRepository.save(cursoEntity);
            curso.setId(cursoEntity.getId());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, curso);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }

    }

    @Override
    public ResponseDto updateCurso(CursoDto curso) {
        try {
            CursoEntity cursoEntity = cursoRepository.findById(curso.getId()).orElse(null);
            if(null == cursoEntity) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            cursoEntity.setDescripcion(curso.getDescripcion());
            cursoRepository.save(cursoEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, curso);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto deleteCurso(Long id) {
        try {
            CursoEntity cursoEntity = cursoRepository.findById(id).orElse(null);
            cursoEntity.setEstado(false);
            cursoRepository.save(cursoEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch (Exception e) {
            log.error(Constante.OPERATION_FAILED, e);
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
    
    
}
