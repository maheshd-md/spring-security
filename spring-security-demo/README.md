# spring-security-demo

This is simple spring security demo project which shows basic configuration for role based security to APIs.

There are 3 APIs (details are given below) and 2 roles (ADMIN and CLIENT).
The 1st API can be accessed by both roles.
The 2nd API can be accessed by only ADMIN.
The 3rd API can be accessed by only CLIENT.

The

### Prerequisites:

The database spring_security_demo should be exist with my_user table and below entries should be present in the table:

spring_security_demo=# select * from my_user;

 id |                           password                           |  role  | username 
----+--------------------------------------------------------------+--------+----------
  1 | $2y$12$iQf2GOBhBBB/5J.4lx6VseR954gaMwvLOoAHGJhtBLtCkqmFWIlSC | ADMIN  | maheshd
  2 | $2y$12$gX9snjwaxHVtdmKAI6g1SegB5RnI/D0pXGsUnDBcFwEFe6bTuKpN6 | CLIENT | akshay


### Note: 
maheshd is ADMIN user
akshay is CLIENT user


### API details:

1. Home:
	This API works with both ADMIN and CLIENT users

   url: http://localhost:8080/home
   Authorization: Basic
		Username: maheshd
		Password: maheshd
   Expected response: `You are ADMIN user!`


2. Admin:
	This API only works with admin user

   url: http://localhost:8080/admin
   Authorization: Basic
		Username: maheshd
		Password: maheshd
   Expected response: `You are admin user!`

   If we try with CLIENT user we'll get error like:
	`{
	    "timestamp": "2021-01-31T14:43:37.468+00:00",
	    "status": 403,
	    "error": "Forbidden",
	    "message": "",
	    "path": "/admin"
	}`


3. Client:
	This API only works with CLIENT user

   url: http://localhost:8080/client
   Authorization: Basic
		Username: akshay
		Password: akshay

   Expected response: You are client user!

   If we try with ADMIN user we'll get error like:
	`{
	    "timestamp": "2021-01-31T14:43:37.468+00:00",
	    "status": 403,
	    "error": "Forbidden",
	    "message": "",
	    "path": "/client"
	}`

