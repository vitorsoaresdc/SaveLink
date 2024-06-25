package br.com.savelink.mvc.repositories;

import br.com.savelink.mvc.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
