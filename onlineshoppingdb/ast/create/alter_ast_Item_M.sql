

ALTER TABLE `ast_Item_M` ADD CONSTRAINT FOREIGN KEY (`brand`) REFERENCES `ast_Brand_M`(`brandId`);



ALTER TABLE `ast_Item_M` ADD CONSTRAINT FOREIGN KEY (`product`) REFERENCES `ast_Product_M`(`productId`);



ALTER TABLE `ast_Item_M` ADD CONSTRAINT FOREIGN KEY (`category`) REFERENCES `ast_Category_M`(`categoryId`);

