package az.itcity.bina.controller;

import az.itcity.bina.config.BinaConfiguration;
import az.itcity.bina.domain.UserRegistrationForm;
import az.itcity.bina.validator.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/")
public class IndexController {

    @Value("${bina.baseUrl}")
    private String baseUrl;

    @Value("${bina.registerUrl}")
    private String registerUrl;

    @Autowired
    BinaConfiguration configuration;


//    @Autowired
//    private UserRegistrationFormValidator registrationFormValidator;
//
//    @InitBinder
//    public void dataBind(WebDataBinder dataBinder) {
//        if (dataBinder.getTarget() != null
//                && dataBinder.getTarget().getClass().equals(UserRegistrationForm.class)) {
//            dataBinder.setValidator(registrationFormValidator);
//        }
//    }

//    @GetMapping("/")
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
//        System.out.println("base url = " + baseUrl);
        System.out.println("base url = " + configuration.getBaseUrl());  // or from configuration
//        System.out.println("register url = " + registerUrl);
        System.out.println("register url = " + configuration.getRegisterUrl()); // or from configuration
        System.out.println("configuration = " + configuration);
        return "index";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    // MVC - Model View Controller
    @GetMapping("/hello-new")
    public ModelAndView sayHello2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello2");
        modelAndView.addObject("name", "Ramin");
        return modelAndView;
    }

    @GetMapping("/table")
    public String showTableForm() {
        return "table";
    }

//    @PostMapping("/table")
    @RequestMapping(path = "/table", method = RequestMethod.POST)
//    public ModelAndView generateTable(HttpServletRequest request) {
    public ModelAndView generateTable(
            @RequestParam(name = "row") int row,
            @RequestParam(name = "column") int column
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("generate-table");
        modelAndView.addObject("row", row);
        modelAndView.addObject("column", column);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView registrationPage() {
        ModelAndView mav = new ModelAndView("register");
        UserRegistrationForm form = new UserRegistrationForm();
        form.setName("Ali");
        form.setSurname("Mammadov");
        mav.addObject("userRegistrationForm", form);
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView completeRegistration(
//            @Validated @ModelAttribute("userRegistrationForm") UserRegistrationForm registrationForm,
            @Valid @ModelAttribute("userRegistrationForm") UserRegistrationForm registrationForm,
                                              BindingResult errors) {

        System.out.println("form = " + registrationForm);

        ModelAndView mav = new ModelAndView();

        if(errors.hasErrors()) {
            mav.setViewName("register");
            System.out.println("formda xetalar var, sayi =  " + errors.getErrorCount());
            errors.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + Arrays.toString(objectError.getCodes()));
            });
        } else {
            mav.setViewName("register-success");
            System.out.println("formda xeta yoxdur, qeydiyyati tamamlamaq olar");
        }

        return mav;
    }

}
