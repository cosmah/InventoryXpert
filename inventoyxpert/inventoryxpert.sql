-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2023 at 09:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventoryxpert`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_contact_person` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `customer_tin` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `customer_address`, `customer_contact_person`, `customer_email`, `customer_name`, `customer_phone`, `customer_tin`, `employee_id`) VALUES
(1, 'MUTUNGO', 'ELVIS', 'hector2345@yahoo.com', 'HECTOR', '0787389288', 1002377678, 102),
(3, 'energy center', 'ERIC', 'hassanmwanaisha64@gmail.com', 'Zaina Trisha', '0758842341', 1074775378, 1),
(4, 'NAKASERO', 'ZAINA', 'matovubazirio@gmail.com', 'MATOVU', '0723456789', 1124867894, 102),
(5, 'ELECTRICAL PLAZA', 'WILBER', 'sarthur@gmail.com', 'ARTHUR', '0701247773', 1000023476, 1),
(52, 'OLD TAXI PARK', 'COLLIN', 'katazastores@gmail.com', 'KATAZA', '075678922', 1100110013, 102),
(102, NULL, 'COLLIN', NULL, 'BRIDGET', '0775667288', 0, 2),
(152, '', NULL, 'aronandsons@gamil.com', 'ARON', '0758842341', 0, 2),
(202, '', NULL, '', 'BEN', '', 0, 102);

-- --------------------------------------------------------

--
-- Table structure for table `customer_seq`
--

CREATE TABLE `customer_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_seq`
--

INSERT INTO `customer_seq` (`next_val`) VALUES
(301);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `employee_date_of_birth` date DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_gender` varchar(255) DEFAULT NULL,
  `employee_marital_status` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_nationality` varchar(255) DEFAULT NULL,
  `employee_next_of_kin` varchar(255) DEFAULT NULL,
  `employee_next_of_kin_address` varchar(255) DEFAULT NULL,
  `employee_next_of_kin_gender` varchar(255) DEFAULT NULL,
  `employee_next_of_kin_occupation` varchar(255) DEFAULT NULL,
  `employee_next_of_kin_phone` varchar(255) DEFAULT NULL,
  `employee_next_of_kin_relationship` varchar(255) DEFAULT NULL,
  `employee_occupation` varchar(255) DEFAULT NULL,
  `employee_phone` varchar(255) DEFAULT NULL,
  `employee_state_of_origin` varchar(255) DEFAULT NULL,
  `employee_tin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `employee_address`, `employee_date_of_birth`, `employee_email`, `employee_gender`, `employee_marital_status`, `employee_name`, `employee_nationality`, `employee_next_of_kin`, `employee_next_of_kin_address`, `employee_next_of_kin_gender`, `employee_next_of_kin_occupation`, `employee_next_of_kin_phone`, `employee_next_of_kin_relationship`, `employee_occupation`, `employee_phone`, `employee_state_of_origin`, `employee_tin`) VALUES
(1, 'NAJJANANKUMBI', '1996-12-10', '	', 'MALE', 'SINGLE', 'JOHN', 'UGANDAN', 'SHARON', 'NAMASUBA', 'FEMALE', 'NURSE', NULL, 'MOTHER', 'SALESMAN', '0774899297', 'KYADONDO', 0),
(2, 'KITINTALE', '1993-12-07', 'jacfrost06@gmail.com', 'MALE', 'SINGLE', 'COSMAH', 'UGANDAN', 'JONATHAN', 'BUGOLOBI', 'MALE', 'MECHANIC', '0758842341', 'BROTHER', 'SALESMAN', '0773893999', 'KYADONDO', 0),
(52, 'BWEYOGERERE', '1990-02-23', '', 'Female', 'Other', 'FIONAH', 'UGANDA', 'BAGUMA', 'KIREKA', 'Female', 'SHOP KEEPER', '', 'BROTHER', 'RECEPTIONIST', '', 'BUDDU', 0),
(102, 'MAKINDYE', '1993-01-27', '', 'Male', 'Divorced', 'COLLIN', 'UGANDAN', 'FRANK', 'NTEBE', 'Male', 'COURIER', '076573888', 'BROTHER', 'MARKETEER', '0789949999', 'BUSOGA', 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee_seq`
--

CREATE TABLE `employee_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_seq`
--

INSERT INTO `employee_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `idgenerator`
--

CREATE TABLE `idgenerator` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `idgenerator`
--

INSERT INTO `idgenerator` (`next_val`) VALUES
(1000);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `invoice_number` varchar(255) DEFAULT NULL,
  `payment_terms` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `total_sales` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `customer_address`, `customer_name`, `invoice_date`, `invoice_number`, `payment_terms`, `total_amount`, `contact_person`, `expiry_date`, `total_sales`) VALUES
(1, 'kitintale', 'joyce', NULL, 'in1234567', 'net 2', 250000, NULL, NULL, NULL),
(2, 'mutungo', 'liam', '2023-11-22', 'in098765', 'net 2', 34567800, NULL, NULL, NULL),
(3, 'NAKASERO', 'HEIDI', '2023-11-22', 'INV0002', 'NET 3', 67000, NULL, NULL, NULL),
(4, 'KATIKAMU', 'VAN NESSA', '2023-11-22', 'INV0003', 'NET4', 90000, NULL, NULL, NULL),
(52, 'KATIKAMU', 'ALAN', '2023-11-23', 'inv345678', 'NET 5', 13000, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `invoice_invoice_lines`
--

CREATE TABLE `invoice_invoice_lines` (
  `invoice_id` bigint(20) NOT NULL,
  `invoice_lines_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice_line`
--

CREATE TABLE `invoice_line` (
  `id` bigint(20) NOT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `unit_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice_line_seq`
--

CREATE TABLE `invoice_line_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice_line_seq`
--

INSERT INTO `invoice_line_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `invoice_seq`
--

CREATE TABLE `invoice_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice_seq`
--

INSERT INTO `invoice_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `starting_date` datetime(6) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `resale_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `price`, `product_code`, `product_description`, `product_name`, `quantity`, `starting_date`, `supplier`, `resale_price`) VALUES
(1, 125000, '56-1000 WH', 'LED SOLAR FLOODLIGHT WHITE', 'NEELUX FLOOD LIGHTS', 39, '2023-11-25 00:00:00.000000', 'NEELUX', 180000),
(2, 1200, '47-0700 WH', 'LED BULB 7W WHITE', 'NEELUX BULB', 1000, '2023-11-25 00:00:00.000000', 'NEELUX', 5000),
(3, 170000, 'NL-5050-2-RGB', 'STRIP LIGHT RGB DOUBLE EYE', 'NEELUX STRIP LIGHT', 500, '2023-11-25 00:00:00.000000', 'NEELUX', 225000),
(4, 80000, '1.50MM RED', 'COPA REY WIRE RED', 'COPA REY WIRE', 500, '2023-11-25 00:00:00.000000', 'COPA REY', 150000),
(5, 1000, '47-0500 B22 WH', 'LED BULB 5W PIN WHITE', 'NEELUX BULB', 5000, '2023-11-25 00:00:00.000000', 'NEELUX', 4500),
(52, 11000, 'DP-3920', 'RECHARGEABLE DP BULB 20W', 'EMERGENCY LAMP', 204, '2023-11-28 00:00:00.000000', 'DP LIGHT', 30000),
(53, 6000, '40-4001 E27', 'LED FILAMENT BULB 4W', 'FILAMENT BULB', 200, '2023-11-30 00:00:00.000000', 'NEELUX', 15000),
(54, 6500, '32-0600 WH', 'LED PANEL LAMP 6W', 'PANEL LAMP', 2000, '2023-11-28 00:00:00.000000', 'NEELUX', 30000),
(102, 6000, 'SL18', 'MAGNETIC HEADSET', 'EARBUDS WIRELESS', 1000, '2023-12-10 00:00:00.000000', 'SKY DOLPHIN', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `sample_person`
--

CREATE TABLE `sample_person` (
  `id` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `important` bit(1) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sample_person`
--

INSERT INTO `sample_person` (`id`, `version`, `date_of_birth`, `email`, `first_name`, `important`, `last_name`, `occupation`, `phone`, `role`) VALUES
(1, 1, '1954-04-16', 'eula.lane@jigrormo.ye', 'Eula', b'0', 'Lane', 'Insurance Clerk', '(762) 526-5961', 'Worker'),
(2, 1, '2013-04-16', 'barry.rodriquez@zun.mm', 'Barry', b'0', 'Rodriquez', 'Mortarman', '(267) 955-5124', 'Manager'),
(3, 1, '1973-04-01', 'eugenia.selvi@capfad.vn', 'Eugenia', b'0', 'Selvi', 'Beer Coil Cleaner', '(680) 368-2192', 'External'),
(4, 1, '2013-05-19', 'alejandro.miles@dec.bn', 'Alejandro', b'0', 'Miles', 'Scale Attendant', '(281) 301-2039', 'Worker'),
(5, 1, '1971-07-17', 'cora.tesi@bivo.yt', 'Cora', b'0', 'Tesi', 'Clinical Audiologist', '(600) 616-7955', 'Supervisor'),
(6, 1, '1937-04-13', 'marguerite.ishii@judbilo.gn', 'Marguerite', b'0', 'Ishii', 'Parking Meter Collector', '(882) 813-1374', 'Supervisor'),
(7, 1, '1966-11-16', 'mildred.jacobs@joraf.wf', 'Mildred', b'0', 'Jacobs', 'Business Unit Manager', '(642) 665-1763', 'Manager'),
(8, 1, '2009-09-26', 'gene.goodman@kem.tl', 'Gene', b'0', 'Goodman', 'Technical Communicator', '(383) 458-2132', 'External'),
(9, 1, '1958-12-01', 'lettie.bennett@odeter.bb', 'Lettie', b'0', 'Bennett', 'Correctional Officer Sergeant', '(769) 335-6771', 'Worker'),
(10, 1, '1945-11-07', 'mabel.leach@lisohuje.vi', 'Mabel', b'0', 'Leach', 'Food Chemist', '(803) 586-8035', 'Supervisor'),
(11, 1, '1981-12-19', 'jordan.miccinesi@duod.gy', 'Jordan', b'0', 'Miccinesi', 'Signals Intelligence/Electronic Warfare Chief', '(531) 919-2280', 'Manager'),
(12, 1, '1942-10-20', 'marie.parkes@nowufpus.ph', 'Marie', b'0', 'Parkes', 'Language Pathologist', '(814) 667-8937', 'External'),
(13, 1, '1957-10-19', 'rose.gray@kagu.hr', 'Rose', b'0', 'Gray', 'Wildlife Officer', '(713) 311-8766', 'Worker'),
(14, 1, '2008-07-30', 'garrett.stokes@fef.bg', 'Garrett', b'0', 'Stokes', 'Bindery Machine Operator', '(381) 421-2371', 'Manager'),
(15, 1, '1929-07-26', 'barbara.matthieu@derwogi.jm', 'Barbara', b'0', 'Matthieu', 'Instructional Aide', '(940) 463-7299', 'External'),
(16, 1, '1949-01-02', 'jean.rhodes@wehovuce.gu', 'Jean', b'0', 'Rhodes', 'Clinical Psychiatrist', '(777) 435-9570', 'Worker'),
(17, 1, '1974-10-29', 'jack.romoli@zamum.bw', 'Jack', b'0', 'Romoli', 'Mortician Investigator', '(517) 393-9630', 'Supervisor'),
(18, 1, '1949-02-23', 'pearl.holden@dunebuh.cr', 'Pearl', b'0', 'Holden', 'Rod Buster Helper', '(711) 904-3669', 'Manager'),
(19, 1, '1932-03-18', 'belle.montero@repiwid.si', 'Belle', b'0', 'Montero', 'Classroom Aide', '(935) 404-4792', 'External'),
(20, 1, '1933-09-28', 'olive.molina@razuppa.ga', 'Olive', b'0', 'Molina', 'Traditional Chinese Herbalist', '(935) 267-8492', 'Worker'),
(21, 1, '1950-03-01', 'minerva.todd@kulmenim.ad', 'Minerva', b'0', 'Todd', 'Electronic Drafter', '(763) 948-4815', 'Supervisor'),
(22, 1, '2014-07-24', 'bobby.pearson@ib.kg', 'Bobby', b'1', 'Pearson', 'Vault Teller', '(238) 240-2561', 'Worker'),
(23, 1, '1995-08-09', 'larry.ciappi@ba.lk', 'Larry', b'0', 'Ciappi', 'Fire Sprinkler Installer', '(410) 257-1723', 'Supervisor'),
(24, 1, '1974-02-10', 'ronnie.salucci@tohhij.lv', 'Ronnie', b'0', 'Salucci', 'Brewery Pumper', '(566) 726-3346', 'Manager'),
(25, 1, '1987-03-31', 'walter.grossi@tuvo.sa', 'Walter', b'0', 'Grossi', 'Kitchen Chef', '(416) 906-7221', 'External'),
(26, 1, '1966-05-22', 'frances.koopmans@foga.tw', 'Frances', b'0', 'Koopmans', 'Medical Esthetician', '(611) 712-1562', 'Worker'),
(27, 1, '1935-10-26', 'frances.fujimoto@uswuzzub.jp', 'Frances', b'0', 'Fujimoto', 'Auto Tire Worker', '(919) 887-8542', 'Supervisor'),
(28, 1, '1933-02-02', 'olivia.vidal@hivwerip.vc', 'Olivia', b'0', 'Vidal', 'Semi-Truck Driver', '(982) 684-7650', 'Manager'),
(29, 1, '1946-12-17', 'edna.henry@gugusu.rw', 'Edna', b'0', 'Henry', 'Command And Control', '(811) 931-8202', 'External'),
(30, 1, '1929-01-29', 'lydia.brun@zedekak.md', 'Lydia', b'0', 'Brun', 'Drywall Hanger', '(927) 400-3928', 'Worker'),
(31, 1, '2009-02-16', 'jay.blake@ral.mk', 'Jay', b'0', 'Blake', 'Real Property Evaluator', '(365) 345-1498', 'Manager'),
(32, 1, '1973-02-24', 'isabel.serafini@turuhu.bh', 'Isabel', b'0', 'Serafini', 'Human Performance Professor', '(656) 968-9869', 'Manager'),
(33, 1, '1958-09-13', 'rebecca.carter@omjo.et', 'Rebecca', b'0', 'Carter', 'V/Stol Landing Signal Officer', '(739) 612-6585', 'External'),
(34, 1, '1992-07-19', 'maurice.fabbrini@rig.bh', 'Maurice', b'0', 'Fabbrini', 'Air Control/Anti-Air Warfare Officer', '(485) 521-2687', 'Supervisor'),
(35, 1, '1944-03-15', 'ollie.turnbull@sicewap.org', 'Ollie', b'0', 'Turnbull', 'General Superintendent', '(835) 620-3330', 'Manager'),
(36, 1, '2014-04-09', 'jerry.hopkins@fo.mh', 'Jerry', b'1', 'Hopkins', 'Child Protective Services Social Worker', '(211) 851-5960', 'External'),
(37, 1, '1945-01-21', 'nora.lyons@gegijap.na', 'Nora', b'0', 'Lyons', 'Lens Grinder and Polisher', '(811) 311-5257', 'Worker'),
(38, 1, '1940-08-09', 'anne.weiß@kuvesa.pe', 'Anne', b'0', 'Weiß', 'Civil Engineering Professor', '(843) 836-3759', 'Worker'),
(39, 1, '1929-11-19', 'louise.gauthier@lapahu.mt', 'Louise', b'0', 'Gauthier', 'Mobile Home Servicer', '(913) 235-1856', 'Supervisor'),
(40, 1, '1991-10-24', 'lloyd.fani@zev.ru', 'Lloyd', b'0', 'Fani', 'Floor Refinisher', '(467) 487-7239', 'Supervisor'),
(41, 1, '1955-01-15', 'maud.dunn@nabeaga.ni', 'Maud', b'0', 'Dunn', 'Senior Sales Associate', '(724) 340-3634', 'Manager'),
(42, 1, '1988-03-19', 'henry.gigli@kaot.ps', 'Henry', b'0', 'Gigli', 'Tile Designer', '(413) 229-8428', 'Worker'),
(43, 1, '1941-04-28', 'virgie.werner@tawuctuj.cf', 'Virgie', b'0', 'Werner', 'Econometrics Professor', '(886) 292-9749', 'Supervisor'),
(44, 1, '1994-02-19', 'gregory.cozzi@eh.ru', 'Gregory', b'0', 'Cozzi', 'Basketball Player', '(418) 472-1239', 'Manager'),
(45, 1, '1934-02-10', 'lucinda.gil@fajjusuz.kr', 'Lucinda', b'0', 'Gil', 'Indirect Fire Infantryman', '(961) 233-3461', 'External'),
(46, 1, '1964-02-24', 'gertrude.verbeek@pave.cc', 'Gertrude', b'0', 'Verbeek', 'Licensed Esthetician', '(605) 226-4037', 'Worker'),
(47, 1, '1956-12-22', 'mattie.graham@ispaviw.gt', 'Mattie', b'0', 'Graham', 'Antisubmarine Warfare Intelligence Officer', '(719) 765-1705', 'Supervisor'),
(48, 1, '2018-08-18', 'bryan.shaw@ha.ee', 'Bryan', b'1', 'Shaw', 'Research Assistant', '(232) 228-5539', 'Manager'),
(49, 1, '1958-02-27', 'essie.adams@iliat.cw', 'Essie', b'0', 'Adams', 'Cigar Roller', '(768) 554-8377', 'External'),
(50, 1, '2008-12-16', 'gary.osborne@do.ga', 'Gary', b'0', 'Osborne', 'Customer Support Representative', '(311) 731-7079', 'Worker'),
(51, 1, '2014-07-28', 'richard.silva@wi.lc', 'Richard', b'1', 'Silva', 'Programmer', '(207) 554-6244', 'Manager'),
(52, 1, '1977-12-01', 'dustin.pestelli@iwage.la', 'Dustin', b'0', 'Pestelli', 'Global Engineering Manager', '(558) 913-2855', 'Manager'),
(53, 1, '1943-09-25', 'henrietta.hilton@joopoju.pn', 'Henrietta', b'0', 'Hilton', 'Telegraph and Teletype Operator', '(832) 759-6654', 'External'),
(54, 1, '1988-03-03', 'francisco.giordano@gojawu.tn', 'Francisco', b'0', 'Giordano', 'Hairpiece Stylist', '(482) 736-8079', 'Manager'),
(55, 1, '1973-08-22', 'cynthia.sardi@afigoh.mm', 'Cynthia', b'0', 'Sardi', 'Tobacco Buyer', '(677) 345-2680', 'External'),
(56, 1, '1971-06-19', 'lula.testi@benom.tj', 'Lula', b'0', 'Testi', 'Marine Steamfitter', '(610) 374-7581', 'Worker'),
(57, 1, '1928-11-27', 'bess.lucas@jevakbe.cd', 'Bess', b'0', 'Lucas', 'Attending Anesthesiologist', '(982) 583-8067', 'Supervisor'),
(58, 1, '1967-08-28', 'linnie.driessen@darhow.tr', 'Linnie', b'0', 'Driessen', 'Certified Indoor Environmentalist', '(680) 266-3167', 'External'),
(59, 1, '1971-07-10', 'eva.tesi@dupid.cf', 'Eva', b'0', 'Tesi', 'Land Management Forester', '(611) 955-4652', 'Worker'),
(60, 1, '1936-04-16', 'augusta.sakai@comouc.ee', 'Augusta', b'0', 'Sakai', 'Digital Proofing and Platemaker', '(940) 714-8088', 'Worker'),
(61, 1, '1941-08-10', 'mathilda.schwarz@igunisi.ao', 'Mathilda', b'0', 'Schwarz', 'Public Health Veterinarian', '(868) 481-5125', 'Manager'),
(62, 1, '2017-01-18', 'joe.riley@pe.vu', 'Joe', b'1', 'Riley', 'Statement Processor', '(225) 395-2772', 'External'),
(63, 1, '2010-11-04', 'leon.mcgee@puk.se', 'Leon', b'0', 'McGee', 'Computer Applications Developer', '(365) 837-6888', 'Worker'),
(64, 1, '1969-08-27', 'florence.viviani@vegub.no', 'Florence', b'0', 'Viviani', 'African History Professor', '(606) 352-8734', 'Supervisor'),
(65, 1, '1981-11-30', 'lee.miceli@rucwi.pf', 'Lee', b'0', 'Miceli', 'Gastroenterology Professor', '(555) 800-7339', 'Manager'),
(66, 1, '1972-09-22', 'celia.sodi@agijit.iq', 'Celia', b'0', 'Sodi', 'Laboratory Animal Caretaker', '(657) 357-3671', 'External'),
(67, 1, '1981-08-24', 'aaron.misuri@loolu.lu', 'Aaron', b'0', 'Misuri', 'Water Pump Installer', '(523) 789-5485', 'Worker'),
(68, 1, '1949-06-05', 'fanny.parkinson@tupwovali.cw', 'Fanny', b'0', 'Parkinson', 'Orthopedic Cast Specialist', '(766) 966-7387', 'Supervisor'),
(69, 1, '1969-10-06', 'phoebe.vitale@hidge.fo', 'Phoebe', b'0', 'Vitale', 'Budget Coordinator', '(672) 613-2954', 'Manager'),
(70, 1, '1948-03-17', 'edith.brennan@liowci.ir', 'Edith', b'0', 'Brennan', 'Railroad Engineer', '(803) 549-9387', 'Manager'),
(71, 1, '1983-09-20', 'jeremy.marilli@vesa.pf', 'Jeremy', b'0', 'Marilli', 'Chief Projectionist', '(526) 435-1819', 'External'),
(72, 1, '1927-03-09', 'kathryn.huet@wupikdoh.by', 'Kathryn', b'0', 'Huet', 'Telecasting Engineer', '(937) 855-5936', 'Worker'),
(73, 1, '1935-03-20', 'lelia.matsuo@dajsiphaj.az', 'Lelia', b'0', 'Matsuo', 'Drama Therapist', '(960) 335-6192', 'Supervisor'),
(74, 1, '1954-12-26', 'virginia.woods@soofpe.ht', 'Virginia', b'0', 'Woods', 'General Superintendent', '(735) 809-2611', 'Manager'),
(75, 1, '1937-02-26', 'sally.aoki@aruzusjas.tc', 'Sally', b'0', 'Aoki', 'Technical Communicator', '(857) 797-7918', 'External'),
(76, 1, '1962-12-13', 'isabelle.deridder@ufeco.in', 'Isabelle', b'0', 'de Ridder', 'Leisure Studies Professor', '(659) 331-1543', 'Worker'),
(77, 1, '1958-06-15', 'rosie.murphy@uneehi.id', 'Rosie', b'0', 'Murphy', 'Air Conditioning Service Technician', '(759) 639-8597', 'Supervisor'),
(78, 1, '1929-03-10', 'lou.meyer@hahinaba.gm', 'Lou', b'0', 'Meyer', 'Business Unit Manager', '(942) 352-4854', 'External'),
(79, 1, '2012-07-04', 'rodney.love@zun.ph', 'Rodney', b'0', 'Love', 'Job Estimator', '(247) 867-8287', 'Worker'),
(80, 1, '2001-06-26', 'kenneth.bianchini@jo.ws', 'Kenneth', b'0', 'Bianchini', 'Correctional Officer Sergeant', '(302) 793-9936', 'Worker'),
(81, 1, '1939-02-26', 'essie.dietrich@goltuefo.mn', 'Essie', b'0', 'Dietrich', 'Parking Meter Collector', '(861) 740-6628', 'Supervisor'),
(82, 1, '1930-11-23', 'leila.simon@lupuwuzo.gw', 'Leila', b'0', 'Simon', 'Signals Intelligence/Electronic Warfare Chief', '(953) 866-9992', 'External'),
(83, 1, '1927-12-05', 'eva.pierre@reduzris.ee', 'Eva', b'0', 'Pierre', 'Clinical Psychiatrist', '(915) 491-8384', 'Worker'),
(84, 1, '1981-03-09', 'landon.moretti@pubsav.sk', 'Landon', b'0', 'Moretti', 'Wildlife Officer', '(584) 909-6235', 'Supervisor'),
(85, 1, '1973-08-17', 'mittie.sardi@lullip.nf', 'Mittie', b'0', 'Sardi', 'Food Chemist', '(673) 849-4256', 'Manager'),
(86, 1, '2012-10-21', 'corey.mcdaniel@aba.tc', 'Corey', b'0', 'McDaniel', 'Advanced Foreign Counterintelligence Specialist (Afcs)', '(268) 208-9643', 'Supervisor'),
(87, 1, '1939-08-14', 'hester.stein@kettujwo.eu', 'Hester', b'0', 'Stein', 'Forest Fire Officer', '(873) 489-6641', 'Manager'),
(88, 1, '2013-11-26', 'danny.lowe@ju.sd', 'Danny', b'1', 'Lowe', 'Catalogue Illustrator', '(243) 974-5539', 'External'),
(89, 1, '1945-10-21', 'lillie.winter@vioburez.vi', 'Lillie', b'0', 'Winter', 'Knife Grinder', '(816) 699-1291', 'Worker'),
(90, 1, '2000-08-12', 'brandon.borchi@ig.al', 'Brandon', b'0', 'Borchi', 'Neuropsychiatrist', '(319) 401-1090', 'Supervisor'),
(91, 1, '2002-01-23', 'isaac.bernardi@omu.bj', 'Isaac', b'0', 'Bernardi', 'Bottle Packer', '(359) 691-6408', 'Manager'),
(92, 1, '2019-01-26', 'clyde.crawford@luw.dz', 'Clyde', b'1', 'Crawford', 'Special Education Kindergarten Teacher', '(273) 892-4646', 'External'),
(93, 1, '2008-07-04', 'paul.sherman@pi.cf', 'Paul', b'0', 'Sherman', 'Commercial Art Instructor', '(304) 610-2881', 'Worker'),
(94, 1, '2020-05-01', 'craig.russell@zu.nz', 'Craig', b'1', 'Russell', 'Ferryboat Captain', '(237) 969-2900', 'Supervisor'),
(95, 1, '2013-07-13', 'john.sutton@ag.ee', 'John', b'0', 'Sutton', 'School Social Worker', '(207) 424-6468', 'Manager'),
(96, 1, '1990-06-27', 'francisco.formigli@fopav.tn', 'Francisco', b'0', 'Formigli', 'Joint Terminal Attack Controller', '(481) 661-8179', 'External'),
(97, 1, '2022-07-17', 'gary.baker@ji.cf', 'Gary', b'1', 'Baker', 'VP Sales', '(212) 510-3444', 'Worker'),
(98, 1, '1987-11-25', 'earl.giovannoni@lojet.ge', 'Earl', b'0', 'Giovannoni', 'Auto Service Station Attendant', '(433) 862-3076', 'Manager'),
(99, 1, '1969-04-08', 'helen.zanieri@ukve.tn', 'Helen', b'0', 'Zanieri', 'Healthcare Social Worker', '(619) 506-4452', 'External'),
(100, 1, '1971-04-28', 'agnes.toccafondi@viipo.ae', 'Agnes', b'0', 'Toccafondi', 'Comedian', '(616) 688-6883', 'External');

-- --------------------------------------------------------

--
-- Table structure for table `taxes`
--

CREATE TABLE `taxes` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `taxes_seq`
--

CREATE TABLE `taxes_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taxes_seq`
--

INSERT INTO `taxes_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE `term` (
  `id` bigint(20) NOT NULL,
  `terms_days` int(11) NOT NULL,
  `terms_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `term`
--

INSERT INTO `term` (`id`, `terms_days`, `terms_name`) VALUES
(1, 7, 'NET 2'),
(2, 14, 'NET 15'),
(3, 30, 'NET 30');

-- --------------------------------------------------------

--
-- Table structure for table `terms`
--

CREATE TABLE `terms` (
  `id` bigint(20) NOT NULL,
  `terms_days` int(11) NOT NULL,
  `terms_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `terms_seq`
--

CREATE TABLE `terms_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `terms_seq`
--

INSERT INTO `terms_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `term_seq`
--

CREATE TABLE `term_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `term_seq`
--

INSERT INTO `term_seq` (`next_val`) VALUES
(101);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiv4yye896nrvevqc0vpmmskmn` (`employee_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice_invoice_lines`
--
ALTER TABLE `invoice_invoice_lines`
  ADD UNIQUE KEY `UK_i0h1ahmgaejidunx6gja4vf9t` (`invoice_lines_id`),
  ADD KEY `FKn0cxxhpf13565qtptsyc772r6` (`invoice_id`);

--
-- Indexes for table `invoice_line`
--
ALTER TABLE `invoice_line`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sample_person`
--
ALTER TABLE `sample_person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `taxes`
--
ALTER TABLE `taxes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `term`
--
ALTER TABLE `term`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `terms`
--
ALTER TABLE `terms`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKiv4yye896nrvevqc0vpmmskmn` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `invoice_invoice_lines`
--
ALTER TABLE `invoice_invoice_lines`
  ADD CONSTRAINT `FKf8kat64k63682isvk0g381v15` FOREIGN KEY (`invoice_lines_id`) REFERENCES `invoice_line` (`id`),
  ADD CONSTRAINT `FKn0cxxhpf13565qtptsyc772r6` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
