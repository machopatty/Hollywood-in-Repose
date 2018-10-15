package matc.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.*;


/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "user")

@Data class User {
    @Column(name = "firstName")
    @Getter @Setter private String firstName;

    @Column(name = "lastName")
    @Getter @Setter private String lastName;
    
    @Column(name = "email")
    @Getter @Setter private String email;
    
    @Column(name = "userName")
    @Getter @Setter private String userName;
    
    @Column(name = "password")
    @Getter @Setter private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserSearchResult> returnedResults = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {

    }








    /**
     * Gets books.
     *
     * @return the books
     */
    public Set<UserSearchResult> getSearchResult() {
        return returnedResults;
    }

    /**
     * Sets books.
     *
     * @param books the books
     */
    public void setSearchResult(Set<UserSearchResult> returnedResults) {
        this.books = books;
    }

    /**
     * Add userSearchResult.
     *
     * @param userSearchResult the userSearchResult
     */
    public void addSearchResult(UserSearchResult userSearchResult) {
        books.add(userSearchResult);
        userSearchResult.setSearchResult(this);
    }

    /**
     * Remove userSearchResult.
     *
     * @param userSearchResult the userSearchResult
     */
    public void removeSearchResult(UserSearchResult userSearchResult) {
        books.remove(userSearchResult);
        userSearchResult.setSearchResult(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}


