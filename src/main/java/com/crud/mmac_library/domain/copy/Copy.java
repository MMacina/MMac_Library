package com.crud.mmac_library.domain.copy;

import com.crud.mmac_library.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Copies")
public class Copy {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long Id;

    @Column(name = "Copy_Status")
    private CopyStatus copyStatus;

    @ManyToOne
    @JoinColumn(name = "Book_Id")
    private Book book;

}
