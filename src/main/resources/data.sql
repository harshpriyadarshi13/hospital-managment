INSERT INTO patient (name,gender,dob,email,created_at,blood_group)
VALUES
    ('Aarav','Male','2001-02-12','aarav@gmail.com',NOW(),'B_POSITIVE'),
    ('Prakhar','Male','2001-02-12','prakhar@gmail.com',NOW(),'B_POSITIVE'),
    ('Sakshi','Female','2001-02-12','sakshi@gmail.com',NOW(),'O_POSITIVE'),
    ('Harsh','Male','2001-02-12','harsh@gmail.com',NOW(),'A_POSITIVE'),
    ('Neha','Female','2001-02-12','neha@gmail.com',NOW(),'AB_POSITIVE');

INSERT INTO doctor (name,specialization,email)
VALUES
    ('Amit','neuro','amit@gmail.com'),
    ('Rohan','cardio','rohan@gmail.com');