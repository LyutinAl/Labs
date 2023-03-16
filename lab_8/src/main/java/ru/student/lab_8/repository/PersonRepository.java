package ru.student.lab_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.student.lab_8.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
