# File-Hider-Project for java

Hi my name is Adnan,

Small Description of my project:- 

**User Authentication:**
     Users will authenticate themselves using their Gmail accounts. This can be achieved by integrating Gmail's OTP (One-Time Password) 
     authentication system. Upon login, users will receive an OTP via Gmail, which they will use to authenticate themselves.

**File Hiding Mechanism:**
     Users can upload files to the system, and these files will be stored securely in the Oracle database. To "hide" these files, you 
     can encrypt them before storing in the database. This ensures that even if someone unauthorized gains access to the database, they 
     won't be able to view the contents of the files without decryption.

 **Admin Privilege:**
     An admin account will have special privileges, including the ability to view all files uploaded by users. 
     The admin's access will be controlled through a separate interface or by adding an additional flag to user 
     accounts in the database indicating admin status.   

 **Core Java Implementation:**
     Use core Java for the backend logic of the application, including file handling, database operations (connecting to Oracle DB, CRUD operations), 
     and encryption/decryption algorithms.
     
**Oracle Database:**
     Utilize Oracle Database to store user account information, file metadata, and encrypted file contents. Design the database schema to 
     efficiently manage user data and file relationships.

**User Interface:**
     Develop a user-friendly interface using simple java console(Scanner class) for users to interact with the application. 
     This interface should allow users to upload, download, and manage their files securely.

**Integration with Gmail OTP:**
     Use Gmail's SMTP service to send OTPs to users' email addresses. When a user attempts to log in, prompt them to enter 
     the OTP received on their Gmail account. Validate the OTP to authenticate the user.

**This project combines various aspects of Java programming, database management, and security implementation to create a robust 
file hiding system with user authentication and admin privileges.**
     
