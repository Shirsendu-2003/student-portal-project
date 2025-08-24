-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2025 at 11:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentform`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `name`, `password`) VALUES
(3, 'pratik@gmail.com', 'Pratik Mondal', '$2a$10$B05aT9e48NPscHl6PIHU1.vHyA7C6.f.z0FcnMvXwRd73HNbVOVeS'),
(8, 'shres@gmail.com', 'Shres Banerjee', '$2a$10$YFpf8L6Q0rxYdPPTsk2eXO.eIid4JS4yPkSa6pd8R8rXRWXitp60u'),
(9, 'somu@gmail.com', 'Somu Mukherjee', '$2a$10$MFiaaAg5JE/vYGbww2OE3.1u.eqqsKMKBHnV4vkdz3RggHLRDB8Ha');

-- --------------------------------------------------------

--
-- Table structure for table `admin_cell`
--

CREATE TABLE `admin_cell` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_cell`
--

INSERT INTO `admin_cell` (`id`, `email`, `name`, `password`) VALUES
(1, 'Sourav@gmail.com', 'Sourav Pramanik', '$2a$10$N957rjJ4Vx0Zkun2dMjuSuE0aNc4sZz9NOndcCHsMu/MO6adZSOGS'),
(2, 'Rishav@gamil.com', 'Pratik Mondal', '$2a$10$QbmSFKnKsY/rVdt69VeEGeeboJUPuP2MM/Z7AUqeOdk9LwctDZ9Y6');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `verification_token` varchar(255) DEFAULT NULL,
  `verified` bit(1) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `students_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `address`, `course`, `email`, `name`, `phone`, `verification_token`, `verified`, `created_at`, `updated_at`, `remark`, `source`, `students_id`) VALUES
(1, 'Behrampur, west bangel,pin-523645', 'Computer Science & Engineering', 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'0', NULL, '2025-08-22 01:53:59.000000', 'i am the best', NULL, ''),
(31, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Sourav Pramanik', '9001223314', NULL, b'1', '2025-08-14 01:25:08.000000', '2025-08-20 13:46:33.000000', 'he is a compalain boy', NULL, ''),
(32, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Sourav Pramanik', '9001223314', NULL, b'1', '2025-08-14 01:33:51.000000', '2025-08-14 01:33:51.000000', NULL, NULL, ''),
(33, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Sourav Pramanik', '9001223314', NULL, b'1', '2025-08-19 02:02:10.000000', '2025-08-19 02:02:10.000000', NULL, NULL, ''),
(34, NULL, NULL, 'baishakhi2004@gmail.com', 'baishakhi biswas', '8768266993', NULL, b'1', '2025-08-20 13:49:19.000000', '2025-08-21 23:11:41.000000', 'hello', NULL, ''),
(35, NULL, NULL, 'jishu8509@gmail.com', 'jishu biswas', '8436678823', NULL, b'1', '2025-08-20 13:54:04.000000', '2025-08-20 13:54:04.000000', NULL, NULL, ''),
(36, NULL, NULL, 'palsoumyadeep67@gmail.com', 'soumyadeep pal', '7868266993', NULL, b'1', '2025-08-20 14:04:59.000000', '2025-08-20 14:04:59.000000', NULL, NULL, ''),
(37, NULL, NULL, 'pratikmondal16@gmail.com', 'Amit babu', '5689742321', NULL, b'1', '2025-08-20 14:39:06.000000', '2025-08-21 01:49:22.000000', 'today is sunday', NULL, ''),
(38, NULL, NULL, 'pratikmondal16@gmail.com', 'gargi pramanik', '2589631470', NULL, b'1', '2025-08-21 01:02:37.000000', '2025-08-21 01:02:37.000000', NULL, 'direct', ''),
(39, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Shrestha banerjee', '2135468790', NULL, b'1', '2025-08-21 22:47:53.000000', '2025-08-21 22:50:46.000000', 'today i call you back', 'direct', ''),
(43, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 02:05:47.000000', '2025-08-22 02:05:47.000000', 'i am the best', NULL, ''),
(44, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 02:06:28.000000', '2025-08-22 02:06:28.000000', 'best of the best', NULL, ''),
(45, NULL, NULL, 'pratikmondal16@gmail.com', 'Amit babu', '5689742321', NULL, b'1', '2025-08-22 02:08:39.000000', '2025-08-22 02:08:39.000000', 'vlo achis', NULL, ''),
(52, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Sourav Pramanik', '9001223314', NULL, b'1', '2025-08-22 02:37:57.000000', '2025-08-22 02:37:57.000000', 'bhhh', NULL, ''),
(53, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Rasmoni Pramanik', '7418529630', NULL, b'1', '2025-08-22 13:58:04.000000', '2025-08-22 13:58:04.000000', NULL, 'direct', ''),
(54, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Rasmoni Pramanik', '7418529630', NULL, b'1', '2025-08-22 14:39:28.000000', '2025-08-22 14:39:28.000000', 'dd', NULL, ''),
(55, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 15:18:31.000000', '2025-08-22 15:18:31.000000', 'i am the best', NULL, ''),
(56, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 15:18:53.000000', '2025-08-22 15:18:53.000000', 'i am the best', NULL, ''),
(57, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Sourav Pramanik', '9001223314', NULL, b'1', '2025-08-22 16:01:30.000000', '2025-08-22 16:01:30.000000', 'vg', NULL, ''),
(58, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 16:06:09.000000', '2025-08-22 16:06:09.000000', 'the world', NULL, ''),
(59, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Sourav Pramanik', '9001223314', NULL, b'1', '2025-08-22 16:06:28.000000', '2025-08-22 16:06:28.000000', 'good', NULL, ''),
(60, NULL, NULL, 'baishakhi2004@gmail.com', 'baishakhi biswas', '8768266993', NULL, b'1', '2025-08-22 16:17:13.000000', '2025-08-22 16:17:13.000000', 'bye', NULL, ''),
(61, NULL, NULL, 'pratikmondal16@gmail.com', 'Amit babu', '5689742321', NULL, b'1', '2025-08-22 16:17:27.000000', '2025-08-22 16:17:27.000000', 'today is good day', NULL, ''),
(62, NULL, NULL, 'pramanikshirsendu6@gmail.com', 'Shrestha banerjee', '2135468790', NULL, b'1', '2025-08-22 16:17:44.000000', '2025-08-22 16:17:44.000000', 'today i call you later', NULL, ''),
(63, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 16:17:54.000000', '2025-08-22 16:17:54.000000', 'i am the best part', NULL, ''),
(64, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 16:36:43.000000', '2025-08-22 16:36:43.000000', '', NULL, ''),
(65, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-22 23:51:27.000000', '2025-08-22 23:51:27.000000', '', NULL, ''),
(66, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-23 00:05:44.000000', '2025-08-23 00:05:44.000000', 'ff', NULL, ''),
(67, NULL, NULL, 'pratik@gmail.com', 'Pratik Mondal', '7868266993', NULL, b'1', '2025-08-23 00:06:00.000000', '2025-08-23 00:06:00.000000', 'but', NULL, ''),
(68, NULL, NULL, 'pratikmondal16@gmail.com', 'Riya Roy', '7410852963', NULL, b'1', '2025-08-23 00:30:36.000000', '2025-08-23 00:30:36.000000', NULL, 'direct', 'STU1755889236881'),
(69, NULL, NULL, 'pratikmondal16@gmail.com', 'Riya Roy', '7410852963', NULL, b'1', '2025-08-23 00:32:32.000000', '2025-08-23 00:32:32.000000', 'pratik marry me ', NULL, 'STU1755889236881'),
(70, NULL, NULL, 'pratikmondal16@gmail.com', 'Dipika ghosh', '7894561230', NULL, b'1', '2025-08-23 00:42:41.000000', '2025-08-23 00:42:41.000000', NULL, 'direct', 'DG2308202532'),
(71, NULL, NULL, 'pratikmondal16@gmail.com', 'Dipika ghosh', '7894561230', NULL, b'1', '2025-08-23 00:44:26.000000', '2025-08-23 00:44:26.000000', 'you are selected', NULL, 'DG2308202532'),
(72, NULL, NULL, 'pratikmondal16@gmail.com', 'Dipika ghosh', '7894561230', NULL, b'1', '2025-08-23 00:45:38.000000', '2025-08-23 00:45:38.000000', 'send your bank detils ', NULL, 'DG2308202532'),
(73, NULL, NULL, 'biphikaghosh8695@gmail.com', 'biphika ghosh', '7410326598', NULL, b'1', '2025-08-23 01:05:07.000000', '2025-08-23 01:05:07.000000', NULL, 'direct', 'BG2308202535'),
(74, NULL, NULL, 'pratikmondal16@gmail.com', 'Rishav Pramanik', '5826934710', NULL, b'1', '2025-08-23 01:25:51.000000', '2025-08-23 01:25:51.000000', NULL, 'direct', 'RP2308202536'),
(75, NULL, NULL, 'pratikmondal16@gmail.com', 'Sourav laha', '9874563210', NULL, b'1', '2025-08-23 02:22:32.000000', '2025-08-23 02:22:32.000000', NULL, 'direct', 'SL2308202537'),
(76, NULL, NULL, 'pratikmondal16@gmail.com', 'Nayan pramanik', '9874563210', NULL, b'1', '2025-08-23 03:19:20.000000', '2025-08-23 03:19:20.000000', NULL, 'direct', 'NP2308202538'),
(77, NULL, NULL, 'pratikmondal16@gmail.com', 'Raju mondal', '8529631470', NULL, b'1', '2025-08-24 01:28:34.000000', '2025-08-24 01:28:34.000000', NULL, 'direct', 'RM2408202539');

-- --------------------------------------------------------

--
-- Table structure for table `student_course_choices`
--

CREATE TABLE `student_course_choices` (
  `student_id` bigint(20) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `choice_order` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_course_choices`
--

INSERT INTO `student_course_choices` (`student_id`, `course_name`, `choice_order`) VALUES
(31, 'Computer Science & Engineering', 'first'),
(31, 'Electrical Engineering', 'fourth'),
(31, 'Electronics & Communication Engineering', 'second'),
(31, 'Civil Engineering', 'third'),
(32, 'Electronics & Communication Engineering', 'first'),
(32, 'Civil Engineering', 'fourth'),
(32, 'Computer Science & Engineering', 'second'),
(32, 'Electrical Engineering', 'third'),
(33, 'Computer Science & Engineering', 'first'),
(33, 'Electrical Engineering', 'fourth'),
(33, 'Electronics & Communication Engineering', 'second'),
(33, 'Civil Engineering', 'third'),
(34, 'Computer Science & Engineering', 'first'),
(34, 'Electrical Engineering', 'fourth'),
(34, 'Electronics & Communication Engineering', 'second'),
(34, 'Civil Engineering', 'third'),
(35, 'Computer Science & Engineering', 'first'),
(35, 'Electrical Engineering', 'fourth'),
(35, 'Electronics & Communication Engineering', 'second'),
(35, 'Civil Engineering', 'third'),
(36, 'Computer Science & Engineering', 'first'),
(36, 'Electrical Engineering', 'fourth'),
(36, 'Electronics & Communication Engineering', 'second'),
(36, 'Civil Engineering', 'third'),
(37, 'Electronics & Communication Engineering', 'first'),
(37, 'Civil Engineering', 'fourth'),
(37, 'Electrical Engineering', 'second'),
(37, 'Computer Science & Engineering', 'third'),
(38, 'Computer Science & Engineering', 'first'),
(38, 'Electrical Engineering', 'fourth'),
(38, 'Electronics & Communication Engineering', 'second'),
(38, 'Civil Engineering', 'third'),
(39, 'Computer Science & Engineering', 'first'),
(39, 'Electrical Engineering', 'fourth'),
(39, 'Electronics & Communication Engineering', 'second'),
(39, 'Civil Engineering', 'third'),
(53, 'Computer Science & Engineering', 'first'),
(53, 'Electrical Engineering', 'fourth'),
(53, 'Electronics & Communication Engineering', 'second'),
(53, 'Civil Engineering', 'third'),
(54, 'Computer Science & Engineering', 'first'),
(54, 'Electrical Engineering', 'fourth'),
(54, 'Electronics & Communication Engineering', 'second'),
(54, 'Civil Engineering', 'third'),
(68, 'Computer Science & Engineering', 'first'),
(68, 'Electronics & Communication Engineering', 'fourth'),
(68, 'Electrical Engineering', 'second'),
(68, 'Civil Engineering', 'third'),
(70, 'Computer Science & Engineering', 'first'),
(70, 'Electrical Engineering', 'fourth'),
(70, 'Electronics & Communication Engineering', 'second'),
(70, 'Civil Engineering', 'third'),
(73, 'Computer Science & Engineering', 'first'),
(73, 'Electrical Engineering', 'fourth'),
(73, 'Electronics & Communication Engineering', 'second'),
(73, 'Civil Engineering', 'third'),
(74, 'Computer Science & Engineering', 'first'),
(74, 'Electrical Engineering', 'fourth'),
(74, 'Electronics & Communication Engineering', 'second'),
(74, 'Civil Engineering', 'third'),
(75, 'Computer Science & Engineering', 'first'),
(75, 'Electrical Engineering', 'fourth'),
(75, 'Electronics & Communication Engineering', 'second'),
(75, 'Civil Engineering', 'third'),
(76, 'Computer Science & Engineering', 'first'),
(76, 'Electrical Engineering', 'fourth'),
(76, 'Civil Engineering', 'second'),
(76, 'Electronics & Communication Engineering', 'third'),
(77, 'Computer Science & Engineering', 'first'),
(77, 'Electrical Engineering', 'fourth'),
(77, 'Electronics & Communication Engineering', 'second'),
(77, 'Civil Engineering', 'third');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin_cell`
--
ALTER TABLE `admin_cell`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKlvlusm0yvbuw0w2qr2i5x3wdy` (`email`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_course_choices`
--
ALTER TABLE `student_course_choices`
  ADD PRIMARY KEY (`student_id`,`choice_order`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `admin_cell`
--
ALTER TABLE `admin_cell`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_course_choices`
--
ALTER TABLE `student_course_choices`
  ADD CONSTRAINT `FKgv24u2f2l85sc98oshvjjsqc0` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
