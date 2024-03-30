insert into air_companies (name, company_type, founded_at) values
('Emirates', 'CORPORATION', 1995),
('Qatar Airways', 'LLC', 2002),
('Turkish Airlines', 'CORPORATION', 1933),
('Air France', 'LLC', 2004),
('Japan Airlines', 'CORPORATION', 1951);


insert into airplanes (name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, airplane_type, created_at) values
('Airplane1', '123DFGF1234', 2, 49, 58678, 10100, 'PASSENGER', '2015-04-22'),
('Airplane2', '776KKJK8778', 1, 123, 211678, 12200, 'AIRSHIP', '2009-07-10'),
('Airplane3', '134LJJH2323', 1, 110, 123894, 8300, 'PASSENGER', '2010-02-03'),
('Airplane4', '5443JKJJK23', 3, 245, 78904, 11350, 'CARGO', '2005-11-22'),
('Airplane5', '7788JKJ9900', 3, 34, 34870, 9780, 'PASSENGER', '2017-08-12'),
('Airplane6', '22JKJJ44334', 4, 153, 123678, 11400, 'CARGO', '2016-12-10');


insert into flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, created_at) values
('COMPLETED', 3, 4, 'Ukraine', 'Italy', 1900, '03:55', '2024-03-26T10:15:31', '2024-03-26T14:10:31', '2024-03-25T15:12:31'),
('COMPLETED', 3, 5, 'Ukraine', 'Turkey', 1300, '03:15', '2024-03-26T14:12:31', '2024-03-26T17:25:31', '2024-03-25T15:22:31');
insert into flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, delay_started_at, ended_at, created_at) values
('COMPLETED', 4, 6, 'Ukraine', 'Poland', 900, '02:40', '2024-03-26T17:15:29', '2024-03-26T19:55:31', '2024-03-26T20:15:31', '2024-03-25T18:12:31');
insert into flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, created_at) values
('ACTIVE', 3, 5, 'Ukraine', 'Poland', 1200, '3:10', '2024-03-30T12:41:31', '2024-03-27T11:46:31'),
('ACTIVE', 3, 4, 'Ukraine', 'Canada', 7200, '28:55', '2024-03-29T16:40:31', '2024-03-27T11:12:31'),
('ACTIVE', 4, 6, 'Ukraine', 'Turkey', 1420, '2:25', '2024-03-30T08:44:31', '2024-03-27T14:22:31');
insert into flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, delay_started_at, created_at) values
('DELAYED', 2, 1, 'Ukraine', 'Switzerland', 2200, '4:10', '2024-03-27T16:10:31', '2024-03-27T20:20:31', '2024-03-24T15:12:31'),
('DELAYED', 1, 2, 'Ukraine', 'Italy', 1900, '3:40', '2024-03-27T17:00:31', '2024-03-27T20:40:31', '2024-03-25T22:18:31');
insert into flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, created_at) values
('PENDING', 1, 2, 'Ukraine', 'Germany', 1450, '2:55', '2024-03-27T15:12:31'),
('PENDING', 2, 1, 'Ukraine', 'Poland', 900, '2:40', '2024-03-27T15:43:31'),
('PENDING', 1, 3, 'Ukraine', 'Belgium', 2100, '3:15', '2024-03-27T17:34:31');