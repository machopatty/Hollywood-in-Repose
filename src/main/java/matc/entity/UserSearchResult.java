package matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import lombok.*;

/**
 * The type Book.
 */
@Entity(name = "UserSearchResult")
@Table(name = "userSearchResult") // case sensitive!

@Data class UserSearchResult {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Getter @Setter private int id;

    @Column(name = "userSearch")
    @Getter @Setter private String userSearch;

    @ManyToOne
    private User user;


    /**
     * Instantiates a new Book.
     */
    public UserSearchResult() {
    }

    public UserSearchResult(String userSearch, User user) {

        this.userSearch = userSearch;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserSearchResult{" +
                "userSearch='" + userSearch + '\'' +
                ", user=" + user +
                '}';
    }
}

