# Application Flow


### User Sign up

1. User chooses sign up on the menu.
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu 
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Main Page 

1. Page sends a request to view obituaries from current date
1. Returns listing of deceased celebrities from current date

### Advanced Search

1. Page sends a request to view obituaries along with criteria 
(name, dod).
1. Servlet selects obituary based on sent criteria
1. Servlet sends list back to obituary jsp.
1. Jsp displays results.

