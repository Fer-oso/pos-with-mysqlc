-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-10-2023 a las 19:43:47
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street_direction` varchar(32) NOT NULL,
  `street_number` int(11) NOT NULL,
  `city` varchar(32) NOT NULL,
  `state` varchar(32) NOT NULL,
  `postal_code` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `address`
--

INSERT INTO `address` (`id`, `street_direction`, `street_number`, `city`, `state`, `postal_code`) VALUES
(1, 'jose ignacio rucci', 3394, 'Isidro Casanova', 'Buenos Aires', 1765),
(2, 'Islas Malvinas', 2532, 'Isidro Casanova', 'Buenos Aires', 1765);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE `author` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `isbn` varchar(255) NOT NULL,
  `copies` int(11) DEFAULT NULL,
  `publication` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_id` varchar(255) DEFAULT NULL,
  `editorial_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `lastname` varchar(32) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `ssn` varchar(32) NOT NULL,
  `clasification` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clients`
--

INSERT INTO `clients` (`id`, `name`, `lastname`, `age`, `ssn`, `clasification`) VALUES
(3, 'JEJEJE', 'Osorio', 29, '38128526', 'Vip'),
(4, 'fabian', 'oso', 29, '333', NULL),
(7, 'alejandro', 'oso', 29, '444', NULL),
(8, 'Patroclo', 'oso', 29, '444', NULL),
(9, 'Lucio', 'oso', 29, '444', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_address`
--

CREATE TABLE `client_address` (
  `id_client` int(11) NOT NULL,
  `id_address` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `client_address`
--

INSERT INTO `client_address` (`id_client`, `id_address`) VALUES
(3, 1),
(3, 2),
(4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_phone`
--

CREATE TABLE `client_phone` (
  `id_client` int(11) NOT NULL,
  `id_phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `phone`
--

CREATE TABLE `phone` (
  `id` int(11) NOT NULL,
  `number_phone` int(11) NOT NULL,
  `type_phone` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `phone`
--

INSERT INTO `phone` (`id`, `number_phone`, `type_phone`) VALUES
(1, 46698856, 'Home Telephone');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `FKklnrv3weler2ftkweewlky958` (`author_id`),
  ADD KEY `FKg31fjtjyhdp3u9v134xn4ntiq` (`editorial_id`);

--
-- Indices de la tabla `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `client_address`
--
ALTER TABLE `client_address`
  ADD KEY `client_FK` (`id_client`),
  ADD KEY `address_FK` (`id_address`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `phone`
--
ALTER TABLE `phone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKg31fjtjyhdp3u9v134xn4ntiq` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`),
  ADD CONSTRAINT `FKklnrv3weler2ftkweewlky958` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`);

--
-- Filtros para la tabla `client_address`
--
ALTER TABLE `client_address`
  ADD CONSTRAINT `address_FK` FOREIGN KEY (`id_address`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `client_FK` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;