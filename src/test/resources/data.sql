INSERT INTO employee (id,name,department) values (1,'Michael Scott','MANAGEMENT'),
                                                 (2,'Jim Halpert','SALES'),
                                                 (3,'Dwight Schrute','SALES'),
                                                 (4,'Pam Beesly','SALES'),
                                                 (5,'Angela Martin','ACCOUNTING'),
                                                 (6,'Kelly Kapoor','CUSTOMER_SERVICE'),
                                                 (7,'Toby Flanderson','HR') ON CONFLICT DO NOTHING;