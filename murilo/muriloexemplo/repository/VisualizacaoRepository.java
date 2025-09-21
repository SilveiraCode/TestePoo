package TrabalhoStreaming.demo.Repository;

import TrabalhoStreaming.demo.Entity.Perfil;
import TrabalhoStreaming.demo.Entity.Visualizacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisualizacaoRepository extends JpaRepository<Visualizacao, Long> {

    // Usuários que mais assistiram
    @Query("SELECT v.perfil FROM Visualizacao v GROUP BY v.perfil ORDER BY COUNT(v) DESC")
    List<Perfil> findPerfisQueMaisAssistiram(Pageable pageable);
}
