package com.example.murilo.muriloexemplo;

import com.example.murilo.muriloexemplo.entity.Perfil;
import com.example.murilo.muriloexemplo.entity.Video;
import com.example.murilo.muriloexemplo.entity.Visualizacao;
import com.example.murilo.muriloexemplo.repository.PerfilRepository;
import com.example.murilo.muriloexemplo.repository.VideoRepository;
import com.example.murilo.muriloexemplo.repository.VisualizacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

@SpringBootApplication
public class StreamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            PerfilRepository perfilRepo,
            VideoRepository videoRepo,
            VisualizacaoRepository visuRepo
    ) {
        return (args) -> {
            // Criar perfis
            Perfil p1 = new Perfil();
            p1.setNome("Murilo");
            perfilRepo.save(p1);

            Perfil p2 = new Perfil();
            p2.setNome("Natan");
            perfilRepo.save(p2);

            // Criar vídeos
            Video v1 = new Video();
            v1.setTitulo("Aprendendo Spring Boot");
            v1.setDescricao("Curso introdutório de Spring Boot");
            v1.setDuracao(1200);
            v1.setCategoriaId(1); // Supondo que você tenha uma tabela de categorias
            videoRepo.save(v1);

            Video v2 = new Video();
            v2.setTitulo("Top 10 Gols de 2025");
            v2.setDescricao("Melhores gols do ano");
            v2.setDuracao(600);
            v2.setCategoriaId(2);
            videoRepo.save(v2);

            // Criar visualizações
            Visualizacao vis1 = new Visualizacao();
            vis1.setVideo(v1);
            vis1.setPerfil(p1);
            vis1.setProgresso(100);
            vis1.setDataHora(LocalDateTime.now());
            visuRepo.save(vis1);

            Visualizacao vis2 = new Visualizacao();
            vis2.setVideo(v1);
            vis2.setPerfil(p2);
            vis2.setProgresso(50);
            vis2.setDataHora(LocalDateTime.now());
            visuRepo.save(vis2);

            Visualizacao vis3 = new Visualizacao();
            vis3.setVideo(v2);
            vis3.setPerfil(p1);
            vis3.setProgresso(80);
            vis3.setDataHora(LocalDateTime.now());
            visuRepo.save(vis3);

            System.out.println("✅ Dados de teste inseridos!");

            // Consulta: perfil que mais assistiu
            System.out.println("\n👤 Perfil que mais assistiu:");
            visuRepo.findPerfisQueMaisAssistiram(PageRequest.of(0, 1))
                    .forEach(perfil -> System.out.println(perfil.getNome()));

            // Consulta: vídeo mais assistido
            System.out.println("\n🎬 Vídeo mais assistido:");
            visuRepo.findVideosMaisAssistidos(PageRequest.of(0, 1))
                    .forEach(video -> System.out.println(video.getTitulo()));
        };
    }
}



