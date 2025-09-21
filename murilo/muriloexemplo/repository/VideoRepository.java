package com.example.murilo.muriloexemplo.repository;

import com.example.murilo.muriloexemplo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTituloContainingIgnoreCase(String titulo);
    List<Video> findByCategoriaId(int categoriaId);
}
