package com.crud.mmac_library.domain.user;

import com.crud.mmac_library.domain.borrowing.Borrowing;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long Id;

    @Column(name = "Name")
    private String userName;

    @Column(name = "Surname")
    private String userSurname;

    @Column(name = "Joined")
    @NotNull
    private Date joined;

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrowing> borrowings = new ArrayList<>();
}
