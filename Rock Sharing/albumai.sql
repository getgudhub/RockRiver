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
-- Sukurta duomenų struktūra lentelei `albumai`
--

CREATE TABLE `albumai` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `title` varchar(30) NOT NULL,
  `artist` varchar(30) NOT NULL,
  `songs` int(3) NOT NULL,
  `genre` varchar(30) NOT NULL,
  `year` int(4) NOT NULL,
  `rating` int(7) NOT NULL,
  `votes` int(7) NOT NULL,
  `lastUpdated` date NOT NULL,
  `downloadSite` text NOT NULL,
  `ratingPoints` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `albumai`
--

INSERT INTO `albumai` (`id`, `username`, `title`, `artist`, `songs`, `genre`, `year`, `rating`, `votes`, `lastUpdated`, `downloadSite`, `ratingPoints`) VALUES
(1, 'fordas', 'White Walkers', 'October Rage', 12, 'Alternative Rock', 2015, 4, 4, '2017-12-31', 'www.OctoberRage.com/list', 18),
(2, 'fordas', 'Cleopatra', 'Elric Entonio', 6, 'Alternative Electronic  Rock', 2001, 9, 3, '2017-12-29', 'www.freemp3.net/ElricEntonio/s16#f', 19),
(3, 'fordas', 'Popsicle', 'Leo Gin', 9, 'Classic Funk  Rock', 2009, 9, 3, '2017-12-29', 'www.LeoGin.com/albums', 18),
(4, 'Eliot', 'Silver Moon', 'Unfold', 10, 'Hard Experimental Rock', 2003, 6, 7, '2017-12-30', 'www.notfakeatallsite.com/albums', 42),
(5, 'fordas', 'Sekluma', 'Astrus Pipiriukai', 11, 'Punk Post  Rock', 2012, 8, 6, '2017-12-30', 'www.tikastrusprieskoniai.lt/downloads/gwwg5', 52),
(6, 'fordas', 'Snappers', 'Fiddle The Void', 12, 'Pop Rock', 2013, 8, 4, '2017-12-30', 'www.panzerloads.net/shareing/6eh5gd6gf5', 24),
(7, 'fordas', 'Rise Forward', 'Running Along', 8, 'Classic Experimental Rock', 2017, 7, 3, '2017-12-30', 'www.wheredreamslie.com/downloads/found#g5gkp', 22),
(8, 'fordas', 'Burning Love', 'Flamethrowers', 15, 'Hard Electronic Rock', 1999, 4, 3, '2017-12-30', 'www.oldsongs.ru/sandtunel/gdh5g$35%#', 12),
(9, 'dude', 'Torched', 'Under the Weight', 12, 'Alternative Hard Rock', 2017, 4, 5, '2017-12-30', 'www.getfreemp3.net/search-g3y33', 20),
(11, 'fordas', 'Takedown', 'Firefly', 11, 'Alternative Post Rock', 2012, 7, 5, '2017-12-30', 'www.bandsbandsbands.com/download', 36),
(12, 'fordas', 'Goo', 'Goo', 99, 'Pop Rock', 2000, 8, 16, '2017-12-31', '99', 143),
(13, 'fordas', 'Leo Bing', 'Leo Bing', 7, 'Pop Alternative Rock', 2015, 7, 1, '2018-05-13', 'www.WhereLeoAt.com/share', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `albumai`
--
ALTER TABLE `albumai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `albumai`
--
ALTER TABLE `albumai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
