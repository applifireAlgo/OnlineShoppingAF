

ALTER TABLE `ast_Category_M` ADD CONSTRAINT FOREIGN KEY (`brand`) REFERENCES `ast_Brand_M`(`brandId`);



ALTER TABLE `ast_Category_M` ADD CONSTRAINT FOREIGN KEY (`product`) REFERENCES `ast_Product_M`(`productId`);

