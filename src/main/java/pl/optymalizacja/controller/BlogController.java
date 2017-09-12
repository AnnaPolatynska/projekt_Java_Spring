package pl.optymalizacja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/articles")
	public String articles(){
		return "articles";
	}
	//strefa wymagająca logowania
	
	//formularz rejestracyjny
	@RequestMapping("/registerForm")
	public String registerForm(Model model){
		model.addAttribute("reg", new Register());
		return "registerForm";
	}
	@PostMapping("/saveRegisterForm")
	public String saveRegisterForm(@ModelAttribute Register reg, Model model){
		reg_rep.save(reg);		
		model.addAttribute("reg",reg);
		return "saveRegisterForm";
		}
	@PostMapping("/success")
	public String success(@ModelAttribute Model model){
		//model.addAttribute("reg",reg);
		return "success";
		}
	/*@PostMapping("/add")
	public String blog(@ModelAttribute Register reg, Model model){
		model.addAttribute("reg",reg);
		List<Register> rs = reg_rep.findAllByLoginAndPassword(reg.getLogin(), reg.getPassword());
		if(rs.isEmpty()){
			return "errorPage";
		} else {
		model.addAttribute("post", new Post());
		return "add";
		}
	}
	*/
	@PostMapping("/add")
	public String add(@ModelAttribute Post post, Model model){
		post_rep.save(post);
		List<Post> all = post_rep.findAll();
		model.addAttribute("all", all);	
		return "add";
	}
		
	//formularz logowania
	@RequestMapping("/loginForm")
	public String loginForm(Model model){
		model.addAttribute("reg_rep", new Register());
		return "loginForm";
	}
}
	