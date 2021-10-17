package com.willian.thomaz.hrworker.repositories;

import com.willian.thomaz.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
