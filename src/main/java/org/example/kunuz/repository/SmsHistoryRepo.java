package org.example.kunuz.repository;

import org.example.kunuz.model.SmsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/smshistory")
public interface SmsHistoryRepo extends JpaRepository<SmsHistory, Integer> {
}
