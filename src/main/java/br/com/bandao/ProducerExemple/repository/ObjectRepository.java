package br.com.bandao.ProducerExemple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bandao.ProducerExemple.model.ObjectMessage;

public interface ObjectRepository extends JpaRepository<ObjectMessage, Long> {
}
