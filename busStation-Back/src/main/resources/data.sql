  
INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','USER');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','USER');
              
                            insert into company (id, name, address, pib) values (1, 'Severtrans', 'Sombor', 103376522);
insert into company (id, name, address, pib) values (2, 'Dunavprevoz', 'Backa Palanka', 123564849);
insert into company (id, name, address, pib) values (3, 'Janjusevic', 'Priboj', 123546888);

insert into line (id, available_seats, price, scheduled, destination, company_id) values (1, 35, 350.0, '2020-12-12 20:20','Apatin', 1);
insert into line (id, available_seats, price, scheduled, destination, company_id) values (2, 40, 550.0, '2020-11-12 18:20','Tovarisevo', 2);
insert into line (id, available_seats, price, scheduled, destination, company_id) values (3, 28, 380.0, '2020-11-12 17:45','Prijepolje', 3);