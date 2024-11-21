package org.example.kunuz.repository;

import org.example.kunuz.model.Attach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/attach")
public interface AttachRepo extends JpaRepository<Attach, Integer> {
}
