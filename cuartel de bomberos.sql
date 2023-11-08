-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2023 a las 12:22:41
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
  `idBrigada` int(11) NOT NULL,
  `estadoB` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`idBombero`, `dni`, `nombreApellido`, `grupoSanguineo`, `fechaNac`, `celular`, `idBrigada`, `estadoB`) VALUES
(3, 12222222, 'Juan Perez', '1975-05-25', '0000-00-00', '2661111111', 7, 0),
(13, 987, 'Pablo Perez', 'A+', '1981-05-25', '2664567698', 14, 0),
(16, 233, 'Juan Carlos', 'A+', '1981-07-22', '2664556', 14, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

CREATE TABLE `brigada` (
  `idBrigada` int(11) NOT NULL,
  `nombreBrig` varchar(30) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `libre` tinyint(1) NOT NULL,
  `Cuartel` int(11) NOT NULL,
  `estadoBr` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`idBrigada`, `nombreBrig`, `especialidad`, `libre`, `Cuartel`, `estadoBr`) VALUES
(7, 'alfa', 'salvamento en derrumbes', 1, 1, 1),
(12, 'Cola', 'Rescate de Macotas', 1, 3, 1),
(14, 'Toxico', 'Drogas Peligrosas', 1, 6, 1),
(18, 'Incendios Gral', 'Incendios Urbanos', 1, 8, 1),
(19, 'll', 'ooo', 1, 6, 1),
(20, 'Los picantes', 'Altura', 1, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `Cuartel` int(11) NOT NULL,
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

INSERT INTO `cuartel` (`Cuartel`, `nombreCuartel`, `direccion`, `coordX`, `coordY`, `telefono`, `correo`, `estadoC`) VALUES
(1, 'Cuartel 8', 'Falucho 800', 2080, 2080, '266888888', 'Cuartel.8@sl.com.ar', 1),
(3, 'Cuartel Central', 'Av Roca 600', 2085, 2085, '266888999', 'Cuartel.central@sl.com.ar', 1),
(4, 'Cuartel Central', 'Av Roca 600', 2085, 2085, '266888999', 'Cuartel.central@sl.com.ar', 1),
(6, 'Cuartel VM', 'Av Origone 1200', 2085, 2085, '266888999', 'Cuartel.VM@sl.com.ar', 1),
(7, 'Cuartel Tilisarao', 'Av Roca 34500', 2085, 2085, '266888999', 'Cuartel.TILI@sl.com.ar', 1),
(8, 'Los Bravos', 'Potrero de Los Funes', 22, 33, '26645678', 'gr@ml.l', 1),
(9, 'dd', 'tt67', 66, 0, '6776', 'hhk', 1),
(10, 'Cuchi', 'Salvataje en altura', 22, 22, '33', 'rr', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `idCodigo` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `fechaSiniestro` date NOT NULL,
  `horaSiniestro` time NOT NULL,
  `coordx` int(11) NOT NULL,
  `coordy` int(11) NOT NULL,
  `detalles` text NOT NULL,
  `fechaResol` date NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `idBrigada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `siniestro`
--

INSERT INTO `siniestro` (`idCodigo`, `tipo`, `fechaSiniestro`, `horaSiniestro`, `coordx`, `coordy`, `detalles`, `fechaResol`, `puntuacion`, `idBrigada`) VALUES
(1, 'TipoSiniestro', '2023-11-04', '10:30:00', 10, 10, 'Detalles del siniestro', '2023-11-04', 5, 7),
(2, 'TipoSiniestro', '2023-11-04', '10:30:00', 30, 30, 'Detalles del siniestro', '2023-11-04', 5, 12);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`idBombero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `bombero_ibfk_1` (`idBrigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`idBrigada`),
  ADD UNIQUE KEY `nombreBrig` (`nombreBrig`),
  ADD KEY `codCuartel` (`Cuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`Cuartel`);

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
  MODIFY `idBombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `idBrigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `Cuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `idCodigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`idBrigada`) REFERENCES `brigada` (`idBrigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`Cuartel`) REFERENCES `cuartel` (`Cuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`idBrigada`) REFERENCES `brigada` (`idBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
