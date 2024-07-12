package com.org.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.ResumeBuilder;

@Repository
public interface ResumeBuilderRepository extends JpaRepository<ResumeBuilder, Long> {

}
