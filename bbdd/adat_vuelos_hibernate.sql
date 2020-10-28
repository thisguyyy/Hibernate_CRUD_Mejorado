-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2020 a las 18:04:30
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `adat_vuelos_hibernate`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `id` int(11) NOT NULL,
  `nombre_apellidos` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `ID` int(11) NOT NULL,
  `CODIGO_VUELO` varchar(5) NOT NULL,
  `ORIGEN` varchar(50) NOT NULL,
  `DESTINO` varchar(50) NOT NULL,
  `FECHA` varchar(255) NOT NULL,
  `PLAZAS_TOTALES` int(11) NOT NULL,
  `PLAZAS_DISPONIBLES` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`ID`, `CODIGO_VUELO`, `ORIGEN`, `DESTINO`, `FECHA`, `PLAZAS_TOTALES`, `PLAZAS_DISPONIBLES`) VALUES
(1, 'def22', 'VALENCIA', 'LA HABANA, CUBA', '2020-09-23 19:22:25', 500, 18),
(2, 'X0125', 'Valencia', 'Bilbao', '2020-10-25 10:00:00', 90, 50),
(3, 'XLM10', 'IBZ', 'MXC', '2021-05-10', 300, 300),
(4, 'dasc1', 'vlc', 'mad', '2020-10-05', 23, 56),
(5, 'bhp44', 'mad', 'sue', '2020-08-08 18:20:20', 122, 100),
(6, 'A0987', 'Ibiza', 'París', '2020-10-30 10:00:00', 200, 100),
(7, 'COD12', 'PAR', 'MAR', '2020-10-30 09:00:00', 150, 50);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
