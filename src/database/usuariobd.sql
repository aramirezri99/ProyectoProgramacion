-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2017 a las 16:09:59
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `usuariobd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `estadocivil` varchar(100) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `horaentrada` varchar(100) DEFAULT NULL,
  `horasalida` varchar(100) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dni`, `nombre`, `apellido`, `edad`, `estadocivil`, `telefono`, `horaentrada`, `horasalida`, `usuario`, `tipo`, `clave`) VALUES
(73500244, 'Alcides', 'Camana', 23, 'soltero', 946896367, '6:20 pm', '10:30 pm', 'Gerente', 'Administrador', '2017'),
(76218239, 'Arnold', 'Respicio', 18, 'soltero', 3627754, '6:20 pm', '10:30 pm', 'DBSVegetto6', 'Gerente', 'DBZGoku62'),
(76759831, 'Daniel', 'Barrientos', 21, 'soltero', 7752312, '6:20 pm', '10:30 pm', 'Daniel', 'Vendedor', '159daniel');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
