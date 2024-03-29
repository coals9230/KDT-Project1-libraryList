package kr.swu.book_list.service;

import kr.swu.book_list.repository.BookMapper;
import kr.swu.book_list.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    BookMapper bookMapper;

    @Autowired
    public BookService(BookMapper bookMapper) {
        this.bookMapper=bookMapper;
    }
    public List<Book> getBookList() {
        return bookMapper.findAll();
    }

    public List<Book> searchBook(String keyword) {
        return bookMapper.findByNameContaining(keyword);
    }

    public Book getBook(int book_num) {
        return bookMapper.findByNum(book_num);
    }

    public void updateState(boolean availability, int book_num) {
        bookMapper.update(availability, book_num);
    }
}
