Estructura de la base de datos:

    Tabla de Bicicletas:
        CodigoBicicleta (Clave Primaria, identificador único)
        Marca
        Modelo
        Color
        TipoBicicletaCodigo (Clave Foránea referenciando la tabla de Tipos de Bicicletas)
    Tabla de Tipos de Bicicletas:
        TipoBicicletaCodigo (Clave Primaria, identificador único)
        Tipo ("Paseo," "Montaña," "Carrera")
        Descripcion 
    Tabla de Clientes:
        CodigoCliente (Clave Primaria, identificador único, autoincremental)
        Nombre
        Apellido
        Telefono (Puede ser opcional)
        DNI
        Domicilio
        CodigoBicicleta (Clave Foránea referenciando la tabla de Bicicletas, con valor predeterminado 0 si aún no tiene una bicicleta)

CÓDIGO PARA CREAR LAS TABLAS DE ARRIBA:

CREATE TABLE Bicicletas (
    Codigo INT UNSIGNED NOT NULL PRIMARY KEY,
    Marca VARCHAR(50),
    Modelo VARCHAR(50),
    Color VARCHAR(50),
    TipoBicicletaCodigo INT,
    FOREIGN KEY (TipoBicicletaCodigo) REFERENCES TiposDeBicicleta (TipoBicicletaCodigo)
);
CREATE TABLE TiposDeBicicleta (
    TipoBicicletaCodigo INT UNSIGNED NOT NULL PRIMARY KEY,
    Tipo ENUM('paseo', 'montaña', 'carrera') NOT NULL,
    Descripcion VARCHAR(255)
);
CREATE TABLE Clientes (
    CodigoCliente INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Telefono VARCHAR(20) NOT NULL,
    DNI INT(10),
    Domicilio VARCHAR(50),
    CodigoBicicleta INT UNSIGNED DEFAULT 0,
    FOREIGN KEY (CodigoBicicleta) REFERENCES Bicicletas (Codigo)
);

Consulta SQL para obtener el Nombre y Apellido del cliente, la Marca y Modelo de la bicicleta que tiene y la Descripción del tipo de bicicleta:

SELECT
    Clientes.Nombre,
    Clientes.Apellido,
    Bicicletas.Marca,
    Bicicletas.Modelo,
    TiposDeBicicleta.Descripcion AS DescripcionTipoBicicleta
FROM
    Clientes
LEFT JOIN
    Bicicletas ON Clientes.CodigoBicicleta = Bicicletas.Codigo
LEFT JOIN
    TiposDeBicicleta ON Bicicletas.TipoBicicletaCodigo = TiposDeBicicleta.TipoBicicletaCodigo;
