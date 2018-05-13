-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018 m. Geg 13 d. 22:26
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `duombaze`
--

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `userlevel` int(1) NOT NULL,
  `email` varchar(35) NOT NULL,
  `timestamp` date NOT NULL,
  `votesOn` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `users`
--

INSERT INTO `users` (`username`, `password`, `userlevel`, `email`, `timestamp`, `votesOn`) VALUES
('fordas', 'fordinis', 1, 'fordas@gmail.com', '0000-00-00', '1 2 3 1 2 1 1 8 7 9 13 '),
('dude', 'dude', 9, 'jonas@gmail.com', '2017-12-25', '0 2 3 6 12 11 7 '),
('Eliot', 'eliot', 1, 'eliot@gmail.com', '2017-12-29', '0'),
('Jogaila', 'jogaila', 1, 'joGaila@gmail.com', '0000-00-00', '0 11 ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD KEY `timestamp` (`timestamp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
