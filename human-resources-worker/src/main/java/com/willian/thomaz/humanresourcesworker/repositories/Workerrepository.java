package com.willian.thomaz.humanresourcesworker.repositories;

import com.willian.thomaz.humanresourcesworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Workerrepository extends JpaRepository<Worker, Long> {
}