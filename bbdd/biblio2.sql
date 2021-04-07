-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-04-2021 a las 11:08:24
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblio2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `alias` varchar(50) NOT NULL,
  `bio` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`nombre`, `apellidos`, `alias`, `bio`) VALUES
('John', 'Tolkien', 'Tolkien', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `balda`
--

CREATE TABLE `balda` (
  `numero` int(2) NOT NULL,
  `estanteria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `balda`
--

INSERT INTO `balda` (`numero`, `estanteria`) VALUES
(1, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coleccion`
--

CREATE TABLE `coleccion` (
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coleccion`
--

INSERT INTO `coleccion` (`nombre`) VALUES
('Legendarium');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colec_volumen`
--

CREATE TABLE `colec_volumen` (
  `coleccion` varchar(50) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `numero` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dibujante`
--

CREATE TABLE `dibujante` (
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `alias` varchar(50) NOT NULL,
  `bio` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estanteria`
--

CREATE TABLE `estanteria` (
  `nombre` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estanteria`
--

INSERT INTO `estanteria` (`nombre`, `ubicacion`) VALUES
('A', 'Habita Pablo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` int(5) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `paginas` int(5) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `idioma` varchar(20) NOT NULL,
  `leido` tinyint(1) NOT NULL,
  `coleccion` varchar(50) DEFAULT NULL,
  `saga` varchar(50) DEFAULT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `estanteria` varchar(50) NOT NULL,
  `balda` int(2) NOT NULL,
  `tomoCol` int(3) DEFAULT NULL,
  `tomoSag` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `titulo`, `paginas`, `genero`, `idioma`, `leido`, `coleccion`, `saga`, `ubicacion`, `estanteria`, `balda`, `tomoCol`, `tomoSag`) VALUES
(5, 'Uno', 123, 'fan', 'asd', 1, 'Legendarium', 'Señor', 'Habita Pablo', 'A', 1, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autor`
--

CREATE TABLE `libro_autor` (
  `indice` int(5) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `autor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro_autor`
--

INSERT INTO `libro_autor` (`indice`, `libro`, `autor`) VALUES
(1, 'Uno', 'Tolkien');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autor_dibujante`
--

CREATE TABLE `libro_autor_dibujante` (
  `indice` int(5) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `dibujante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_balda`
--

CREATE TABLE `libro_balda` (
  `indice` int(5) NOT NULL,
  `balda` int(2) NOT NULL,
  `libro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro_balda`
--

INSERT INTO `libro_balda` (`indice`, `balda`, `libro`) VALUES
(1, 1, 'Uno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saga`
--

CREATE TABLE `saga` (
  `nombre` varchar(50) NOT NULL,
  `coleccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `saga`
--

INSERT INTO `saga` (`nombre`, `coleccion`) VALUES
('Señor', 'Legendarium');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saga_volumen`
--

CREATE TABLE `saga_volumen` (
  `saga` varchar(50) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `numero` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `saga_volumen`
--

INSERT INTO `saga_volumen` (`saga`, `libro`, `numero`) VALUES
('Señor', 'Uno', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`nombre`) VALUES
('Habita Pablo'),
('pablo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`alias`);

--
-- Indices de la tabla `balda`
--
ALTER TABLE `balda`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `estanteria` (`estanteria`);

--
-- Indices de la tabla `coleccion`
--
ALTER TABLE `coleccion`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `colec_volumen`
--
ALTER TABLE `colec_volumen`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `coleccion` (`coleccion`),
  ADD KEY `libro` (`libro`);

--
-- Indices de la tabla `dibujante`
--
ALTER TABLE `dibujante`
  ADD PRIMARY KEY (`alias`);

--
-- Indices de la tabla `estanteria`
--
ALTER TABLE `estanteria`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `ubicacion` (`ubicacion`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `titulo` (`titulo`),
  ADD KEY `tomoCol` (`tomoCol`),
  ADD KEY `tomoSag` (`tomoSag`),
  ADD KEY `libro_coleccion_fk1` (`coleccion`),
  ADD KEY `libro_saga_fk2` (`saga`),
  ADD KEY `libro_ubicacion_fk3` (`ubicacion`),
  ADD KEY `libro_estanteria_fk4` (`estanteria`),
  ADD KEY `libro_balda_fk5` (`balda`);

--
-- Indices de la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  ADD PRIMARY KEY (`indice`),
  ADD KEY `libro` (`libro`),
  ADD KEY `autor` (`autor`);

--
-- Indices de la tabla `libro_autor_dibujante`
--
ALTER TABLE `libro_autor_dibujante`
  ADD PRIMARY KEY (`indice`),
  ADD KEY `libro` (`libro`),
  ADD KEY `autor` (`autor`),
  ADD KEY `dibujante` (`dibujante`);

--
-- Indices de la tabla `libro_balda`
--
ALTER TABLE `libro_balda`
  ADD PRIMARY KEY (`indice`),
  ADD KEY `balda` (`balda`),
  ADD KEY `libro` (`libro`);

--
-- Indices de la tabla `saga`
--
ALTER TABLE `saga`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `coleccion` (`coleccion`);

--
-- Indices de la tabla `saga_volumen`
--
ALTER TABLE `saga_volumen`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `saga` (`saga`),
  ADD KEY `libro` (`libro`);

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  MODIFY `indice` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `libro_autor_dibujante`
--
ALTER TABLE `libro_autor_dibujante`
  MODIFY `indice` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro_balda`
--
ALTER TABLE `libro_balda`
  MODIFY `indice` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `balda`
--
ALTER TABLE `balda`
  ADD CONSTRAINT `balda_stante_fk` FOREIGN KEY (`estanteria`) REFERENCES `estanteria` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `colec_volumen`
--
ALTER TABLE `colec_volumen`
  ADD CONSTRAINT `col_vol_colec_fk1` FOREIGN KEY (`coleccion`) REFERENCES `coleccion` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `col_vol_libro_fk1` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estanteria`
--
ALTER TABLE `estanteria`
  ADD CONSTRAINT `stante_ubi_fk` FOREIGN KEY (`ubicacion`) REFERENCES `ubicacion` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_balda_fk5` FOREIGN KEY (`balda`) REFERENCES `balda` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_coleccion_fk1` FOREIGN KEY (`coleccion`) REFERENCES `coleccion` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_estanteria_fk4` FOREIGN KEY (`estanteria`) REFERENCES `estanteria` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_saga_fk2` FOREIGN KEY (`saga`) REFERENCES `saga` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_ubicacion_fk3` FOREIGN KEY (`ubicacion`) REFERENCES `ubicacion` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  ADD CONSTRAINT `libro_autor_fk1` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_autor_fk2` FOREIGN KEY (`autor`) REFERENCES `autor` (`alias`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro_autor_dibujante`
--
ALTER TABLE `libro_autor_dibujante`
  ADD CONSTRAINT `libro_dibu_fk1` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_dibu_fk2` FOREIGN KEY (`autor`) REFERENCES `autor` (`alias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_dibu_fk3` FOREIGN KEY (`dibujante`) REFERENCES `dibujante` (`alias`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro_balda`
--
ALTER TABLE `libro_balda`
  ADD CONSTRAINT `libro_bal_balda_fk1` FOREIGN KEY (`balda`) REFERENCES `balda` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_bal_libro_fk2` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `saga_volumen`
--
ALTER TABLE `saga_volumen`
  ADD CONSTRAINT `sag_vol_colec_fk1` FOREIGN KEY (`saga`) REFERENCES `saga` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `sag_vol_libro_fk1` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
