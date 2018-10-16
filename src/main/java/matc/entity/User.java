package matc.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.*;


/**
 * The type User.
 */
@ToString
@Entity(name = "User")
@Table(name = "user")

@Data public class User {
    @Column(name = "first_name")
    @Getter @Setter private String firstName;

    @Column(name = "last_name")
    @Getter @Setter private String lastName;

    @Column(name = "user_name")
    @Getter @Setter private String userName;

    @Column(name = "password")
    @Getter @Setter private String password;

    @Column(name = "email")
    @Getter @Setter private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserSearchResult> userSearchResults = new HashSet<>();


    /**
     * Instantiates a new User.
     */
    public User() {

    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets returnedResults.
     *
     * @return the returnedResults
     */
    public Set<UserSearchResult> getSearchResult() {
        return userSearchResults;
    }

    /**
     * Sets returnedResults.
     *
     * @param userSearchResults the userSearchResults
     */
    public void setSearchResult(Set<UserSearchResult> userSearchResults) {
        this.userSearchResults = userSearchResults;
    }

    /**
     * Add userSearchResult.
     *
     * @param userSearchResult the userSearchResult
     */
    public void addSearchResult(UserSearchResult userSearchResult) {
        userSearchResults.add(userSearchResult);
        userSearchResult.setUser(this);
    }

    /**
     * Remove userSearchResult.
     *
     * @param userSearchResult the userSearchResult
     */
    public void removeSearchResult(UserSearchResult userSearchResult) {
        userSearchResults.remove(userSearchResult);
        userSearchResult.setUser(null);
    }

}


