package com.crud.mmac_library.domain.book;

import com.crud.mmac_library.domain.copy.Copy;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Books")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long Id;

    @Column(name = "Title")
    private String bookTitle;

    @Column(name = "Authors Name")
    private String authorsName;

    @Column(name = "Authors Surname")
    private String authorsSurname;

    @Column(name = "Publicised")
    private LocalDate publicised;

    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Copy> copies = new ArrayList<>();
}
