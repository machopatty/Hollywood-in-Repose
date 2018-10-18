package matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import lombok.*;

/**
 * The type Book.
 */
//@ToString
@Entity(name = "UserSearchResult")
@Table(name = "userSearchResult") // case sensitive!

public class UserSearchResult {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Getter @Setter private int id;

    @Column(name = "celebrityName")
    @Getter @Setter private String celebrityName;

    @ManyToOne
    @Getter @Setter User user;

    /**
     * Instantiates a new Search.
     */
    public UserSearchResult() {
    }


   public UserSearchResult(User user) {

        this.user = user;
    }

    @Override
    public String toString() {
        return "UserSearchResult{" +
                "id=" + id +
                ", celebrityName='" + celebrityName + '\'' +
                '}';
    }
}

