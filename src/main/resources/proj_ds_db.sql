-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2022 at 04:01 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proj_ds_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_entity`
--

CREATE TABLE `customer_entity` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_entity`
--

INSERT INTO `customer_entity` (`id`, `active`, `contact`, `delivery_address`, `name`) VALUES
(1, b'0', 'Tozeur, Tunis', 'Bizert', 'Nadher Arroum'),
(2, b'1', 'Tozeur, Tunis', 'Bizert', 'Arroum Nadher');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_entity`
--

CREATE TABLE `delivery_entity` (
  `id` int(11) NOT NULL,
  `delivery_date` date DEFAULT NULL,
  `delivery_man` varchar(255) DEFAULT NULL,
  `shopping_date` date DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `delivery_entity`
--

INSERT INTO `delivery_entity` (`id`, `delivery_date`, `delivery_man`, `shopping_date`, `order_id`) VALUES
(1, '2021-12-29', 'Arroum', '2021-12-27', 1);

-- --------------------------------------------------------

--
-- Table structure for table `item_entity`
--

CREATE TABLE `item_entity` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `weight` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_entity`
--

INSERT INTO `item_entity` (`id`, `description`, `price`, `weight`) VALUES
(1, 'PIZZA', 10, 0.5),
(2, 'HAMBURGER', 6, 0.3),
(3, 'Dorad', 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail_entity`
--

CREATE TABLE `orderdetail_entity` (
  `id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `tax` float NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdetail_entity`
--

INSERT INTO `orderdetail_entity` (`id`, `qty`, `tax`, `item_id`, `order_id`) VALUES
(1, 2, 0.2, 1, 1),
(2, 5, 0.2, 2, 2),
(3, 3, 0.2, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `order_entity`
--

CREATE TABLE `order_entity` (
  `id` int(11) NOT NULL,
  `create_date` date DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_entity`
--

INSERT INTO `order_entity` (`id`, `create_date`, `customer_id`, `order_status`) VALUES
(1, '2021-12-28', 1, 'CREATE'),
(2, '2021-12-28', 2, 'CREATE'),
(3, '2021-12-31', 1, 'CREATE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_entity`
--
ALTER TABLE `customer_entity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `delivery_entity`
--
ALTER TABLE `delivery_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdhpq651n6s9on39lmra6mh44y` (`order_id`);

--
-- Indexes for table `item_entity`
--
ALTER TABLE `item_entity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderdetail_entity`
--
ALTER TABLE `orderdetail_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6fgd7vv481a0459yvbasaw9dl` (`item_id`),
  ADD KEY `FKj2cjv435aoqtbnx1k6o3jfytp` (`order_id`);

--
-- Indexes for table `order_entity`
--
ALTER TABLE `order_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsf8a6lp9q1tiped5qo7uojfcm` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_entity`
--
ALTER TABLE `customer_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `delivery_entity`
--
ALTER TABLE `delivery_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `item_entity`
--
ALTER TABLE `item_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `orderdetail_entity`
--
ALTER TABLE `orderdetail_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order_entity`
--
ALTER TABLE `order_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery_entity`
--
ALTER TABLE `delivery_entity`
  ADD CONSTRAINT `FKdhpq651n6s9on39lmra6mh44y` FOREIGN KEY (`order_id`) REFERENCES `order_entity` (`id`);

--
-- Constraints for table `orderdetail_entity`
--
ALTER TABLE `orderdetail_entity`
  ADD CONSTRAINT `FK6fgd7vv481a0459yvbasaw9dl` FOREIGN KEY (`item_id`) REFERENCES `item_entity` (`id`),
  ADD CONSTRAINT `FKj2cjv435aoqtbnx1k6o3jfytp` FOREIGN KEY (`order_id`) REFERENCES `order_entity` (`id`);

--
-- Constraints for table `order_entity`
--
ALTER TABLE `order_entity`
  ADD CONSTRAINT `FKsf8a6lp9q1tiped5qo7uojfcm` FOREIGN KEY (`customer_id`) REFERENCES `customer_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
