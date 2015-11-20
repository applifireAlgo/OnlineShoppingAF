

ALTER TABLE `ast_Brand_M` ADD CONSTRAINT FOREIGN KEY (`product`) REFERENCES `ast_Product_M`(`productId`);

