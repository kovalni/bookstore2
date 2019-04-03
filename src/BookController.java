package com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {
	
//https://github.com/kovalni/bookstore1.git
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private HttpSession session;
	
	//Log in to bookstore
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	//Show all books as a list
	@RequestMapping(value="/booklist")
	   	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
	    return "booklistTemplate";
	 }
	
	//RESTful finding all books
	@RequestMapping(value="/books", method = RequestMethod.GET)
		public @ResponseBody List<Book> bookListRest(){
		return(List<Book>) repository.findAll();
	}
	
	//RESTful finding book by ID
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
		public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
		return repository.findById(id);
	}
	
	//RESTful deleting of book
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long id, Model model) {
	    	repository.deleteById(id);
	        return "redirect:../booklist";
	    } 
	  
	//Add new book to shelf
	    @RequestMapping(value = "/addbook")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	        return "addbookTemplate";
	    }  
	    
	//Save new book
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist";
	    }   
	    
	//Edit book
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editBook(@PathVariable("id") Long id, Model model){
	    	model.addAttribute("book", repository.findById(id));
	        return "editbookTemplate";
	    }
	    
	//Save changes
	    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
	    public String change(Book book) {
	        repository.save(book);
	        return "redirect:../booklist";
	        
	    }
	    @RequestMapping(value="/logout")
	    public String logOut() {
	    	return "login";
	    }

}	
