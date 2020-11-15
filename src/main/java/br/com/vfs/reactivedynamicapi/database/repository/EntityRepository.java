package br.com.vfs.reactivedynamicapi.database.repository;

import br.com.vfs.reactivedynamicapi.database.model.EntityDataBase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EntityRepository extends ReactiveCrudRepository<EntityDataBase, String> {
}
