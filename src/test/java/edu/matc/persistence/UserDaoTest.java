package edu.matc.persistence;

import edu.matc.testUtils.Database;
import matc.entity.UserSearchResult;
import matc.entity.User;
import matc.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    GenericDao genericDao;

    /**
     * Creates the dao
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies Gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verifies the get User by last name successfully.
     */
    @Test
    void userByLastNameSuccess() {
        List<User> users = genericDao.userByLastName("k");
        assertEquals(1, users.size());
    }

    /**
     * Verifies a user is returned correctly by Id.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Bill", retrievedUser.getFirstName());
    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Fred", "Flintstone", "fStone@hotmail.com");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("Fred", insertedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithOrderSuccess() {

        User newUser = new User("Fred", "Flintstone", "fStone@hotmail.com");

        String celebEntry = "Liberace";
        UserSearchResult userSearchResult = new UserSearchResult(newUser);

 //       newUser.addSearchResult(userSearchResult);

        int id = genericDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("Fred", insertedUser.getFirstName());
  //      assertEquals(1, insertedUser.getUserSearchResults().size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDao.getByPropertyEqual("lastName", "Jenkins");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("lastName", "c");
        assertEquals(1, users.size());
    }
}