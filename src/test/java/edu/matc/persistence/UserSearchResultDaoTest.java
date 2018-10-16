package edu.matc.persistence;

        import edu.matc.testUtils.Database;
        import matc.entity.UserSearchResult;
        import matc.entity.User;
        import matc.persistence.GenericDao;
        import matc.persistence.UserDao;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.util.List;

        import static org.junit.jupiter.api.Assertions.*;

/** Unit test for BookDao
 *
 * @author Paula Waite
 */

class UserSearchResultDaoTest {

    GenericDao genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(UserSearchResult.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies Gets all orders successfully.
     */
    @Test
    void getAllSearchesSuccess() {
        List<UserSearchResult> userSearchResult = genericDao.getAll();
        assertEquals(4, userSearchResult.size());
    }

    /**
     * Verify successful insert of a UserSearchResult
     */
    @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        UserSearchResult newUserSearchResult = new UserSearchResult("Frank Sinatra", user);
        user.addSearchResult(newUserSearchResult);

        int id = genericDao.insert(newUserSearchResult);

        assertNotEquals(0,id);
        User insertedSearchResult = (User) genericDao.getById(id);
        assertEquals("Frank Sinatra", insertedSearchResult.getSearchResult());
        assertNotNull(insertedSearchResult.getFirstName());
        assertEquals("Joe", insertedSearchResult.getUserSearchResults());
    }

    /**
     * Verify successful update of a UserSearchResult
     */
    @Test
    void updateSuccess() {
        String userSearch = "Phil Hoffman";
        UserSearchResult searchToUpdate = (UserSearchResult)genericDao.getById(3);
        searchToUpdate.setUserSearch(userSearch);
        genericDao.saveOrUpdate(searchToUpdate);
        UserSearchResult retrievedSearch = (UserSearchResult)genericDao.getById(3);
        assertEquals(userSearch, retrievedSearch.getUserSearch());
    }

    /**
     * Verify successful delete of UserSearchResult
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify successful retrieval of all Books
     */
    @Test
    void getAllSuccess() {
        List<UserSearchResult> UserSearchResults = genericDao.getAll();
        assertEquals(4, UserSearchResults.size());
    }
}