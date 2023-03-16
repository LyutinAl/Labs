package ru.student.lab_8.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.student.lab_8.entity.LogMessage;
import ru.student.lab_8.entity.Person;
import ru.student.lab_8.repository.LogRepository;
import ru.student.lab_8.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;
    private LogRepository logRepository;

    @GetMapping(value = { "/list", "/" })
    public ModelAndView getAllPersons() {
        log.info("/list -> connection");
        logRepository.save(new LogMessage("User with name " + getUserName() +
                "Requested list of all persons"));
        ModelAndView mav = new ModelAndView("list-persons");
        List<Person> persons = personRepository.findAll();
        mav.addObject("persons", persons);
        return mav;
    }

    @GetMapping(value = "/addPersonForm")
    public ModelAndView addPersonForm() {
        logRepository.save(new LogMessage("User with name " + getUserName() +
                "Requested to add a new person"));

        ModelAndView mav = new ModelAndView("add-person-form");
        Person person = new Person();
        mav.addObject("person", person);
        return mav;
    }

    @PostMapping(value = "/savePerson")
    public String savePerson(@ModelAttribute Person person) {
        if (person.getId() != null && personRepository.findById(person.getId()).isPresent()) {
            logRepository.save(new LogMessage("User with name " + getUserName() +
                ". Updated person with id: " + person.getId() +
                " new name: " + person.getName() +
                " new surname: " + person.getSurname() + 
                " new date of birth: " + person.getDateOfBirth() +
                " new country: " + person.getCountry() +
                " new city: " + person.getCity()));
        } else {
            logRepository.save(new LogMessage("User with name " + getUserName() +
                ". Created person with id: " + person.getId() +
                " name: " + person.getName() +
                " surname: " + person.getSurname() + 
                " date of birth: " + person.getDateOfBirth() +
                " country: " + person.getCountry() +
                " city: " + person.getCity()));
        }
        personRepository.save(person);
        return "redirect:/list";
    }

    @GetMapping(value = "/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long personId) {
        ModelAndView mav = new ModelAndView("add-person-form");
        Optional<Person> optionalPerson = personRepository.findById(personId);
        Person person = new Person();
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
            logRepository.save(new LogMessage("User with name " + getUserName() +
                ". Request to update person with id: " + person.getId() +
                " name: " + person.getName() +
                " surname: " + person.getSurname() + 
                " date of birth: " + person.getDateOfBirth() +
                " country: " + person.getCountry() +
                " city: " + person.getCity()));
        }
        mav.addObject("person", person);
        return mav;
    }

    @GetMapping(value = "/deletePerson")
    public String deletePerson(@RequestParam Long personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            logRepository.save(new LogMessage("User with name" + getUserName() +
                    ". Delete person with id: " + personId + 
                    " name: " + person.getName() +
                    " surname: " + person.getSurname() + 
                    " date of birth: " + person.getDateOfBirth() +
                    " country: " + person.getCountry() +
                    " city: " + person.getCity()));
            personRepository.deleteById(personId);
            return "redirect:/list";
        } else {
            throw new IllegalArgumentException("Person with id: " + personId + " not found");
        }
    }

    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return "anonymousUser";
    }
}