## Діаграми послідовностей
1. User Registration
User Story: Як новий користувач, я хочу зареєструватися в системі, щоб мати доступ до своїх проектів та завдань.

Діаграма послідовностей:

User -> Web Application: Open Registration Page
User -> Web Application: Enter Registration Details
User -> Web Application: Submit Registration Form
Web Application -> Backend: Create User
Backend -> Database: Insert User Details
Database -> Backend: Confirm Insertion
Backend -> Web Application: Confirm User Created
Web Application -> User: Show Registration Success

2. User Login
User Story: Як зареєстрований користувач, я хочу увійти в систему, щоб отримати доступ до своїх проектів та завдань.

Діаграма послідовностей:

User -> Web Application: Open Login Page
User -> Web Application: Enter Credentials
User -> Web Application: Submit Login Form
Web Application -> Backend: Authenticate User
Backend -> Database: Verify User Credentials
Database -> Backend: Return Authentication Status
Backend -> Web Application: Return Authentication Result
Web Application -> User: Show Login Success or Failure

3. Create Project
User Story: Як менеджер проекту, я хочу створити новий проект, щоб розпочати роботу над новою ініціативою.

Діаграма послідовностей:

Manager -> Web Application: Open Create Project Page
Manager -> Web Application: Enter Project Details
Manager -> Web Application: Submit Project Form
Web Application -> Backend: Create Project
Backend -> Database: Insert Project Details
Database -> Backend: Confirm Insertion
Backend -> Web Application: Confirm Project Created
Web Application -> Manager: Show Project Creation Success

4. Create Task
User Story: Як користувач, я хочу створити нове завдання для проекту, щоб розподілити роботу.

Діаграма послідовностей:

User -> Web Application: Open Create Task Page
User -> Web Application: Enter Task Details
User -> Web Application: Submit Task Form
Web Application -> Backend: Create Task
Backend -> Database: Insert Task Details
Database -> Backend: Confirm Insertion
Backend -> Web Application: Confirm Task Created
Web Application -> User: Show Task Creation Success

5. Assign Task to User
User Story: Як менеджер проекту, я хочу призначити завдання конкретному користувачу, щоб розподілити роботу серед команди.

Діаграма послідовностей:

Manager -> Web Application: Open Task Assignment Page
Manager -> Web Application: Select Task and User
Manager -> Web Application: Submit Assignment
Web Application -> Backend: Assign Task to User
Backend -> Database: Update Task with User ID
Database -> Backend: Confirm Update
Backend -> Web Application: Confirm Assignment
Web Application -> Manager: Show Assignment Success
