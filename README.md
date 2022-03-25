# ReimbursementProject

The Expense Reimbursement System manages the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursements and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

- Java
- Servlets
- JDBC
- PostgreSQL
- HTML
- CSS
- JavaScript
- JUnit
- Log4J

## Features

An Employee can:
- Login.
- View the employee home page.
- Logout.
- Submit a reimbursement request.
- View their pending reimbursement requests.
- View their resolved reimbursement requests.
- View their information.
- Update their information.

A Manager can:
- Login.
- View the manager home page.
- Logout.
- Approve/Deny pending reimbursement requests.
- View all pending requests of all employees.
- View all resolved requests of all employees.
- View reimbursement requests of a specific employee.
- View all employees.

## Getting Started
   
- `git clone https://github.com/MolSnoo/ReimbursementProject.git`

Run the following commands in a MySQL terminal:
- `create database reimbursements;`
- `use reimbursements;`
- `create table User (id integer primary key auto_increment, name varchar(255), email varchar(255), password varchar(255), type enum('EMPLOYEE', 'MANAGER'));`
- `insert into User (name, email, password, type) values ('root', 'root@gmail.com', 'root', 'MANAGER');`
- `insert into User (name, email, password, type) values ('Mark', 'm@gmail.com', 'password', 'EMPLOYEE');`
- `create table rs (id integer primary key auto_increment, eid integer, amount integer(10), approved bool, foreign key (eid) references user(id));`

## Usage
- Open the project folder in IntelliJ IDEA 2021.
- In hibernate.cfg.xml, edit the `connection.username` and `connection.password` to match the credentials of your admin MySQL account.
- Run the project using Tomcat.
- Open the project in your browser of choice at http://localhost:8080/ReimbursementProject
- Log in using the username `root@gmail.com` and password `root` to access the manager account.
- Log in using the username `m@gmail.com` and password `password` to access the employee account.

## Contributors

Vivian Anderson, Michael Butera

## License

Apache License, Version 2.0
https://opensource.org/licenses/Apache-2.0

