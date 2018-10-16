package matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import lombok.*;

/**
 * The type Book.
 */
@Entity(name = "UserSearchResult")
@Table(name = "userSearchResult") // case sensitive!

@Data public class UserSearchResult {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Getter @Setter private int id;

    @Column(name = "userSearch")
    @Getter @Setter private String userSearch;

    @ManyToOne
    @Getter @Setter User user;


    /**
     * Instantiates a new Search.
     */
    public UserSearchResult() {
    }


    /**
     * Instantiates a new User search result.
     *
     * @param userSearch the user search
     * @param user       the user
     */
    public UserSearchResult(String userSearch, User user) {
        this.user = user;
        this.userSearch = userSearch;
    }


    @Override
    public String toString() {
        return "UserSearchResult{" +
                "userSearch='" + userSearch + '\'' +
                ", user=" + user +
                '}';
    }
}

