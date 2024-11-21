package org.example.kunuz.repository;

import org.example.kunuz.model.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/emailhistory")
public interface EmailHistoryRepo extends JpaRepository<EmailHistory, Integer> {
}
