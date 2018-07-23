-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-08-2017 a las 12:40:02
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `venta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
`customerid` int(30) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone` int(20) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `customer`
--

INSERT INTO `customer` (`customerid`, `firstname`, `lastname`, `phone`) VALUES
(1, 'Emilio', 'La Lueta', 0),
(2, 'Emilio', 'La Lueta', 0),
(3, 'Tomas', 'La Lueta', 0),
(4, 'Merce', 'La Lueta', 0),
(5, 'mecedes', 'La Lueta', 0),
(6, 'Fernanado', 'Gomez', 0),
(7, 'Fernanado', 'Gomez', 0),
(9, 'Santi', 'Pomer', 0),
(10, 'Gema', 'Andujar', 0),
(11, 'Paqui', 'Nieto', 0),
(12, 'Paqui', 'Nieto', 0),
(13, 'Pablo', 'Leal', 0),
(14, 'Oscar', 'Fernandez', 0),
(15, 'Virginia', 'Blanco', 0),
(16, 'Patricia', 'Jimenez', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customerorder`
--

CREATE TABLE IF NOT EXISTS `customerorder` (
`orderid` int(20) NOT NULL,
  `total` int(10) DEFAULT NULL,
  `products` varchar(50) DEFAULT NULL,
  `customerid` int(30) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `customerorder`
--

INSERT INTO `customerorder` (`orderid`, `total`, `products`, `customerid`) VALUES
(6, 10, '', 0),
(7, 10, '', 0),
(8, 22, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer_order`
--

CREATE TABLE IF NOT EXISTS `customer_order` (
  `customer_id` int(30) NOT NULL,
  `order_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `customer_order`
--

INSERT INTO `customer_order` (`customer_id`, `order_id`) VALUES
(9, 6),
(10, 7),
(16, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order_products`
--

CREATE TABLE IF NOT EXISTS `order_products` (
  `order_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `order_products`
--

INSERT INTO `order_products` (`order_id`, `product_id`) VALUES
(6, 1),
(7, 1),
(8, 2),
(8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE IF NOT EXISTS `products` (
`id` int(20) NOT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `precio` int(50) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `marca`, `precio`) VALUES
(1, 'ford', 10),
(2, 'Seat', 12);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`customerid`);

--
-- Indices de la tabla `customerorder`
--
ALTER TABLE `customerorder`
 ADD PRIMARY KEY (`orderid`), ADD KEY `fk_order_customer` (`customerid`);

--
-- Indices de la tabla `customer_order`
--
ALTER TABLE `customer_order`
 ADD KEY `fk_customer` (`customer_id`), ADD KEY `fk_order` (`order_id`);

--
-- Indices de la tabla `order_products`
--
ALTER TABLE `order_products`
 ADD KEY `fk_order_id` (`order_id`), ADD KEY `fk_product_id` (`product_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `customer`
--
ALTER TABLE `customer`
MODIFY `customerid` int(30) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `customerorder`
--
ALTER TABLE `customerorder`
MODIFY `orderid` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `customer_order`
--
ALTER TABLE `customer_order`
ADD CONSTRAINT `fk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customerid`),
ADD CONSTRAINT `fk_order` FOREIGN KEY (`order_id`) REFERENCES `customerorder` (`orderid`);

--
-- Filtros para la tabla `order_products`
--
ALTER TABLE `order_products`
ADD CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `customerorder` (`orderid`),
ADD CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
