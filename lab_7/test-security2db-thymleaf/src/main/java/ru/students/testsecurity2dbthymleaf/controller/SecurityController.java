package ru.students.testsecurity2dbthymleaf.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.students.testsecurity2dbthymleaf.dto.UserDto;
import ru.students.testsecurity2dbthymleaf.entity.User;
import ru.students.testsecurity2dbthymleaf.repository.UserRepository;
import ru.students.testsecurity2dbthymleaf.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
public class SecurityController {

    private UserService userService;

    @GetMapping(value = "/index")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/register/save")
    public String registration(@Validated @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findByEmail(userDto.getEmail());
        if (existingUser != null && existingUser.getEmail() != null && existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "На этот адрес электронной почты уже зарегистрирована учетная запись");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/login?success";
    }

    @GetMapping(value = "/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "users";
    }

}
