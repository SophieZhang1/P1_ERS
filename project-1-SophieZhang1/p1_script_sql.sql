  
  create table users (
  user_id serial primary key,
  username text,
  password text, 
  first_name text,
  last_name text,
  email text,
  user_role_id int references user_role(user_role_id)
  );
 

  select * from users;   


   
  create table reimbursement (
  reibm_id serial primary key,
  status text,
  reibm_submitted text,
  reibm_resolved text,
  reibm_description text,
  reibm_receipt int,
  author int references users(user_id),
  resolver int references users(user_id),
  reimb_status_id int references status(reimb_status_id),
  remib_type_id int references remib_type(remib_type_id),
  amount float
  );
 
 
  select * from reimbursement;



    create table user_role (
    user_role_id serial PRIMARY KEY,
	role TEXT
    );
   
   
   select * from user_role;
  
  

  create table remib_type (
  remib_type_id serial primary key,
  remib_type text
  );
 
 
 select * from remib_type;
 
  
  create table status (
  reimb_status_id serial primary key,
  reimb_status text
  ); 
 

  select * from status;



   INSERT into user_role (role)
   VALUES ('employee'),
	      ('finance manager');
	     
	
   INSERT INTO reimbursement (status, reibm_submitted, reibm_resolved, reibm_description, reibm_receipt, author, resolver, reimb_status_id, remib_type_id, amount)
   VALUES ('denied', '10-05-2021', '10-12-2021', 'lodging', 1, 1, 1, 3, 1, 520),
	      ('approved', '10-12-2021', '10-20-2021', 'travel', 2, 2, 2, 2, 2, 250),
	      ('approved', '10-14-2021', '10-25-2021', 'food', 3, 3, 3, 2, 3, 410),
	      ('pending', '10-15-2021', 'Null', 'other', 4, 4, 4, 1, 4, 560);
	     
	     
	INSERT INTO remib_type (remib_type)
    VALUES ('lodging'),
           ('travel'),
           ('food'),
           ('other');
	   
 
 
    INSERT INTO status (reimb_status)
    VALUES ('pending'),
           ('approved'),
           ('denied');

          
                   
   INSERT INTO users (username, password, first_name, last_name, email, user_role_id)
   VALUES ('apple', 'A123', 'Shirley', 'Smith', 'shirley.smith@gmail.com', 1),
	      ('pear','B123', 'James', 'Brown', 'james.brown@gmail.com', 2),
	      ('orange', 'C123', 'Alice', 'Miller', 'alice.miller@gmail', 1),
	      ('banana', 'D123', 'Ed', 'Davis', 'ed.davis@gmail.com', 1);