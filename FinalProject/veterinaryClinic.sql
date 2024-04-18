drop database veterinaryClinic;

create database veterinaryClinic;
use veterinaryClinic;


DROP TABLE IF EXISTS `Employees`;
create table Employees (
e_ssn INT not null,
e_name VARCHAR(255) DEFAULT NULL,
e_email VARCHAR(255) DEFAULT NULL,
e_Role VARCHAR(255) DEFAULT NULL,
e_phoneNum varchar(32) DEFAULT NULL,
e_salary INT,
e_password VARCHAR(255),
PRIMARY KEY (e_ssn)
);


DROP TABLE IF EXISTS `Vets`;
create table Vets(
veteran_id INT,
e_ssn INT not null,
PRIMARY KEY (veteran_id),
FOREIGN KEY (e_ssn) REFERENCES Employees(e_ssn)
 ON DELETE CASCADE ON UPDATE CASCADE
);
-- Survice table
DROP TABLE IF EXISTS Survice;
CREATE TABLE Survice (
    survice_id INT NOT NULL AUTO_INCREMENT,
    survice_type VARCHAR(32) DEFAULT NULL,
    survice_price INT DEFAULT NULL,
    paid BOOLEAN DEFAULT FALSE, -- Adding the paid column
    PRIMARY KEY (survice_id)
);

DROP TABLE IF EXISTS `Owner`;
CREATE TABLE `Owner` (
  `o_ssn` int(9) NOT NULL,
  `o_name` varchar(32) DEFAULT NULL,
  `o_phoneNum` varchar(10) DEFAULT NULL,
  `o_email` varchar(64) DEFAULT NULL,
  `pet_ID` int(5) DEFAULT NULL,
  PRIMARY KEY (`o_ssn`)
);

CREATE TABLE `Pet` (
  `pet_Id` INT(11) NOT NULL AUTO_INCREMENT,
  `p_Name` VARCHAR(32) DEFAULT NULL,
  `p_Type` VARCHAR(32) DEFAULT NULL,
  `p_Breed` VARCHAR(32) DEFAULT NULL,
  `p_BirthOfDate` VARCHAR(32) DEFAULT NULL,
  `p_Weight` INT(11) DEFAULT NULL,
  `p_Des` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`pet_Id`)
);

DROP TABLE IF EXISTS `VeterinaryCare`;
create table VeterinaryCare (
care_id INT not Null AUTO_INCREMENT,
survice_id INT not Null,
Ownerssn INT not Null,
CareType varchar(32) DEFAULT NULL,
Description VARCHAR(255) DEFAULT NULL,
NamePet varchar(32) DEFAULT NULL,
petId INT not Null,
TypePet varchar(32) DEFAULT NULL,
primary key(care_id),
FOREIGN KEY (survice_id) REFERENCES Survice(survice_id)
 ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (Ownerssn) REFERENCES Owner(o_ssn)
 ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (petId) REFERENCES Pet(pet_Id)
 ON DELETE CASCADE ON UPDATE CASCADE

);
CREATE TABLE `	Stray_Pet` (

`pet_Id` int(11) NOT NULL,
foreign key (pet_Id) references Pet (pet_Id)
 ON DELETE CASCADE ON UPDATE CASCADE,
 PRIMARY KEY (`pet_Id`)
);
CREATE TABLE `owned_Pet` (

`pet_Id` int(11) NOT NULL,
`o_ssn` int(9) NOT NULL,
foreign key (o_ssn) references Owner (o_ssn)
 ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (pet_Id) references Pet (pet_Id)
 ON DELETE CASCADE ON UPDATE CASCADE,
 PRIMARY KEY (`pet_Id`)
);

CREATE TABLE `Bill` (
  `b_Id` int(11) NOT NULL AUTO_INCREMENT,
  `service_Id` int(11) NOT NULL,
  `o_ssn` int(9) NOT NULL,
  `date` DATE NOT NULL,
  `total_price` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`b_Id`),
 ## FOREIGN KEY (`service_Id`) REFERENCES `Service` (`service_Id`),
  FOREIGN KEY (`o_ssn`) REFERENCES `Owner` (`o_ssn`)
   ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `Owner_Bill` (
  `o_ssn` int(9) NOT NULL,
  `b_Id` int(11) NOT NULL,
  FOREIGN KEY (`o_ssn`) REFERENCES `Owner` (`o_ssn`)
   ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`b_Id`) REFERENCES `Bill` (`b_Id`)
   ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`o_ssn`, `b_Id`)
);

CREATE TABLE `Owner_OwnedPet` (
  `o_ssn` int(9) NOT NULL,
  `pet_Id` int(11) NOT NULL,
  FOREIGN KEY (`o_ssn`) REFERENCES `Owner` (`o_ssn`)
   ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`pet_Id`) REFERENCES `owned_Pet` (`pet_Id`)
   ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`o_ssn`, `pet_Id`)
);

DROP TABLE IF EXISTS `Room`;
create table Room(
Room_Num INT not Null AUTO_INCREMENT,
Room_availability boolean default true,
primary key(Room_Num)
);
DROP TABLE IF EXISTS `Housing`;
create table Housing(
housing_id INT not Null AUTO_INCREMENT,
Ownerssn INT not Null,
survice_id INT not Null,
Description VARCHAR(255) DEFAULT NULL,
Namepet varchar(32) DEFAULT NULL,
petid INT not Null,
Typepet varchar(32) DEFAULT NULL,
ToDate VARCHAR(32) DEFAULT NULL,
fromDate VARCHAR(32) DEFAULT NULL,
RoomNum INT not Null,
PRIMARY KEY (housing_id),
FOREIGN KEY (survice_id) REFERENCES Survice(survice_id)
 ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (RoomNum) REFERENCES Room(Room_Num)
 ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (Ownerssn) REFERENCES Owner(o_ssn)
 ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (petId) REFERENCES Pet(pet_Id)
 ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Treatment;
CREATE TABLE Treatment (
  treatment_id int(11) NOT NULL AUTO_INCREMENT,
  survice_id int(11) 	NOT NULL,
  owner_ssn int(11) DEFAULT NULL,
  p_id int(11) NOT NULL,
  p_Name varchar(32) DEFAULT NULL,
  p_Type varchar(32) DEFAULT NULL,
  p_Breed varchar(32) DEFAULT NULL,
  p_weight int(11) default NULL,
  PRIMARY KEY (treatment_id),
  FOREIGN KEY (survice_id) REFERENCES Survice(survice_id)
   ON DELETE CASCADE ON UPDATE CASCADE
) ;

  DROP TABLE IF EXISTS Medicine;
CREATE TABLE Medicine (
    medicine_id INT(11) NOT NULL,
    medicine_name VARCHAR(32) DEFAULT NULL,
    medicine_Type VARCHAR(32) DEFAULT NULL,
    quantity INT(11) DEFAULT NULL,
    factory VARCHAR(32) DEFAULT NULL,
    price INT(11) DEFAULT NULL,
    expiry_date VARCHAR(32) DEFAULT NULL,
    PRIMARY KEY (medicine_id)
);
DROP TABLE IF EXISTS Diagnosis;
CREATE TABLE Diagnosis (
  treatment_id int(11) NOT NULL,
  medicine_id int(11) NOT NULL,
  description varchar(32) DEFAULT NULL,  
  PRIMARY KEY (treatment_id, medicine_id),  -- Composite primary key
  FOREIGN KEY (treatment_id) REFERENCES Treatment(treatment_id)
   ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (medicine_id) REFERENCES Medicine(medicine_id)
 ON DELETE CASCADE ON UPDATE CASCADE
);

-- Dummy data for Employees table
INSERT INTO Employees (e_ssn, e_name, e_email, e_Role, e_phoneNum, e_salary, e_password)
VALUES
(111111111, 'John Doe', 'john.doe@example.com', 'Admin', '555-1111', 60000, 'password123'),
(222222222, 'Jane Smith', 'jane.smith@example.com', 'Vet', '555-2222', 70000, 'pass456'),
(333333333, 'Alice Johnson', 'alice.johnson@example.com', 'Employee', '555-3333', 50000, 'alicepass'),
(444444444, 'Bob Brown', 'bob.brown@example.com', 'Receptionist', '555-4444', 45000, 'bobpass'),
(555555555, 'Eva White', 'eva.white@example.com', 'Vet', '555-5555', 75000, 'evapass'),
(666666666, 'Michael Davis', 'michael.davis@example.com', 'Admin', '555-6666', 65000, 'michaelpass'),
(777777777, 'Sarah Miller', 'sarah.miller@example.com', 'Vet', '555-7777', 72000, 'sarahpass');

-- Dummy data for Vets table
INSERT INTO Vets (veteran_id, e_ssn)
VALUES
(1, 222222222), -- Jane Smith
(2, 555555555), -- Eva White
(3, 777777777); -- Sarah Miller

-- Dummy data for Survice table
INSERT INTO Survice (survice_type, survice_price, paid)
VALUES
('Routine Checkup', 50, TRUE),
('Vaccination', 30, FALSE),
('Surgery', 200, TRUE),
('Dental Cleaning', 80, FALSE),
('Grooming', 40, TRUE),
('X-Ray', 100, FALSE),
('Boarding', 150, TRUE);


-- Dummy data for Owner table
INSERT INTO Owner (o_ssn, o_name, o_phoneNum, o_email, pet_ID)
VALUES
(123456789, 'John Doe', '0591234567', 'john.doe@gmail.com', 12345),
(987654321, 'Jane Smith', '0569876543', 'jane.smith.email@yahoo.com', 67890),
(111223344, 'Alice Johnson', '0598765432', 'alice.johnson.email@gmail.com', 54321),
(444555666, 'Bob Brown', '0562345678', 'bob.brown@yahoo.com', 98765),
(555666777, 'Eva White', '0597654321', 'eva.white.email@gmail.com', 11111),
(888999000, 'Michael Davis', '0563456789', 'michael.davis.email@yahoo.com', 22222),
(333444555, 'Sarah Miller', '0598765430', 'sarah.miller.email@gmail.com', 33333);


-- Dummy data for Pet table
INSERT INTO Pet (p_Name, p_Type, p_Breed, p_BirthOfDate, p_Weight, p_Des)
VALUES
('Looz', 'Cat', 'Turkish Angora', '2021-01-05', 5, 'None'),
('Blue', 'Cat', 'Turkish Angora', '2020-03-10', 4, 'Severe Immunodeficiency'),
('Kabuki', 'Cat', 'British', '2018-07-15', 6, 'Diabetes'),
('Simba', 'Dog', 'Golden Retriever', '2019-05-20', 5, 'None'),
('Sasha', 'Dog', 'Husky', '2020-09-12', 14, 'None'),
('Max', 'Cat', 'Siamese', '2022-02-28', 3, 'None'),
('Bella', 'Dog', 'Labrador Retriever', '2021-11-01', 12, 'Arthritis');

-- Dummy data for VeterinaryCare table
INSERT INTO VeterinaryCare (survice_id, Ownerssn, CareType, Description, NamePet, petId, TypePet)
VALUES
(1, 123456789, 'Routine Checkup', 'Annual checkup for the pet', 'Looz', 1, 'Cat'),
(2, 987654321, 'Vaccination', 'Annual vaccination for the pet', 'Blue', 2, 'Cat'),
(3, 111223344, 'Surgery', 'Spaying surgery for the pet', 'Kabuki', 3, 'Cat'),
(4, 444555666, 'Dental Cleaning', 'Teeth cleaning for the pet', 'Simba', 4, 'Dog'),
(5, 555666777, 'Grooming', 'Bathing and grooming services', 'Sasha', 5, 'Dog'),
(6, 888999000, 'X-Ray', 'Diagnostic X-ray for the pet', 'Max', 6, 'Cat'),
(7, 333444555, 'Boarding', 'Pet boarding service', 'Bella', 7, 'Dog');

-- Dummy data for Bill table
INSERT INTO Bill (service_Id, o_ssn, date, total_price)
VALUES
(1, 123456789, '2024-01-15', 50),
(2, 987654321, '2024-01-20', 30),
(3, 111223344, '2024-01-25', 200),
(4, 444555666, '2024-02-05', 80),
(5, 555666777, '2024-02-10', 40),
(6, 888999000, '2024-02-15', 100),
(7, 333444555, '2024-02-20', 150);

-- Dummy data for Room table
INSERT INTO Room (Room_Num, Room_availability)
VALUES
(101, false),
(102, false),
(103, false),
(104, false),
(105, true),
(106, true),
(107, true);


-- Dummy data for Housing table
INSERT INTO Housing (Ownerssn, survice_id, Description, Namepet, petid, Typepet, ToDate, fromDate, RoomNum)
VALUES
(123456789, 3, 'Pet boarding service', 'Looz', 1, 'Cat', '2024-02-01', '2024-02-10', 102),
(987654321, 1, 'Pet boarding service', 'Blue', 2, 'Cat', '2024-03-15', '2024-03-25', 103),
(111223344, 5, 'Pet boarding service', 'Kabuki', 3, 'Cat', '2024-04-05', '2024-04-15', 104),
(444555666, 7, 'Pet boarding service', 'Simba', 4, 'Dog', '2024-05-01', '2024-05-10', 101);