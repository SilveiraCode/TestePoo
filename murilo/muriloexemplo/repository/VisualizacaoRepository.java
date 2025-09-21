package com.example.murilo.muriloexemplo.repository;

import com.example.murilo.muriloexemplo.entity.Visualizacao;
import com.example.murilo.muriloexemplo.entity.Perfil;
import com.example.murilo.muriloexemplo.entity.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisualizacaoRepository extends JpaRepository<Visualizacao, Long> {

    @Query("SELECT v.perfil FROM Visualizacao v GROUP BY v.perfil ORDER BY COUNT(v) DESC")
    List<Perfil> findPerfisQueMaisAssistiram(Pageable pageable);

    @Query("SELECT v.video FROM Visualizacao v GROUP BY v.video ORDER BY COUNT(v) DESC")
    List<Video> findVideosMaisAssistidos(Pageable pageable);
}
