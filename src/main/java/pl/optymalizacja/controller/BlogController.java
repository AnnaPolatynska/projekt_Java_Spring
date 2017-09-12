package pl.optymalizacja.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.optymalizacja.model.Contact;
import pl.optymalizacja.model.Post;
import pl.optymalizacja.model.Register;
import pl.optymalizacja.repository.PostRepo;
import pl.optymalizacja.repository.RegisterRepo;


@Controller
public class BlogController {
	private RegisterRepo reg_rep;
	private PostRepo post_rep;
	
	@Autowired
	public BlogController(RegisterRepo reg_rep, PostRepo post_rep){
		this.reg_rep = reg_rep;
		this.post_rep = post_rep;
	}
	//strefa bez logowania: home, about i ankieta
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	@RequestMapping("/about")
	public String about(){
		return "about";
	}
	@RequestMapping("/ankieta")
	public String ankieta(){
		return "ankieta";
	}
	//strefa wymagająca logowania
	
	
	@RequestMapping("/articles")
	public String articles(){
		return "articles";
	}
	@RequestMapping("/add")
	public String add(){
		return "add";
	}
		
	
	//formularz logowania
	@RequestMapping("/loginForm")
	public String loginForm(Model model){
		model.addAttribute("reg_rep", new Register());
		return "loginForm";
	}
	
	
	//formularz rejestracyjny
	@RequestMapping("/registerForm")
	public String registerForm(Model model){
		model.addAttribute("reg", new Register());
		return "registerForm";
	}
	@PostMapping("/saveRegisterForm")
	public String saveRegister(@ModelAttribute Register reg, Model model){
		reg_rep.save(reg);		
		model.addAttribute("reg",reg);
		return "saveRegisterForm";
	}
		
}
	/*
	@Autowired
	public BlogController(RegisterRepo rr, PostsRepo pr){
		this.rr = rr; = reg_rep;
		this.pr = pr; = post_rep;
		
	
	@PostMapping("/blog")
	public String blog(@ModelAttribute Register reg, Model model){
		model.addAttribute("reg",reg);
		List<Register> rs = reg_rep.findAllByLoginAndPasswd(reg.getLogin(), reg.getPasswd());
		if(rs.isEmpty()){
			return "errorPage";
		} else {
		model.addAttribute("post", new Posts());
		return "blog";
		}
	}
	@PostMapping("/add")
	public String add(@ModelAttribute Posts post, Model model){
		pr.save(post);
		List<Posts> all = pr.findAll();
		model.addAttribute("all", all);	
		return "add";
	}
	@RequestMapping("/contact")
	public String contact(Model model){
		model.addAttribute("c", new Contact());
		return "contact";
	}
	
	@PostMapping("/contact")
	public String validForm(@Valid @ModelAttribute Contact c, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("c", new Contact());
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(err -> System.out.println(err.getDefaultMessage()));
			return "contact";
		}else{
			model.addAttribute("c", c);
		return "success";	
		}
	}
	
	
	
	
	
	@RequestMapping("/")
	public String about(){
		return "about";
	}
	@RequestMapping("/registerForm")
	public String registerForm(Model model){
		model.addAttribute("reg", new Register());
		return "registerForm";
	}
	@PostMapping("/saveRegisterForm")
	public String saveRegister(@ModelAttribute Register reg, Model model){
		reg_rep.save(reg);		
		model.addAttribute("reg",reg);
		return "saveRegisterForm";
	}
	@RequestMapping("/loginForm")
	public String loginForm(Model model){
		model.addAttribute("reg", new Register());
		return "loginForm";
	}
	
}

}*/