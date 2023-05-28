package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {


}
