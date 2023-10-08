package com.project.nasa.repository;

import com.project.nasa.dtos.SkillDTO;
import com.project.nasa.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
