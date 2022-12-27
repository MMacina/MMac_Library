package com.crud.mmac_library.domain.borrowing;

import com.crud.mmac_library.domain.copy.Copy;
import com.crud.mmac_library.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Borrowings")
public class Borrowing {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long Id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Copy_Id")
    private Copy copy;

    @ManyToOne
    @JoinColumn(name = "Users_Id")
    private User user;

    @Column(name = "Date_of_Borrow")
    private LocalDate dateOfBorrow;

    @Column(name = "Date of return")
    private LocalDate dateOfReturn;
}
