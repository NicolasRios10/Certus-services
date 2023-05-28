package pe.edu.certus.apps.cursos.pe.edu.certus.apps.cursos.entity;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonPOJOBuilder
@Builder
@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;

    private String descripcion;

    private Boolean estado;
}
