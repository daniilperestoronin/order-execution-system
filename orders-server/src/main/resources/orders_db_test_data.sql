INSERT INTO personal_information (first_name, last_name, middle_name, identifier, password)
VALUES
  ('Alan', 'Abbot', 'S', 'alan_abbot@gmail.com', 'alan_abbot'),
  ('Bob', 'Corey', 'A', 'bob_corey@gmail.com', 'bob_corey'),
  ('Jack', 'McCorty', 'M', 'jack_mccorty@gmail.com', 'jack_mccorty');

INSERT INTO clients (id_personal_information, client_type, coordinates)
VALUES
  (1, 'CUSTOMER', point(59.995681372760984,30.21690845489502)),
  (2, 'EXECUTOR', point(59.9907021683028,30.2528715133667)),
  (3, 'EXECUTOR', point(59.96635337643215,30.294241905212402));

INSERT INTO orders ( id_customer, id_executor, address, description, coordinates)
VALUES
  (1, 2, 'Levashovskiy pr., 9, Sankt-Peterburg, Russia, 197110', 'Help with transportation', point(59.96631041741666,30.296130180358887)),
  (1, 3, 'ul. Podkovyrova, 24, Sankt-Peterburg, Russia, 197136', 'Help with loading', point(59.96467793354456,30.301108360290527)),
  (1, 1 , 'Mebelnaya ul., 19 корпус 2, Sankt-Peterburg, Russia, 197082', 'Help with bags', point(59.995681372760984,30.21690845489502));

