-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2023 at 12:03 PM
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
-- Database: `tanahabangmarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` varchar(200) NOT NULL,
  `name_product` varchar(200) NOT NULL,
  `jenis_barang` varchar(200) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `name_product`, `jenis_barang`, `price`) VALUES
('1', 'Smart  Mirror', 'Elektronik', 500000),
('2', 'PDH HMPSTI JOSS', 'Fashion', 1000000),
('3', 'Sepatu Super', 'Olahraga', 250000),
('4', 'Kacamata XRay', 'Aksesoris', 3000000);

-- --------------------------------------------------------

--
-- Table structure for table `transanction`
--

CREATE TABLE `transanction` (
  `transanction_id` varchar(200) NOT NULL,
  `ID` varchar(200) NOT NULL,
  `product_id` varchar(200) NOT NULL,
  `create_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transanction`
--

INSERT INTO `transanction` (`transanction_id`, `ID`, `product_id`, `create_date`) VALUES
('a69fd842-42f7-472e-b15e-cd0b766fb36d', 'TA-100', '1', '2023-12-22 16:07:25'),
('eae3b8bd-f9a0-4283-9dc7-099fae77caa0', 'TA-201', '1', '2023-12-22 15:41:01');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `name`, `no_hp`, `email`, `password`) VALUES
('TA-100', 'mr hecka', '085123971287', 'mrhecka@macroma.com', 'thisiscoding'),
('TA-201', 'koozee', '08139839393', 'koozee@yahoo.com', 'kozenihbos');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `transanction`
--
ALTER TABLE `transanction`
  ADD PRIMARY KEY (`transanction_id`),
  ADD KEY `fk_user_id` (`ID`),
  ADD KEY `fk_product_id` (`product_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID` (`ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transanction`
--
ALTER TABLE `transanction`
  ADD CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`ID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
