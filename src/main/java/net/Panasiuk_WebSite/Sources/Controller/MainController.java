package net.Panasiuk_WebSite.Sources.Controller;

import net.Panasiuk_WebSite.Logic.Authorization.dao.MarkDao;
import net.Panasiuk_WebSite.Logic.Authorization.dao.UserDao;
import net.Panasiuk_WebSite.Logic.Authorization.service.UserService;
import net.Panasiuk_WebSite.Sources.Model.Mark;
import net.Panasiuk_WebSite.Sources.Model.User;
import net.Panasiuk_WebSite.Sources.Validator.MarksValidator;
import net.Panasiuk_WebSite.Sources.Validator.UserValidator;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MarksValidator marksValidator;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserDao userDao;

    @Autowired
    private MarkDao markDao;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/oneStudent/{name}", method = RequestMethod.GET)
    public String showStudentForStudents(@PathVariable("name") String name, Model model){
        User user = userService.findByUsername(name);
        Mark marks = markDao.findById(user.getId());
        double averageMark = DoubleRounder.round((double) (marks.getBiology()+marks.getMath()+marks.getHistory()+marks.getChemistry()+marks.getEnglish()+marks.getGeography())/6, 2);
        model.addAttribute("oneStudent", user);
        model.addAttribute("studentMarks", marks);
        model.addAttribute("averageMark", averageMark);
        return "studentView";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("allUsers", userDao.findAll());
        for (User user: userDao.findAll()) {
            System.out.println(user);
        }
        return "admin";
    }

    @RequestMapping(value = "/admin/newStudent", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/admin/newStudent", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors() || userForm.getCourse().isEmpty()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect: /admin";
    }

    @RequestMapping(value = "/admin/oneStudent/{id}", method = RequestMethod.GET)
    public String showStudent(@PathVariable("id") Long id, Model model){
        Mark marks = markDao.findById(id);
        double averageMark = DoubleRounder.round((double) (marks.getBiology()+marks.getMath()+marks.getHistory()+marks.getChemistry()+marks.getEnglish()+marks.getGeography())/6, 2);
        model.addAttribute("oneStudent", userDao.findUserById(id));
        model.addAttribute("studentMarks", markDao.findById(id));
        model.addAttribute("averageMark", averageMark);
        return "/showStudent";
    }

    @RequestMapping(value = "/admin/oneStudent/{id}/editMarks", method = RequestMethod.GET)
    public String editStudentMarks(@PathVariable("id") Long id, Model model){
        Mark marks = markDao.findById(id);
        model.addAttribute("studentMarks", marks);
        model.addAttribute("oneStudent", userDao.findUserById(id));
        return "/editStudentMarks";
    }

    @RequestMapping(value = "/admin/oneStudent/{id}/editMarks", method = RequestMethod.POST)
    public String changeMarks(@PathVariable("id") Long id, @ModelAttribute("studentMarks") Mark marks, BindingResult bindingResult, Model model){
        marksValidator.validate(marks, bindingResult);
        model.addAttribute("oneStudent", userDao.findUserById(id));
        if (bindingResult.hasErrors()){
            return "/editStudentMarks";
        }
        markDao.save(marks);
        return "redirect: /admin/oneStudent/{id}";
    }

    @RequestMapping(value = "/admin/oneStudent/delete/{id}", method = RequestMethod.POST)
    public String deleteStudent(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect: /admin";
    }

    @RequestMapping(value = "/403", method = {RequestMethod.POST, RequestMethod.GET})
    public String error403(){
        return "403";
    }
}
