-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2023 a las 19:10:17
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
-- Base de datos: `cuartel de bomberos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

CREATE TABLE `bombero` (
  `idBombero` int(11) NOT NULL,
  `dni` int(8) NOT NULL,
  `nombreApellido` varchar(50) NOT NULL,
  `grupoSanguineo` varchar(30) NOT NULL,
  `fechaNac` date NOT NULL,
  `celular` varchar(30) NOT NULL,
  `codBrigada` int(11) NOT NULL,
  `estadoB` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`idBombero`, `dni`, `nombreApellido`, `grupoSanguineo`, `fechaNac`, `celular`, `codBrigada`, `estadoB`) VALUES
(3, 12222222, 'Juan Perez', '1975-05-25', '0000-00-00', '2661111111', 7, 1);

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
  `estadoBr` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`idBrigada`, `nombreBrig`, `especialidad`, `libre`, `codCuartel`, `estadoBr`) VALUES
(7, 'alfa', 'salvamento en derrumbes', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `codCuartel` int(11) NOT NULL,
  `nombreCuartel` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `coordX` int(11) NOT NULL,
  `coordY` int(11) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `estadoC` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`codCuartel`, `nombreCuartel`, `direccion`, `coordX`, `coordY`, `telefono`, `correo`, `estadoC`) VALUES
(1, 'Cuartel 8', 'Falucho 800', 2080, 2080, '266888888', 'Cuartel.8@sl.com.ar', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `idCodigo` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `fechaSiniestro` date NOT NULL,
  `coordx` int(11) NOT NULL,
  `coordy` int(11) NOT NULL,
  `detalles` text NOT NULL,
  `fechaResol` date NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `idBrigada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`idBombero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `codBrigada` (`codBrigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`idBrigada`),
  ADD KEY `codCuartel` (`codCuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`codCuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`idCodigo`),
  ADD KEY `codBrigada` (`idBrigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `idBombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `idBrigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `codCuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `idCodigo` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`codCuartel`) REFERENCES `cuartel` (`codCuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`idBrigada`) REFERENCES `brigada` (`idBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
