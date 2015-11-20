DROP TABLE IF EXISTS `ast_OrderDetail_TP`;

CREATE TABLE `ast_OrderDetail_TP` ( `orderId` VARCHAR(256) NOT NULL, `orderdetId` VARCHAR(256) NOT NULL, `itemId` VARCHAR(256) NOT NULL, `price` DOUBLE(10,2) NOT NULL, `qty` INT(10) NOT NULL, `subTotal` DOUBLE(10,2) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`orderdetId`));

