CREATE TABLE productinfo
(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    goodsCode VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    goodsPrice DOUBLE NOT NULL,
    goodsPreferentialPrice DOUBLE NOT NULL,
    goodsStockNumber INT DEFAULT 0 NOT NULL,
    goodsImageAddress VARCHAR(200) NOT NULL,
    bigImageAddress VARCHAR(200) NOT NULL,
    createTime DATETIME NOT NULL,
    commend INT DEFAULT 0 NOT NULL,
    sellCount INT DEFAULT 0 NOT NULL
);
