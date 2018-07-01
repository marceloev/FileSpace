package com.filespace.controller;

import com.filespace.entity.InfUser;
import com.filespace.entity.User;
import com.filespace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserCtrl {

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    private ModelAndView login(@RequestParam(value = "logout", required = false) String logout,
                               @RequestParam(value = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("login");
        if (logout != null) {
            mv.getModelMap().addAttribute("mensagem", "Logout efetuado com sucesso!");
        } else if (error != null) {
            mv.getModelMap().addAttribute("error", "Usuário/Senha inválidos" + error);
        }
        return mv;
    }

    @RequestMapping("/cadastrar")
    private ModelAndView cadastrar(User user, InfUser infUser) {
        ModelAndView mv = new ModelAndView("cadastrar");
        return mv;
    }

    @PostMapping("/cadastrar")
    private ModelAndView salvar(@Valid @ModelAttribute("user") User user,
                                BindingResult resultUser,
                                @Valid @ModelAttribute("infUser") InfUser infUser,
                                BindingResult resultInf,
                                RedirectAttributes attributes) {
        try {
            if (resultInf.hasErrors())
                for (ObjectError error : resultInf.getAllErrors())
                    resultUser.addError(error);
            if (service.countUserByLogin(user.getLogin()) > 0) {
                resultUser.addError(new ObjectError("Login Duplicado",
                        "Já existe um usuário cadastrado para este login"));
                return cadastrar(user, infUser);
            }
            if (resultUser.hasErrors()) {
                return cadastrar(user, infUser);
            }
            user.setLogin(user.getLogin().toUpperCase());
            user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
            service.beginTransaction();
            service.getEntityManager().persist(user);
            infUser.setCodigo(user.getCodigo());
            service.getEntityManager().persist(infUser);
            service.commit();
            ModelAndView mv = new ModelAndView("redirect:/login");
            attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso.");
            return mv;
        } catch (Exception ex) {
            ex.printStackTrace();
            resultUser.addError(new ObjectError("ErroInterno", ex.getMessage()));
            return cadastrar(user, infUser);
        }
    }

    @RequestMapping("/teste")
    private ModelAndView teste() {
        return new ModelAndView("/home");
    }
}
