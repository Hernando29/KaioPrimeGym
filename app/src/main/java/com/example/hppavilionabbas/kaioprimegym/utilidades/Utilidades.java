package com.example.hppavilionabbas.kaioprimegym.utilidades;

public class Utilidades
{
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE `usuario` (\n" +
            "  `id_usuario` int(11) NOT NULL,\n" +
            "  `cedula` int(11) NOT NULL,\n" +
            "  `nombre` varchar(50),\n" +
            "  `apellido` varchar(50) ,\n" +
            "  `sexo` varchar(50) ,\n" +
            "  `edad` int(11) NOT NULL,\n" +
            "  `telefono` int(11) NOT NULL,\n" +
            "  `contraseÃ±a` varchar(100) ,\n" +
            "  `correo` varchar(100) ,\n" +
            "  `f_nacimiento` int(11) NOT NULL,\n" +
            "  `foto` text \n" +
            ") ";
}
