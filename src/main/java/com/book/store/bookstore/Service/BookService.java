package com.book.store.bookstore.Service;
import com.book.store.bookstore.Entity.Book;
import com.book.store.bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public String addBook(Book book){
        try {
            Optional<Book> optionalBook = bookRepository.findById(book.getId());
            if (optionalBook.isPresent()) {
                return "Book with same id already exists";
            }
            bookRepository.save(book);
            return "Book has been added";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(int id){
        return bookRepository.findById(id);
    }
    public String updateBook(Book book){
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if(optionalBook.isPresent()){
            bookRepository.save(book);
            return "Book details updated";
        }
        return "Book not found";
    }
    public String deleteBook(int id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return "Book deleted";
        }
        return "Book not found";
    }
}
