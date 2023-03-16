package ru.student.lab_8.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ru.student.lab_8.entity.LogMessage;



public interface LogRepository extends JpaRepository<LogMessage, Long> {
    
}