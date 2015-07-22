CREATE TABLE order_item
(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    productId INT NOT NULL,
    productName VARCHAR(100) NOT NULL,
    productPrice DOUBLE NOT NULL,
    productPreferentialPrice DOUBLE NOT NULL,
    buyNum INT NOT NULL
);

CREATE TABLE order
(
    orderCode VARCHAR(50) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(80) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    totalPrice DOUBLE NOT NULL,
    createTime DATETIME NOT NULL,
    paymentWay INT NOT NULL,
    orderState INT NOT NULL
);

CREATE TABLE 订单信息表
(
    订单编号 VARCHAR(30) PRIMARY KEY NOT NULL,
    收货人姓名 VARCHAR(30),
    送货地址 VARCHAR(80),
    联系电话 VARCHAR(11),
    订单总金额 DOUBLE,
    下单时间 DATETIME,
    支付方式 VARCHAR(20),
    订单状态 VARCHAR(20),
    客户ID INT,
    FOREIGN KEY (客户ID) REFERENCES 注册信息表 (注册用户ID)
);
CREATE INDEX FKD6C76CA780515BEE ON 订单信息表 (客户ID);


