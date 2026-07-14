-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 14, 2026 at 01:22 PM
-- Server version: 8.4.7
-- PHP Version: 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodbridge_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `claim`
--

DROP TABLE IF EXISTS `claim`;
CREATE TABLE IF NOT EXISTS `claim` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `claimed_at` datetime(6) DEFAULT NULL,
  `status` enum('PENDING','ACCEPTED','PICKED_UP','DELIVERED') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `donation_id` bigint DEFAULT NULL,
  `ngo_id` bigint DEFAULT NULL,
  `volunteer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKt5ed2jcudakqsshybu2f6apee` (`donation_id`),
  KEY `FK1lw05c5njmyfykyfh815aidl6` (`ngo_id`),
  KEY `FKi7roiv0u96i9wqo7am7fws9fk` (`volunteer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `claim`
--

INSERT INTO `claim` (`id`, `claimed_at`, `status`, `donation_id`, `ngo_id`, `volunteer_id`) VALUES
(1, '2026-07-13 16:24:00.152319', 'DELIVERED', 2, NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
CREATE TABLE IF NOT EXISTS `donation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `expiry_time` datetime(6) DEFAULT NULL,
  `food_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pickup_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `status` enum('AVAILABLE','CLAIMED','DELIVERED','EXPIRED','PICKED_UP') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `donor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKauf980vqjbqg2h07p7ggit1x3` (`donor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `donation`
--

INSERT INTO `donation` (`id`, `created_at`, `description`, `expiry_time`, `food_name`, `pickup_address`, `quantity`, `status`, `donor_id`) VALUES
(2, '2026-07-13 16:12:46.025717', 'Freshly Cooked', '2026-07-14 18:00:00.000000', 'Chicken Biryani', 'VIT Vellore', 40, 'CLAIMED', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` enum('ADMIN','DONOR','NGO','VOLUNTEER') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `created_at`, `email`, `full_name`, `password`, `phone_number`, `role`) VALUES
(3, '2026-07-13 16:07:54.329277', 'kaviya@gmail.com', 'Kaviya Srinivasan', '$2a$10$kgR2i7QbB6Yu0fXwqzCZauc0D1KSBaSN/Md4gtl7fwe8ghjYFp2w6', '9876543210', 'DONOR'),
(4, '2026-07-13 16:09:12.752202', 'ngo@gmail.com', 'Helping Hands NGO', '$2a$10$.y42eaSyWaMe/BGK1vpMTOz7IZkZWE.3WhaoMgCygdstoAoPke/CC', '9999999999', 'NGO'),
(5, '2026-07-13 16:09:19.547529', 'volunteer@gmail.com', 'Rahul Kumar', '$2a$10$.z4VmgTf.iSK3jkc8GXPGei2d3Y6lROIe35C5Ht35UB3/I32IB5pK', '8888888888', 'VOLUNTEER');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `claim`
--
ALTER TABLE `claim`
  ADD CONSTRAINT `FK1lw05c5njmyfykyfh815aidl6` FOREIGN KEY (`ngo_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK308ntmxgoxyrbufws5u0th665` FOREIGN KEY (`donation_id`) REFERENCES `donation` (`id`),
  ADD CONSTRAINT `FKi7roiv0u96i9wqo7am7fws9fk` FOREIGN KEY (`volunteer_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `donation`
--
ALTER TABLE `donation`
  ADD CONSTRAINT `FKauf980vqjbqg2h07p7ggit1x3` FOREIGN KEY (`donor_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
