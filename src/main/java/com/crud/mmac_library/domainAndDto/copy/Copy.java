package com.crud.mmac_library.domainAndDto.copy;

import com.crud.mmac_library.domainAndDto.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COPIES")
public class Copy {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

    @Column(name = "COPY_STATUS")
    private CopyStatus copyStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Book_Id")
    private Book book;

    public Copy(CopyStatus copyStatus, Book book) {
        this.copyStatus = copyStatus;
        this.book = book;
    }
}