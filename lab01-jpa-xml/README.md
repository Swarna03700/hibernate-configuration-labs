# Configure Hibernate Using JPA XML

![Status](https://img.shields.io/badge/Status-Active-brightgreen)
![Created](https://img.shields.io/badge/Created-07%2F01%2F2026-blue)
![Modified](https://img.shields.io/badge/Modified-07%2F01%2F2026-orange)
![Version](https://img.shields.io/badge/Version-v1.0.0-blue)


In this lab, we focus on configuration of Hibernate using [JPA XML](https://docs.hibernate.org/orm/7.2/introduction/html_single/#configuration-jpa). Our primary job is to understand how to connect our application with the database. We will be querying the current date time of the database and show the date time in the console. We are not going into the details of managing entity types and business domain.

## Steps to Complete the Lab

- [Configure Hibernate Using JPA XML](#configure-hibernate-using-jpa-xml)
  - [Steps to Complete the Lab](#steps-to-complete-the-lab)
    - [1. Add Dependencies in Your Project `build.gradle` File](#1-add-dependencies-in-your-project-buildgradle-file)
    - [2. The `persistence.xml` File](#2-the-persistencexml-file)
    - [3. Create an Instance of `EntityManagerFactry`](#3-create-an-instance-of-entitymanagerfactry)
    - [4. Create an `EntityManager` Instance and Create a Query](#4-create-an-entitymanager-instance-and-create-a-query)
    - [5. Close Resources](#5-close-resources)
    - [6. Console Output](#6-console-output)
  - [Troubleshoot](#troubleshoot)
    - [`java.lang.IllegalStateException: Cannot get a connection ...`](#javalangillegalstateexception-cannot-get-a-connection-)
 
### 1. Add Dependencies in Your Project `build.gradle` File

---

We need two dependencies to complete this lab.

**Hibernet ORM**

`org.hibernate.orm:hibernate-core:{version}`

**JDBC Driver**

`org.postgresql:postgresql:{version}`

In this lab, we are using **PostgreSQL** RDBMS. Therefore we need a **JDBC Driver** for **PostgreSQL**.

**Example `build.gradle` file**

![build.gradle](assets/Screenshot%202026-01-07%20010749.png)

### 2. The `persistence.xml` File

---

The file resides in **META-INF** folder in your project's classpath.

Here's an example how to add configuration settings to this file.

![persistence.xml file](assets/Screenshot%202026-01-07%20180258.png)

The `<persistence-unit>` element contains the collection of associated entities and a set of default configuration settings. In our case it only contains some configuration settings.

The `<property>` element contains the configuration properties like **database-url**, **username**, **password** etc and their respective values.

### 3. Create an Instance of `EntityManagerFactry`

---

`EntityManagerFactory` is an interface provided by **JPA** that helps you to create an instance of `EntityManager`. 

`EntityManagerFactory` interacts with the **persistence-unit**. 

You get instance of `EntityManagerFactory` following this:

`EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.example");`

`"org.hibernate.example` is the *name* of the **persistence-unit**. You can set any name.

### 4. Create an `EntityManager` Instance and Create a Query

---

You can get instance of an `EntityManager` from `EntityManagerFactory` instance.

`EntityManager em = emf.createEntityManager();`

Create a simple query using `em.createNativeQuery(String)` and process the result.

Handle SQL Exceptions using `try-catch` block.

### 5. Close Resources

---

The persistence provider must close the resources.

`emf.close()`

`em.close()`


### 6. Console Output

Database connection successful!
It shows current date time of the database.

![output](/assets/Screenshot%202026-01-07%20011224.png)

## Troubleshoot

---

### `java.lang.IllegalStateException: Cannot get a connection ...` 

This exception is thrown if you forget to add dependency for **JDBC Driver**.

> [!Important]
> The JDBC Driver allows Java programs too connect to a *relational database* using *standard*, *database independent* Java code.


