package com.webapp.librarymanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.webapp.librarymanagementapp.entities.Author;
import com.webapp.librarymanagementapp.entities.Book;
import com.webapp.librarymanagementapp.entities.User;
//import com.webapp.librarymanagementapp.service.BookService;
import com.webapp.librarymanagementapp.service.UserService;
@Controller
//@RestController
public class MainController {
	
	@Autowired
	//private BookService bookService;
	
	//@Autowired
	private UserService userService;
	
	static String userLogged;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String indexHandler() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginHandler(Model m, @RequestParam String username, @RequestParam String password) {
		User user = userService.findByUsernameAndPassword(username, password);
			if(user == null) {
				m.addAttribute("errormsg", "Invalid username or password");
				return "login";
			}
			
			userLogged = username;
			
		return "redirect:/dashboard";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}


	@PostMapping("/register")
	public String registerUser(@RequestParam String username, 
							@RequestParam String password,  
							Model model) {
		// Check if the username already exists
		if (userService.findByUsernameAndPassword(username,password) != null) {
			model.addAttribute("errormsg", "Username already taken");
			return "register";
		}

		// Create a new user object and set its properties
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);  // In real applications, make sure to hash the password!
		
		// Save the new user using UserService
		userService.saveUser(newUser);

		// Redirect to the login page after successful registration
		return "redirect:/login";
	}

	
	@GetMapping("/dashboard")
	public List<Book> dashboardHandler(Model m) {
		m.addAttribute("username",userLogged);
		RestTemplate rest= new RestTemplate();
		System.out.println(userLogged);
		//List<Book> bookList = bookService.getBooks();
		List bookList = rest.getForObject("http://localhost:8010/dashboard",List.class );
		m.addAttribute("books", bookList);
		return bookList;
	}
	
	
	
	
	@GetMapping("/author")
	public List<Author> authorHandler(Model m) {
		RestTemplate rest= new RestTemplate();
		List authorList = rest.getForObject("http://localhost:8010/author",List.class );
		//m.addAttribute("authors", authorList);
		return authorList;
	}
	
	@GetMapping("/addnewbook")
	public String addNewBookHandler() {
		RestTemplate rest= new RestTemplate();
		List addBook = rest.getForObject("http://localhost:8010/addnewbook",List.class );
		return "addnewbook";
	}
	
	@PostMapping("/addnewbook")
	public String addNewBookHandler(@RequestParam String book_code,@RequestParam String book_name,@RequestParam String added_date) {
		Book book=new Book();
		book.setBook_code(book_code);
		book.setBook_name(book_name);
		book.setAdded_date(added_date);
		System.out.println("--------"+book);
		RestTemplate rest= new RestTemplate();
		//System.out.println(book);
		rest.postForLocation("http://localhost:8010/addnewbook", book);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deleteBookHandler(@PathVariable int id) {
		RestTemplate rest= new RestTemplate();
		rest.delete("http://localhost:8010/deletebook/"+id);
		return "redirect:/dashboard";
	}
	
	/*	
	@GetMapping("/editbook/{id}")
	public String editBookHandler(Model m,@PathVariable int id) {
		Optional<Book> book = this.bookService.findBook(id);
		System.out.println(book);
		m.addAttribute("book", book.get());

		return "editbook";
	}
	*/

	/*
	 * @PutMapping("/updateBook") public String updateBook(@RequestBody Book book) {
	 * System.out.println(book); bookService.addBook(book); return
	 * "redirect:/dashboard";
	 * 
	 * }
	 */

	/*
	@PutMapping("/updatebooks")  
	public String update(@RequestBody Book book)   
	{  
	bookService.saveOrUpdate(book);  
	return "redirect:/dashboard";  
	}  
	*/
}
