package com.crud.mmac_library.domainAndDto.user;

import com.crud.mmac_library.domainAndDto.borrowing.Borrowing;
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
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

    @Column(name = "NAME")
    private String userName;

    @Column(name = "SURNAME")
    private String userSurname;

    @Column(name = "JOINED")
    @NotNull
    private Date joined;

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Borrowing> borrowings = new ArrayList<>();
}
