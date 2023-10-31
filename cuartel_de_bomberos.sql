-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2023 a las 03:28:54
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
-- Base de datos: `cuartel_de_bomberos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

CREATE TABLE `bombero` (
  `idBombero` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombreApellido` varchar(50) NOT NULL,
  `grupoSanguineo` varchar(11) NOT NULL,
  `fechaNac` date NOT NULL,
  `celular` varchar(30) NOT NULL,
  `codBrigada` int(30) NOT NULL,
  `estadoB` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

CREATE TABLE `brigada` (
  `idBrigada` int(11) NOT NULL,
  `nombreBrig` varchar(30) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `libre` tinyint(1) NOT NULL,
  `codCuartel` int(11) NOT NULL,
  `estadoBr` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `idCuartel` int(11) NOT NULL,
  `nombreCuartel` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `coordX` int(11) NOT NULL,
  `coordY` int(11) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `estadoC` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`idCuartel`, `nombreCuartel`, `direccion`, `coordX`, `coordY`, `telefono`, `correo`, `estadoC`) VALUES
(5, 'Cuarte 21', 'Belgrano 3333', 410, 100, '2668888888', 'Cuartel.21whisky@sl.com.ar', 1),
(6, 'Cuarte 1', 'Pringles 233', 310, 110, '2661111111', 'Cuartel.1@sl.com.ar', 1),
(7, 'Cuartel 3', 'Catamarca 663', 310, 110, '266333333', 'Cuartel.3@sl.com.ar', 1),
(8, 'Cuartel 5', 'AV Chorrillo 365', 350, 310, '266555555', 'Cuartel.5@sl.com.ar', 1),
(9, 'Cuartel 10', 'AV Fundador 1010', 1050, 1010, '266555555', 'Cuartel.10@sl.com.ar', 1),
(10, 'Cuartel 12', 'AV Pichincha 1010', 1080, 1080, '266121212', 'Cuartel.12@sl.com.ar', 1),
(11, 'Cuartel 2', 'AV Almafuerte 5550', 2080, 2080, '266555555', 'Cuartel.2@sl.com.ar', 1),
(12, 'Cuartel 4', 'Falucho 800', 1085, 1085, '266888888', 'Cuartel.4@sl.com.ar', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `idSiniestro` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `fechaSiniestro` date NOT NULL,
  `coordx` int(11) NOT NULL,
  `coordy` int(11) NOT NULL,
  `detalles` text NOT NULL,
  `fechaResol` date NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `codBrigada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`idBombero`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`idBrigada`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`idCuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`idSiniestro`),
  ADD KEY `codBrigada` (`codBrigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `idBombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `idBrigada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `idCuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `idSiniestro` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`idBrigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`codCuartel`) REFERENCES `cuartel` (`idCuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`idBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
