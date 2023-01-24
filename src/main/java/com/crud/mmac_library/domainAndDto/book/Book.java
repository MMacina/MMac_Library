package com.crud.mmac_library.domainAndDto.book;

import com.crud.mmac_library.domainAndDto.copy.Copy;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

    @Column(name = "TITLE")
    private String bookTitle;

    @Column(name = "AUTHORS_NAME")
    private String authorsName;

    @Column(name = "AUTHORS_SURNAME")
    private String authorsSurname;

    @Column(name = "PUBLICISED")
    private LocalDate publicised;

    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Copy> copies = new ArrayList<>();

    public Book(String bookTitle, String authorsName, String authorsSurname) {
        this.bookTitle = bookTitle;
        this.authorsName = authorsName;
        this.authorsSurname = authorsSurname;
    }
}