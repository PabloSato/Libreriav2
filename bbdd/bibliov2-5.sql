-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-04-2021 a las 10:29:13
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.1

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `balda`
--

CREATE TABLE `balda` (
  `id` int(2) NOT NULL,
  `numero` int(2) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `estanteria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coleccion`
--

CREATE TABLE `coleccion` (
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colec_volumen`
--

CREATE TABLE `colec_volumen` (
  `id` int(2) NOT NULL,
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
  `id` int(2) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `genero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idioma`
--

CREATE TABLE `idioma` (
  `idioma` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `ubicacion` varchar(50) DEFAULT NULL,
  `estanteria` varchar(50) DEFAULT NULL,
  `balda` int(2) DEFAULT NULL,
  `tomoCol` int(3) DEFAULT NULL,
  `tomoSag` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autor`
--

CREATE TABLE `libro_autor` (
  `id` int(5) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `autor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autor_dibujante`
--

CREATE TABLE `libro_autor_dibujante` (
  `id` int(5) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `dibujante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_balda`
--

CREATE TABLE `libro_balda` (
  `id` int(5) NOT NULL,
  `balda` int(2) NOT NULL,
  `libro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saga`
--

CREATE TABLE `saga` (
  `nombre` varchar(50) NOT NULL,
  `coleccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saga_volumen`
--

CREATE TABLE `saga_volumen` (
  `id` int(2) NOT NULL,
  `saga` varchar(50) NOT NULL,
  `libro` varchar(100) NOT NULL,
  `numero` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `numero` (`numero`),
  ADD KEY `ubicacion` (`ubicacion`),
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `numero` (`numero`),
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `nombre` (`nombre`),
  ADD KEY `ubicacion` (`ubicacion`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`genero`);

--
-- Indices de la tabla `idioma`
--
ALTER TABLE `idioma`
  ADD PRIMARY KEY (`idioma`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `titulo` (`titulo`),
  ADD KEY `tomoCol` (`tomoCol`),
  ADD KEY `tomoSag` (`tomoSag`),
  ADD KEY `libro_ubicacion_fk3` (`ubicacion`),
  ADD KEY `libro_estanteria_fk4` (`estanteria`),
  ADD KEY `libro_balda_fk5` (`balda`);

--
-- Indices de la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `libro` (`libro`),
  ADD KEY `autor` (`autor`);

--
-- Indices de la tabla `libro_autor_dibujante`
--
ALTER TABLE `libro_autor_dibujante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `libro` (`libro`),
  ADD KEY `autor` (`autor`),
  ADD KEY `dibujante` (`dibujante`);

--
-- Indices de la tabla `libro_balda`
--
ALTER TABLE `libro_balda`
  ADD PRIMARY KEY (`id`),
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `numero` (`numero`),
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
-- AUTO_INCREMENT de la tabla `balda`
--
ALTER TABLE `balda`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `colec_volumen`
--
ALTER TABLE `colec_volumen`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estanteria`
--
ALTER TABLE `estanteria`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro_autor_dibujante`
--
ALTER TABLE `libro_autor_dibujante`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro_balda`
--
ALTER TABLE `libro_balda`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `saga_volumen`
--
ALTER TABLE `saga_volumen`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `balda`
--
ALTER TABLE `balda`
  ADD CONSTRAINT `balda_stante_fk` FOREIGN KEY (`estanteria`) REFERENCES `estanteria` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `colec_volumen`
--
ALTER TABLE `colec_volumen`
  ADD CONSTRAINT `col_vol_colec_fk1` FOREIGN KEY (`coleccion`) REFERENCES `coleccion` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `col_vol_libro_fk2` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `estanteria`
--
ALTER TABLE `estanteria`
  ADD CONSTRAINT `stante_ubi_fk` FOREIGN KEY (`ubicacion`) REFERENCES `ubicacion` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_balda_fk5` FOREIGN KEY (`balda`) REFERENCES `balda` (`numero`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_estanteria_fk4` FOREIGN KEY (`estanteria`) REFERENCES `estanteria` (`nombre`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `libro_ubicacion_fk3` FOREIGN KEY (`ubicacion`) REFERENCES `ubicacion` (`nombre`) ON DELETE SET NULL ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  ADD CONSTRAINT `libro_autor_fk1` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_autor_fk2` FOREIGN KEY (`autor`) REFERENCES `autor` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `libro_autor_dibujante`
--
ALTER TABLE `libro_autor_dibujante`
  ADD CONSTRAINT `libro_dibu_fk1` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_dibu_fk2` FOREIGN KEY (`autor`) REFERENCES `autor` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_dibu_fk3` FOREIGN KEY (`dibujante`) REFERENCES `dibujante` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `libro_balda`
--
ALTER TABLE `libro_balda`
  ADD CONSTRAINT `libro_bal_balda_fk1` FOREIGN KEY (`balda`) REFERENCES `balda` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libro_bal_libro_fk2` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `saga_volumen`
--
ALTER TABLE `saga_volumen`
  ADD CONSTRAINT `sag_vol_colec_fk1` FOREIGN KEY (`saga`) REFERENCES `saga` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sag_vol_libro_fk2` FOREIGN KEY (`libro`) REFERENCES `libro` (`titulo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
