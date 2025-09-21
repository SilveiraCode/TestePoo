package TrabalhoStreaming.demo.Repository;

import TrabalhoStreaming.demo.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    // Buscar por título (contendo) e ordenado
    List<Video> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);

    // Todos os vídeos de uma categoria ordenados por título
    List<Video> findByCategoriaIdOrderByTituloAsc(int categoriaId);

    // Top 10 vídeos mais assistidos
    @Query("SELECT v.video FROM Visualizacao v GROUP BY v.video ORDER BY COUNT(v.video) DESC")
    List<Video> findTop10MaisAssistidos(org.springframework.data.domain.Pageable pageable);
}
