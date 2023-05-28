package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.ResponseDto;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.dto.CursoDto;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.service.CursoService;


//Es donde se establecen las funciones o comandos del servicio

@RestController
@RequestMapping("/v1/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //API: Interfaz de Programación de Aplicaciones
    @ApiOperation(value = "Método para listar todos cursos")
    @GetMapping
    public ResponseEntity<ResponseDto> readAllCurso(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllCurso());
    }

    @ApiOperation(value = "Método para obtener curso por su id.")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> readCurso(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCurso(id));
    }

    @ApiOperation(value = "Método para crear curso")
    @PostMapping
    public ResponseEntity<ResponseDto> createCurso(@RequestBody CursoDto curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(curso));
    }

    @ApiOperation(value = "Método para actualizar curso")
    @PutMapping
    public ResponseEntity<ResponseDto> updateCurso(@RequestBody CursoDto curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.updateCurso(curso));
    }

    @ApiOperation(value = "Método para eliminar curso por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCurso(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.deleteCurso(id));
    }
    
}
