-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: travel_go
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `group_member`
--

DROP TABLE IF EXISTS `group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_member` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `group_id` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpy45r2qx8a2vqafo7rste49c` (`user_id`),
  KEY `FKqp92s7smbt69j5dqexgqyhr9b` (`group_id`),
  CONSTRAINT `FKpy45r2qx8a2vqafo7rste49c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKqp92s7smbt69j5dqexgqyhr9b` FOREIGN KEY (`group_id`) REFERENCES `travel_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_member`
--

LOCK TABLES `group_member` WRITE;
/*!40000 ALTER TABLE `group_member` DISABLE KEYS */;
INSERT INTO `group_member` VALUES (11,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',53,'admin'),(12,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',54,'admin'),(13,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',55,'admin'),(15,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',57,'admin'),(16,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',58,'admin'),(30,'EjdJpyTQK3XixFmPP9cXrCNuuay2',55,'member'),(33,'EjdJpyTQK3XixFmPP9cXrCNuuay2',57,'member'),(34,'EjdJpyTQK3XixFmPP9cXrCNuuay2',61,'member'),(44,'YrqdwzMXb9aotGRQf7IPhkvCaBF2',61,'member'),(48,'yLtUpaKktZWiUFv9PALw75sRCex2',57,'member'),(50,'yLtUpaKktZWiUFv9PALw75sRCex2',53,'member');
/*!40000 ALTER TABLE `group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_post`
--

DROP TABLE IF EXISTS `group_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_post` (
  `group_post_id` varchar(255) NOT NULL,
  `check_in_location` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `group_id` bigint DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_post_id`),
  KEY `FKjo6x6k5clwb9lo1to4a00r9f` (`user_id`),
  KEY `FK63gjusrn54n3bwvtninrud42` (`group_id`),
  CONSTRAINT `FK63gjusrn54n3bwvtninrud42` FOREIGN KEY (`group_id`) REFERENCES `travel_group` (`id`),
  CONSTRAINT `FKjo6x6k5clwb9lo1to4a00r9f` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_post`
--

LOCK TABLES `group_post` WRITE;
/*!40000 ALTER TABLE `group_post` DISABLE KEYS */;
INSERT INTO `group_post` VALUES ('-NjvIpy4ySmReBOTx5rj','Sơn Tây, Hanoi, Vietnam',21.1162257,105.495325,'1700728367101','hehehe',NULL,'image',NULL,53,'gcIPbK6kb1T5qEVVzN2xUlkhiL53');
/*!40000 ALTER TABLE `group_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_post_images`
--

DROP TABLE IF EXISTS `group_post_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_post_images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `group_post_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKepm2abnjn265n4d7p0lntru5i` (`group_post_id`),
  CONSTRAINT `FKepm2abnjn265n4d7p0lntru5i` FOREIGN KEY (`group_post_id`) REFERENCES `group_post` (`group_post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_post_images`
--

LOCK TABLES `group_post_images` WRITE;
/*!40000 ALTER TABLE `group_post_images` DISABLE KEYS */;
INSERT INTO `group_post_images` VALUES (35,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','-NjvIpy4ySmReBOTx5rj'),(36,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','-NjvIpy4ySmReBOTx5rj'),(37,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','-NjvIpy4ySmReBOTx5rj');
/*!40000 ALTER TABLE `group_post_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_request`
--

DROP TABLE IF EXISTS `group_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_request` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `group_id` bigint DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `from_user_id` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2cs60n9kmb91s2f52ai3b3vs4` (`group_id`),
  KEY `FKsmkdy4xbx0sqk5llq42h2894o` (`user_id`),
  KEY `FKquvyh1v4lttda1xtpn2o3h183` (`from_user_id`),
  CONSTRAINT `FK2cs60n9kmb91s2f52ai3b3vs4` FOREIGN KEY (`group_id`) REFERENCES `travel_group` (`id`),
  CONSTRAINT `FKquvyh1v4lttda1xtpn2o3h183` FOREIGN KEY (`from_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKsmkdy4xbx0sqk5llq42h2894o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_request`
--

LOCK TABLES `group_request` WRITE;
/*!40000 ALTER TABLE `group_request` DISABLE KEYS */;
INSERT INTO `group_request` VALUES (66,'1701876670467','invite',63,'YrqdwzMXb9aotGRQf7IPhkvCaBF2','gcIPbK6kb1T5qEVVzN2xUlkhiL53','Mời bạn tham gia nhóm ababa'),(68,'1702826167991','invite',57,'gcIPbK6kb1T5qEVVzN2xUlkhiL53','yLtUpaKktZWiUFv9PALw75sRCex2','Mời bạn tham gia nhóm avava4'),(69,'1702826168712','invite',57,'EjdJpyTQK3XixFmPP9cXrCNuuay2','yLtUpaKktZWiUFv9PALw75sRCex2','Mời bạn tham gia nhóm avava4');
/*!40000 ALTER TABLE `group_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interest`
--

DROP TABLE IF EXISTS `interest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interest`
--

LOCK TABLES `interest` WRITE;
/*!40000 ALTER TABLE `interest` DISABLE KEYS */;
INSERT INTO `interest` VALUES (1,'Du lịch biển'),(2,'Thám hiểm rừng núi'),(3,'Du lịch phượt'),(4,'Du lịch mua sắm'),(5,'Thiên nhiên và cảnh đẹp'),(6,'Du lịch gia đình'),(7,'Du lịch mạo hiểm'),(8,'Nghỉ dưỡng và sức khỏe'),(9,'Thể Thao và Hoạt Động Ngoại Trời'),(10,'Du lịch vui chơi và giải trí đêm'),(11,'Nghệ thuật và văn hóa địa phương'),(12,'Du lịch phong cách sống và thư giãn'),(13,'Văn hóa và di tích lịch sử'),(14,'Đô Thị và Thương Mại'),(15,'Du lịch ẩm thực và ẩm thực địa phương');
/*!40000 ALTER TABLE `interest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` longtext,
  `tag` varchar(255) DEFAULT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (2,'Thành phố Hồ Chí Minh','TP HCM là nơi hội tụ nhiều nền văn hóa, với các sản phẩm du lịch đa dạng, là \"thành phố không ngủ\" với những hoạt động vui chơi, giải trí sôi động cả ngày lẫn đêm.Nắng nóng không khắc nghiệt như thời tiết miền Bắc, nên du khách có thể ghé thăm thành phố bất kể thời điểm nào trong năm. Nếu đến vào mùa mưa, nên chuẩn bị ô để tránh những cơn mưa rào bất chợt.','du lịch ẩm thực, giải trí đêm, mua sắm,đô thị và thương mại','https://vnexpress.net/cam-nang-du-lich-tp-hcm-4608205.html'),(3,'Hải Phòng','Du lịch Thành phố Hải Phòng, cảng biển sôi động của Việt Nam, là điểm đến tuyệt vời cho những người muốn khám phá sự hòa quyện giữa văn hóa truyền thống và sự phồn thịnh hiện đại. Với bãi biển dịu dàng và những ngôi đền lịch sử, Hải Phòng hứa hẹn mang đến trải nghiệm độc đáo và phong phú.Điểm đặc biệt của Hải Phòng chính là Cảng Cát Bà, một trong những kỳ quan thiên nhiên của Việt Nam. Hòa mình vào vẻ đẹp hùng vĩ của các dãy núi đá vôi, khám phá các hang động lạ mắt và tận hưởng những bãi biển cát trắng như tuyết. Cảm giác hòa mình vào không gian thiên nhiên hoang sơ là điều không thể nào quên.Không chỉ có thiên nhiên, Hải Phòng còn là nơi của những công trình kiến trúc lịch sử nổi tiếng như Đền Ngô Quyền, là kỷ niệm về chiến thắng lịch sử của nhân dân Việt Nam. Đền đồng thời còn là điểm du lịch mang đậm giá trị tâm linh.Những góc phố cổ của Hải Phòng là nơi lưu giữ nét đẹp truyền thống, với các quán cà phê cổ kính và những con đường nhỏ đánh dấu bằng các tòa nhà kiến trúc cổ điển. Điều này tạo nên một không khí bình yên, dễ chịu và gần gũi với lòng người.Đặc sản ẩm thực của Hải Phòng cũng là điểm đặc sắc không thể bỏ qua. Những món hải sản tươi ngon như sò điệp, mực nước, và cua đỏ Hải Phòng đều là những món ăn khiến thực khách mê mẩn. Đừng quên thưởng thức các món đặc sản như bún cá, bánh đậu xanh, hay nem cua bể nổi tiếng.Tóm lại, Hải Phòng không chỉ là thành phố cảng quan trọng mà còn là địa điểm du lịch tuyệt vời với cảnh đẹp tự nhiên và văn hóa độc đáo, cũng như ẩm thực phong phú và đặc sắc. Đến Hải Phòng, du khách sẽ được tận hưởng sự đa dạng và phong phú của Việt Nam, từ biển cả đến những con người thân thiện và nhiệt huyết.','du lịch biển,ẩm thực,thiên nhiên và cảnh đẹp,cảnh quan','https://vnexpress.net/cam-nang-du-lich-hai-phong-4462112.html'),(4,'Đà nẵng','Du lịch Đà Nẵng,với lợi thế về vị trí địa lý và điều kiện tự nhiên, Đà Nẵng may mắn khi sở hữu nhiều bãi biển đẹp, trải dài thoai thoải và cát trắng miên man. Biển Đà Nẵng được tạp chí Forbes (Mỹ) bình chọn là một trong 6 bãi biển quyến rũ nhất hành tinh. Nếu bạn là người yêu biển chắc chắn sẽ thỏa mãn khi được ngụp lặn trong nước biếc, đùa giỡn với những con sóng hay các trò chơi như lướt ván, chèo thuyền chuối, motor nước.Không chỉ nổi tiếng với những bãi biển, nơi đây còn mang nét đẹp hấp dẫn khi có bản đảo Sơn Trà vươn mình ra biển, có đèo Hải Vân – “thiên hạ đệ nhất hùng quang” với cảnh quan ngoạn mục. Và không thể không nhắc đến đó là danh thắng Ngũ Hành Sơn, đăc biệt là Bà Nà Hills – cái tên làm nên thương hiệu cho du lịch Đà Nẵng và còn rất nhiều địa danh khác nữa.Nằm ở vùng Nam Trung Bộ, Đà Nẵng có cả núi, đồng bằng và biển. Các điểm tham quan du lịch nổi tiếng khi du lịch Đà Nẵng bao gồm khu du lịch Bà Nà, bãi biển Mỹ Khê, và khu vui chơi giải trí trong nhà Fantasy Park lớn nhất châu Á. Đà Nẵng còn có nhiều thắng cảnh đẹp mê hồn như đèo Hải Vân, rừng nguyên sinh ở bán đảo Sơn Trà và Ngũ Hành Sơn. Đặc biệt, Đà Nẵng được bao quanh bởi 3 di sản văn hóa thế giới là Huế, Hội An và Mỹ Sơn, và xa hơn chút nữa là Vườn Quốc Gia Phong Nha – Kẻ Bàng. Hàng năm, Đà Nẵng tổ chức Lễ hội pháo hoa thu hút rất nhiều du khách muôn phương đến tham dự.Những địa điểm tham quan nổi tiếng ở Đà Nẵng phải kể tới:Bà Nà Hill ','du lịch biển, cảnh quan thiên nhiên,cảnh đẹp, chụp ảnh sống ảo','https://vnexpress.net/cam-nang-du-lich-da-nang-4470111.html'),(5,'Hà Giang','Hà Giang là một tỉnh thuộc vùng Đông Bắc Việt Nam, nằm ở phía bắc của dãy núi Hà Giang, là một phần của dãy núi Himalaya. Đây là một địa điểm du lịch tuyệt vời với vẻ đẹp hoang sơ, hùng vĩ của núi rừng, đồng cỏ bát ngát và sự đa dạng văn hóa của các dân tộc bản địa.Cảnh Đẹp Nổi Bật: Đồng Văn Geopark: Một trong những di sản thiên nhiên và văn hóa quan trọng, với địa hình đá vôi kỳ ảo và là nơi duy nhất tại Việt Nam có động cơ địa chất toàn cảnh,Đèo Mã Pí Lèng: Con đèo nổi tiếng với khung cảnh hùng vĩ, cung đường đèo nối liền các vùng Đồng Văn và Mèo Vạc,Lũng Cúc Phương: Nơi có những cánh đồng lúa bậc thang xanh mướt, tạo nên bức tranh tuyệt vời.Các món ăn đặc sắc phải thử khi tới đây: Thắng Cố (Lòng, Gan, Phổi): Một món ăn truyền thống của người H\'Mông, được chế biến với nhiều gia vị độc đáo,Lam Rừng (Dê Rừng): Một món ngon độc đáo, thường được chế biến thành nhiều món khác nhau,Thịt Gà Đen Yến: Gà đen nổi tiếng ở Hà Giang, thường được nấu thành các món hấp dẫn,Rượu Nếp Cẩm: Một loại rượu truyền thống được làm từ nếp cẩm, có hương vị độc đáo.','rừng núi,thiên nhiên,cảnh quan,phượt,leo núi','https://vnexpress.net/cam-nang-du-lich-ha-giang-4445788.html'),(7,'Lai Châu','Lai Châu, vùng miền thuần khiết nằm giữa những ngọn núi cao nguyên Tây Bắc Việt Nam, là một bí mật được khám phá cho những người yêu thiên nhiên hùng vĩ và muốn tìm hiểu về văn hóa độc đáo của các dân tộc thiểu số. Với cảnh sắc đa dạng từ núi non, thác nước đến những thung lũng xanh ngắt, Lai Châu chính là điểm đến lý tưởng cho những hành trình khám phá.Được biết đến với đỉnh Fansipan. Lai Châu tự hào là nơi có đỉnh núi cao nhất Đông Dương, nơi thu hút đông đảo người dũng cảm thách thức chính mình với những đường dẫn leo núi đầy thách thức. Tại đây, bạn sẽ không chỉ được hòa mình trong không khí tinh khôi của núi rừng mà còn có cơ hội trải nghiệm cuộc sống của những dân tộc bản địa.Với đa dạng văn hóa dân tộc, Lai Châu tự hào giới thiệu với du khách về văn hóa của các bộ tộc như H\'Mông, Thái, Dao, với những lễ hội truyền thống sặc sỡ và những sản phẩm thủ công truyền thống độc đáo. Các bản làng cổ kính, những cây cầu treo nguyên thủy và những ngôi nhà tranh thủy tinh độc đáo là những điểm đặc sắc khó quên khi đặt chân đến Lai Châu.Nếu nói về ẩm thực, Lai Châu không chỉ dừng lại ở cảnh đẹp tự nhiên hùng vĩ mà còn khiến thực khách mê mẩn bởi những món ăn truyền thống độc đáo. Những món như cơm lam, mèn mén, thắng cố, và các món từ rau củ quả tươi ngon đều mang đậm hương vị núi rừng và văn hóa dân dụ.Lai Châu, với vẻ đẹp hòa quyện giữa núi rừng và văn hóa dân tộc, là điểm đến lý tưởng cho những tâm hồn phiêu lưu và muốn khám phá những giá trị truyền thống độc đáo của Việt Nam.','rừng núi,thiên nhiên,phượt,leo núi','https://vnexpress.net/nhung-diem-den-dep-nhat-lai-chau-3384024.html'),(8,'Lào Cai','Lào Cai, viên ngọc quý bên cạnh dãy núi hùng vĩ của dãy Hoàng Liên, là điểm đến hấp dẫn với những ai mong muốn khám phá vẻ đẹp hài hòa giữa thiên nhiên hoang sơ và văn hóa dân tộc phong phú. Điểm nổi bật nhất của Lào Cai chính là thị trấn núi Sapa, một thiên đường nghỉ dưỡng nằm ẩn mình trong mây và gió.Với đỉnh Fansipan, đỉnh núi cao nhất Đông Dương, Sapa không chỉ là một thách thức cho những người yêu leo núi mà còn là niềm mơ ước của những tâm hồn phiêu lưu. Từ đỉnh núi, bạn có thể tận hưởng cái nhìn bao quát, hòa mình trong sự hùng vĩ của dãy núi và những thửa ruộng bậc thang xanh tốt.Với văn hóa đa dạng của các dân tộc bản địa như H\'Mông, Dao, và Thái, Lào Cai là nơi hội tụ của những lễ hội truyền thống sôi động. Những buổi hòa nhạc dân tộc, lễ hội mùa lúa chín, và thậm chí là thị trấn chợ nổi tiếng của Sapa mang đến cho du khách trải nghiệm văn hóa độc đáo mà không giới hạn.Không chỉ nổi tiếng với cảnh đẹp tự nhiên, Lào Cai còn khiến thực khách phải đắm chìm trong hương vị tinh tế của ẩm thực địa phương. Những món như thắng cố, lợn cắp nách, cơm lam, và rất nhiều đặc sản khác đều làm say đắm bất cứ ai từng ghé thăm vùng miền này.Lào Cai, với vẻ đẹp hoang sơ và văn hóa dân tộc phong phú, là điểm đến không thể bỏ lỡ cho những người muốn tận hưởng trọn vẹn vẻ đẹp của miền núi phía Bắc Việt Nam.','rừng núi,thiên nhiên,cảnh quan,chụp ảnh,phượt,leo núi','https://vnexpress.net/san-may-ngam-rung-phong-thay-la-tren-dinh-ngu-chi-son-4673481.html'),(9,'Tuyên Quang','Tuyên Quang là tỉnh miền núi nằm ở vùng Đông Bắc nước ta, cách Hà Nội khoảng 165 km về phía Bắc. Diện tích tự nhiên là 5.870 km2, dân số trên 732.256 ngàn người với 22 dân tộc cùng chung sống. Tuyên Quang là tỉnh hội tụ đủ các thế mạnh để phát triển các loại hình du lịch: Lịch sử, tâm linh, sinh thái, văn hoá. Với hơn 500 di tích lịch sử, văn hóa trên địa bàn, tỉnh Tuyên Quang được ví như một bảo tàng cách mạng của cả nước. Bên cạnh đó, tỉnh còn là nơi khởi phát, hội tụ, giao thoa của văn hoá các dân tộc thiểu số vùng núi phía Bắc với nhiều lễ hội đặc sắc, những truyền thuyết, những làn điệu dân ca thắm đượm tình người, là nơi được thiên nhiên ban tặng nhiều cảnh đẹp nên thơ. Con người nơi đây từ lâu đã có tiếng không chỉ ở vẻ đẹp bên ngoài mà còn ẩn chứa vẻ đẹp tâm hồn nhân hậu, đằm thắm và hiếu khách. Tuyên Quang hứa hẹn là một điểm đến hấp dẫn với khách du lịch.','rừng núi,thiên nhiên,phượt,leo núi,văn hóa','https://vnexpress.net/thien-nhien-ky-thu-o-tuyen-quang-4297215.html'),(11,'Cát Bà','Cát Bà là điểm thu hút khách du lịch tại Hải Phòng, thật khó khi cưỡng lại nét hấp dẫn của hòn đảo này. Nằm gần quần thể Vịnh Hạ Long, cụ thể thì quần đảo Cát Bà nằm ở phía Nam của Vịnh Hạ Long, do đó, nơi này cũng thừa hưởng những nét đẹp độc đáo mà chỉ ở khu vực Hạ Long mới có.Quần đảo Cát Bà bao gồm 367 đảo lớn nhỏ, trong đó đảo chính của Cát Bà rộng lớn. Đảo Cát Bà cách trung tâm Thành phố Hải Phòng khoảng 40km, cách đảo Tuần Châu Hạ Long khoảng 20km về hướng Nam và cách thủ đô Hà Nội khoảng 160km','du lịch biển,thiên nhiên và cảnh đẹp,ẩm thực và địa phương','https://vnexpress.net/cam-nang-du-lich-cat-ba-4136515.html'),(12,'Hạ Long','Cách Hà Nội khoảng 160 km, TP biển Hạ Long thuộc tỉnh Quảng Ninh là một điểm du lịch nổi tiếng không chỉ của miền Bắc, toàn quốc mà trên khắp thế giới. Hạ Long có vịnh biển, có các di sản thế giới, các hoạt động du lịch phong phú, đồ ăn ngon.TP Hạ Long nằm ở miền Bắc nên khí hậu đủ 4 mùa. Các tháng 4-6 trời ấm không mưa, tháng 6-8 nắng nóng có thể có mưa bão, tháng 9-12 tiết trời mát dần và trở lạnh. Mỗi mùa ở đây lại có một vẻ đẹp riêng, mùa hè bạn tới Hạ Long bơi lội, tắm nắng thì mùa xuân, thu mát mẻ thích hợp để ngắm một Hạ Long bớt ồn ào hơn và tham gia các hoạt động ngoài trời cũng như khám phá các khu vui chơi giải trí. Mùa cao điểm là từ tháng 6 đến tháng 8, thành phố đông đúc, đặc biệt vào dịp cuối tuần.','du lịch biển,thiên nhiên và cảnh quan,ẩm thực','https://vnexpress.net/cam-nang-du-lich-ha-long-4457134.html'),(13,'Phú Quốc','Quần đảo Phú Quốc nằm trong vịnh Thái Lan, cách TP HCM khoảng 400 km về hướng tây. Nơi đây thu hút du khách trong và ngoài nước bởi các loại hình du lịch đa dạng, với tài nguyên biển, đảo phong phú; hệ sinh thái rừng, biển đa dạng.Vùng biển Phú Quốc có 22 hòn đảo lớn, nhỏ, tổng diện tích khoảng 589,23 km2. Trong đó, đảo Phú Quốc lớn nhất được chia thành bắc đảo và nam đảo. Thị trấn Dương Đông nằm ở trung tâm.','du lịch biển,thiên nhiên và cảnh quan,ẩm thực,du lịch gia đình','https://vnexpress.net/cam-nang-du-lich-phu-quoc-4106697.html'),(14,'Cao Bằng','Cao Bằng là tỉnh miền núi nằm ở vùng Đông Bắc, với đường biên giới dài trên 300 km, giáp Trung Quốc. Địa thế hiểm trở nhưng thiên nhiên tươi đẹp, có cả núi non, hệ thống hang động và hồ nước... vẻ đẹp Cao Bằng được tôn lên gấp bội.Từ tháng 8 đến tháng 9 là mùa đẹp của Cao Bằng khi thác Bản Giốc đổ nước nhiều và trong xanh, nhiều đoạn ruộng bậc thang chín vàng.Mùa mưa từ tháng 6 đến tháng 9, nước tuôn trào, tung bọt trắng xóa. Mùa khô từ tháng 10 đến tháng 5 năm sau, trời lạnh hơn, nước chảy êm đềm, trong xanh.','rừng núi,phượt,leo núi,văn hóa lịch sử','https://vnexpress.net/cam-nang-du-lich-cao-bang-4445913.html'),(15,'Lạng Sơn','Lạng Sơn giáp tỉnh Cao Bằng, Quảng Ninh, Bắc Giang, Bắc Kạn, Thái Nguyên, và thành phố Sùng Tả (tỉnh Quảng Tây, Trung Quốc). Tỉnh có một thành phố và 10 huyện.Lạng Sơn có nhiều danh lam thắng cảnh, non nước hữu tình, di tích lịch sử cùng những phong tục mang đậm bản sắc dân tộc như văn hóa khảo cổ Bắc Sơn, văn hóa Mai Pha. Các điểm du lịch của tỉnh tập trung ở thành phố Lạng Sơn, huyện Bắc Sơn, huyện Hữu Lũng, Bình Gia, Lộc Bình. Tỉnh cũng có hàng trăm lễ hội văn hoá dân gian.','rừng núi,phượt,leo núi,văn hóa lịch sử','https://vnexpress.net/cam-nang-du-lich-lang-son-4660039.html'),(29,'Hà Nội','Hà Nội có lịch sử lâu đời cùng văn hóa truyền thống đậm đà bản sắc của dân tộc Việt Nam, là địa điểm du lịch vô cùng quyến rũ. Mảnh đất Thủ đô là nơi có nhiều di tích nhất tại Việt Nam, với 3840 di tích và 1164 di tích cấp quốc gia.Cùng với những điểm dã ngoại lý tưởng như: Làng cổ đường Lâm – Địa điểm “sống ảo’ đầy lý thú Hồ Quan Sơn – Hạ Long trên cạn Khu du lịch Đồng Mô Khu sinh thái Chùa Trầm Hàm Lợn – Địa điểm dã ngoại lý tưởng Khu sinh thái Ba Vì My Hill Sóc Sơn – Khu du lịch sinh thái nổi tiếng Đền gióng – Sóc sơn Làng văn hóa 54 dân tộc Không quên thưởng thức những món ăn đặc sản Hà Nội hấp dẫn thực khách gần xa: Phở Hà Nội Bún chả Bún thang Bánh tôm Hồ Tây Bún đậu mắm tôm Chả cá Lã Vọng Bánh cốm Làng Vòng Bánh giò Chả rươi Cháo sườn Bánh cuốn Thanh Trì Kem Tràng Tiền','di tích lịch sử,văn hóa,du lịch ẩm thực','https://vnexpress.net/cam-nang-du-lich-ha-noi-4459188.html');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_images`
--

DROP TABLE IF EXISTS `location_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `location_id` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjiyk3iv1a4sk7o5u4sjtchuyb` (`location_id`),
  CONSTRAINT `FKjiyk3iv1a4sk7o5u4sjtchuyb` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_images`
--

LOCK TABLES `location_images` WRITE;
/*!40000 ALTER TABLE `location_images` DISABLE KEYS */;
INSERT INTO `location_images` VALUES (7,29,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/uploads%2Ftrung-tam-thanh-pho-ha-noi-603da1f235b38.jpg?alt=media&token=2e749199-d6a0-4256-82be-67b89e160589'),(8,29,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/uploads%2Ftrung-tam-thanh-pho-ha-noi-603da1f235b38.jpg?alt=media&token=2e749199-d6a0-4256-82be-67b89e160589'),(9,29,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/uploads%2Ftrung-tam-thanh-pho-ha-noi-603da1f235b38.jpg?alt=media&token=2e749199-d6a0-4256-82be-67b89e160589'),(10,4,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/uploads%2Ftrung-tam-thanh-pho-ha-noi-603da1f235b38.jpg?alt=media&token=2e749199-d6a0-4256-82be-67b89e160589'),(12,5,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(14,2,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(15,3,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(16,7,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(17,8,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(18,9,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(21,11,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(22,12,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(23,13,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(24,14,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718'),(25,15,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718');
/*!40000 ALTER TABLE `location_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_invitation` bit(1) DEFAULT NULL,
  `is_post` bit(1) DEFAULT NULL,
  `owner_id` varchar(255) DEFAULT NULL,
  `post_id` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `is_request` bit(1) DEFAULT NULL,
  `group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKblajhiht7bx2u2v4nbio0r3rq` (`group_id`),
  KEY `FKb0yvoep4h4k92ipon31wmdf7e` (`user_id`),
  CONSTRAINT `FKb0yvoep4h4k92ipon31wmdf7e` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKblajhiht7bx2u2v4nbio0r3rq` FOREIGN KEY (`group_id`) REFERENCES `travel_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (2,_binary '\0',_binary '','1cCHibSQmjQuc65S3VhIfKJ6Nmu2','-NftWmtxUIkVPsTWVkGi','1696403477780','Tuan đã like ảnh của bạn','EjdJpyTQK3XixFmPP9cXrCNuuay2',NULL,NULL),(3,_binary '\0',_binary '','1cCHibSQmjQuc65S3VhIfKJ6Nmu2','-NftWmtxUIkVPsTWVkGi','1696403477785','Tuan đã like ảnh của bạn','EjdJpyTQK3XixFmPP9cXrCNuuay2',NULL,NULL),(4,_binary '\0',_binary '','gcIPbK6kb1T5qEVVzN2xUlkhiL53','-NftWmtxUIkVPsTWVkGi','1696403477785','Tuan đã like ảnh của bạn','EjdJpyTQK3XixFmPP9cXrCNuuay2',NULL,NULL),(30,NULL,_binary '\0','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','','1698597059898','tuankt started following you','YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL,NULL),(31,NULL,_binary '\0','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','','1698597061537','tuankt started following you','YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL,NULL),(32,NULL,_binary '\0','yLtUpaKktZWiUFv9PALw75sRCex2','','1698639405258','tuan307 started following you','YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL,NULL),(33,NULL,_binary '','YrqdwzMXb9aotGRQf7IPhkvCaBF2','-NiG0PJZM7arNubpK5wz','1699609864798',' đã thích bài viết của bạn','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(34,NULL,_binary '\0','YrqdwzMXb9aotGRQf7IPhkvCaBF2','','1699611164766','callmtuan started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(35,NULL,_binary '','YrqdwzMXb9aotGRQf7IPhkvCaBF2','-NiG0PJZM7arNubpK5wz','1699972515276',' đã thích bài viết của bạn','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(38,_binary '',NULL,'EjdJpyTQK3XixFmPP9cXrCNuuay2',NULL,'1700725665774','Mời bạn tham gia nhóm aav','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,53),(39,_binary '',NULL,'YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL,'1700725667761','Mời bạn tham gia nhóm aav','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,53),(41,_binary '',NULL,'n7kvXHm6Q2Ym7nSYSoCfreh9xDy2',NULL,'1700725691982','Mời bạn tham gia nhóm aav','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,53),(45,NULL,_binary '\0','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','','1701595662444','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(46,NULL,_binary '\0','yLtUpaKktZWiUFv9PALw75sRCex2','','1701595977637','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(47,NULL,_binary '\0','yLtUpaKktZWiUFv9PALw75sRCex2','','1701595994362','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(48,NULL,_binary '\0','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','','1701596001602','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(49,NULL,_binary '\0','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','','1701596466603','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(50,NULL,_binary '\0','yLtUpaKktZWiUFv9PALw75sRCex2','','1701596473704','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(51,NULL,_binary '\0','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','','1701789084232','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(52,NULL,_binary '\0','EjdJpyTQK3XixFmPP9cXrCNuuay2','','1701794972365','tuan1062001 started following you','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,NULL),(53,_binary '',NULL,'YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL,'1701876670467','Mời bạn tham gia nhóm ababa','gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,63),(54,NULL,_binary '','gcIPbK6kb1T5qEVVzN2xUlkhiL53','-NlQztSJCdWiej7Argap','1702825936938',' đã thích bài viết của bạn','yLtUpaKktZWiUFv9PALw75sRCex2',NULL,NULL),(55,NULL,_binary '','gcIPbK6kb1T5qEVVzN2xUlkhiL53','1699972015235g','1702825942425',' đã thích bài viết của bạn','yLtUpaKktZWiUFv9PALw75sRCex2',NULL,NULL),(56,_binary '',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL,'1703060487490','Đã gửi yêu cầu tham gia nhóm','yLtUpaKktZWiUFv9PALw75sRCex2',_binary '',53),(57,_binary '',NULL,'EjdJpyTQK3XixFmPP9cXrCNuuay2',NULL,'1702826168712','Mời bạn tham gia nhóm avava4','yLtUpaKktZWiUFv9PALw75sRCex2',NULL,57);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_id` varchar(255) NOT NULL,
  `check_in_location` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FKjyeeshcmb5202x4ialmtecmqj` (`user_id`),
  CONSTRAINT `FKjyeeshcmb5202x4ialmtecmqj` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES ('-NftWmtxUIkVPsTWVkGi','Nha Trang, Khánh Hòa, Vietnam',12.2529152,109.1899018,'1696403477783','yeahhh','image',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL),('-Ng-lHlqt2_mY5-ZPEXa','Da Nang, Hải Châu District, Da Nang, Vietnam',16.0544068,108.2021667,'1696525008549','sssssbsbsb','image',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL),('-Ng-lUK0FTT8sgF6qtzl','London, UK',51.5072178,-0.1275862,'1696525063158','','image',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL),('-Nh_o6ZssJGUnO1EfEIz','Hanoi, Vietnam',21.0031177,105.8201408,'1698220244703','aaaaa','image',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL),('-NhdmBQxMQZxm9WDg1MN','Sa Pa, Lao Cai, Vietnam',22.3363608,103.8437852,'1698286849895','Sapa mood','image',NULL,'YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL),('-NiG-Cr8LKUO3Fn8sFHR','Nha Trang, Khánh Hòa, Vietnam',12.2529152,109.1899018,'1698944838863','nha trang','image',NULL,'YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL),('-NiG0PJZM7arNubpK5wz','Sơn Tây, Hanoi, Vietnam',21.1162257,105.495325,'1698945151563','Son tay','image',NULL,'YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL),('-NlQztSJCdWiej7Argap','Hanoi, Vietnam',21.0277644,105.8341598,'1702350530515','abababa','image',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53',NULL),('1699972015235g','Hanoi, Vietnam',21.0277644,105.8341598,'1699972015239','aahahah','question',NULL,'gcIPbK6kb1T5qEVVzN2xUlkhiL53','aahahah');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_images`
--

DROP TABLE IF EXISTS `post_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `post_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4436mqgshkhub17yvq5ku91f7` (`post_id`),
  CONSTRAINT `FK4436mqgshkhub17yvq5ku91f7` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_images`
--

LOCK TABLES `post_images` WRITE;
/*!40000 ALTER TABLE `post_images` DISABLE KEYS */;
INSERT INTO `post_images` VALUES (46,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696403474089.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=2a6a9a73-e21a-404c-b85d-4a93b4fb208d','-NftWmtxUIkVPsTWVkGi'),(47,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696403474132.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=037b4728-1792-4891-badd-9bbc9542028a','-NftWmtxUIkVPsTWVkGi'),(48,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696403474162.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=1b47df1b-b08c-49b2-9726-40adfcd7399d','-NftWmtxUIkVPsTWVkGi'),(49,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696403474196.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=07623af1-a702-4ae0-9c26-429003d82641','-NftWmtxUIkVPsTWVkGi'),(50,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696403474221.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=4520ad85-b1dc-4051-85e4-39bcc3fab28a','-NftWmtxUIkVPsTWVkGi'),(51,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696525003801.%5Bjpg%2C%20jpg%5D?alt=media&token=a3c8b9eb-e774-4904-9201-40d99923bce6','-Ng-lHlqt2_mY5-ZPEXa'),(52,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696525055160.%5Bjpg%2C%20jpg%2C%20jpg%5D?alt=media&token=0885dd96-32ef-41f7-b9f3-e8543142039b','-Ng-lUK0FTT8sgF6qtzl'),(53,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696525055195.%5Bjpg%2C%20jpg%2C%20jpg%5D?alt=media&token=4c4b950c-e683-4ca4-bff1-2a6b78067572','-Ng-lUK0FTT8sgF6qtzl'),(54,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1696525055220.%5Bjpg%2C%20jpg%2C%20jpg%5D?alt=media&token=76e7d332-88aa-4235-9df9-1fdbdcbc5b81','-Ng-lUK0FTT8sgF6qtzl'),(58,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698220242096.%5Bjpg%2C%20jpg%5D?alt=media&token=a5e225a5-c056-4a68-b79b-a1f26d85ae8d','-Nh_o6ZssJGUnO1EfEIz'),(59,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698286847797.%5Bjpg%5D?alt=media&token=d4057a9d-0e3e-449e-80ac-7a5b1fdfaa11','-NhdmBQxMQZxm9WDg1MN'),(60,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698944836051.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=27e37ffd-f20d-4085-8373-dd66b6b85807','-NiG-Cr8LKUO3Fn8sFHR'),(61,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698944836081.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=60562e24-024b-4f27-adf8-93e06cd8571c','-NiG-Cr8LKUO3Fn8sFHR'),(62,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698944836108.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=e78f0b96-28cc-451e-903d-0d1f56611360','-NiG-Cr8LKUO3Fn8sFHR'),(63,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698944836136.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=a82215f6-80c8-4262-9784-d7eb87c2eb55','-NiG-Cr8LKUO3Fn8sFHR'),(64,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698945149264.%5Bjpg%2C%20jpg%2C%20jpg%5D?alt=media&token=bb150026-5292-43a2-ab60-27841c02b71b','-NiG0PJZM7arNubpK5wz'),(65,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698945149229.%5Bjpg%2C%20jpg%2C%20jpg%5D?alt=media&token=094672df-582b-4ee3-99c5-e74d4db19acd','-NiG0PJZM7arNubpK5wz'),(66,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1698945149323.%5Bjpg%2C%20jpg%2C%20jpg%5D?alt=media&token=13081af4-885f-49dd-8346-4839707988cb','1699972015235g'),(67,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1702350525618.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=05e8e49e-62d4-4b7e-bb9c-6ecdae727f28','-NlQztSJCdWiej7Argap'),(68,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1702350525708.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=a41aa4c8-2ca1-4612-84a1-2795842cdbfa','-NlQztSJCdWiej7Argap'),(69,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1702350525742.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=d2e64a66-9f5f-4b99-af93-9e92b13664fe','-NlQztSJCdWiej7Argap'),(70,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1702350525795.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=42df2b6c-29bc-4c4c-ba5e-43064b77edbe','-NlQztSJCdWiej7Argap'),(71,'https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1702350525816.%5Bjpg%2C%20jpg%2C%20jpg%2C%20jpg%2C%20jpg%5D?alt=media&token=fd27f80a-de37-4354-a714-8f941279ad66','-NlQztSJCdWiej7Argap');
/*!40000 ALTER TABLE `post_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_post`
--

DROP TABLE IF EXISTS `saved_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_post` (
  `id` bigint NOT NULL,
  `post_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKagh4wy8hqg80mjkje9irv01fb` (`user_id`),
  KEY `FKak0t7w5wsfi4jmjdqxmko2wf4` (`post_id`),
  CONSTRAINT `FKagh4wy8hqg80mjkje9irv01fb` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKak0t7w5wsfi4jmjdqxmko2wf4` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_post`
--

LOCK TABLES `saved_post` WRITE;
/*!40000 ALTER TABLE `saved_post` DISABLE KEYS */;
INSERT INTO `saved_post` VALUES (1,'-Ng-lUK0FTT8sgF6qtzl','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(752,'-NlQztSJCdWiej7Argap','gcIPbK6kb1T5qEVVzN2xUlkhiL53');
/*!40000 ALTER TABLE `saved_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_post_seq`
--

DROP TABLE IF EXISTS `saved_post_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_post_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_post_seq`
--

LOCK TABLES `saved_post_seq` WRITE;
/*!40000 ALTER TABLE `saved_post_seq` DISABLE KEYS */;
INSERT INTO `saved_post_seq` VALUES (851);
/*!40000 ALTER TABLE `saved_post_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_group`
--

DROP TABLE IF EXISTS `travel_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `privacy` varchar(255) DEFAULT NULL,
  `group_owner_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtku91d5e2jjouphss3c3jiopt` (`group_owner_id`),
  CONSTRAINT `FKtku91d5e2jjouphss3c3jiopt` FOREIGN KEY (`group_owner_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_group`
--

LOCK TABLES `travel_group` WRITE;
/*!40000 ALTER TABLE `travel_group` DISABLE KEYS */;
INSERT INTO `travel_group` VALUES (53,'1697042349580','nhom du lich 01','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1703836325119.jpg?alt=media&token=df1f2566-dc18-4b7a-bed8-2ed0c5415983','nhom du lich cua tuan','private','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(54,'1697042378227','avavava1','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','bavavava1','private','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(55,'1697042967676','mamm','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','damamama2','private','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(57,'1697043402072','avavav2','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','avava4','public','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(58,'1697044005356','bab','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','cavava5678','private','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(61,'1697080570325','aoaoa','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718','abaa3','public','YrqdwzMXb9aotGRQf7IPhkvCaBF2'),(63,'1701876662837','tututut','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/new_posts%2F1701876661044.jpg?alt=media&token=68205a12-485c-48d2-941a-f7d5f008d657','baababa','public','gcIPbK6kb1T5qEVVzN2xUlkhiL53');
/*!40000 ALTER TABLE `travel_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `last_online` varchar(255) DEFAULT NULL,
  `is_block` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('EjdJpyTQK3XixFmPP9cXrCNuuay2',NULL,'tuanprokt@gmail.com','Tuan Pham','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/uploads%2F1647709234842.null?alt=media&token=16ff4b31-a5f5-4ac3-ab93-94b8ca0ee0a7',10.7769,106.7009,'callmeto','1696008985832',_binary '\0'),('gcIPbK6kb1T5qEVVzN2xUlkhiL53','hello there..aaa','tuanprokt44@gmail.com','Tuân Pham10','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718',20.981002135154935,105.78731967456642,'tuan1062001','1696008985832',_binary '\0'),('n7kvXHm6Q2Ym7nSYSoCfreh9xDy2',NULL,'tuanaaa@gmail.com','tuanprooo','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718',48.8566,2.3522,'tuankt','1696008985832',_binary '\0'),('yLtUpaKktZWiUFv9PALw75sRCex2','Hello there...','tuanprokt445@gmail.com','Phạm Tuân','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/uploads%2F1645424345127.null?alt=media&token=d307ba93-f1ce-4c84-9c7a-4b3b4e78bf23',37.4220936,-122.083922,'tuan307','1696008985832',_binary '\0'),('YrqdwzMXb9aotGRQf7IPhkvCaBF2',NULL,'tuankkk@gmail.com','tuanpham','https://firebasestorage.googleapis.com/v0/b/social-app-5e237.appspot.com/o/images.png?alt=media&token=21412571-7fed-4592-9026-cded90f2f718',20.6169,105.9726,'callmtuan','1696008985832',_binary '\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_follow`
--

DROP TABLE IF EXISTS `user_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_follow` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `source_id` varchar(255) DEFAULT NULL,
  `target_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3u3cy7whpvhk302cel17e7o4n` (`source_id`),
  KEY `FKebwub620km7nrst0x5uareend` (`target_id`),
  CONSTRAINT `FK3u3cy7whpvhk302cel17e7o4n` FOREIGN KEY (`source_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKebwub620km7nrst0x5uareend` FOREIGN KEY (`target_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_follow`
--

LOCK TABLES `user_follow` WRITE;
/*!40000 ALTER TABLE `user_follow` DISABLE KEYS */;
INSERT INTO `user_follow` VALUES (21,'1701596473703','follow','gcIPbK6kb1T5qEVVzN2xUlkhiL53','yLtUpaKktZWiUFv9PALw75sRCex2'),(22,'1701596473703','follower','yLtUpaKktZWiUFv9PALw75sRCex2','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(23,'10000','follow','EjdJpyTQK3XixFmPP9cXrCNuuay2','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(24,'10000','follower','gcIPbK6kb1T5qEVVzN2xUlkhiL53','EjdJpyTQK3XixFmPP9cXrCNuuay2'),(25,'1701789084230','follow','gcIPbK6kb1T5qEVVzN2xUlkhiL53','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2'),(26,'1701789084230','follower','n7kvXHm6Q2Ym7nSYSoCfreh9xDy2','gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(27,'1701794972361','follow','gcIPbK6kb1T5qEVVzN2xUlkhiL53','EjdJpyTQK3XixFmPP9cXrCNuuay2'),(28,'1701794972361','follower','EjdJpyTQK3XixFmPP9cXrCNuuay2','gcIPbK6kb1T5qEVVzN2xUlkhiL53');
/*!40000 ALTER TABLE `user_follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_interest`
--

DROP TABLE IF EXISTS `user_interest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_interest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `interest_id` bigint DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55l4ter5qtvnjo6740muqghpd` (`interest_id`),
  KEY `FK64oc82tkm17jn5wikjiv26bpp` (`user_id`),
  CONSTRAINT `FK55l4ter5qtvnjo6740muqghpd` FOREIGN KEY (`interest_id`) REFERENCES `interest` (`id`),
  CONSTRAINT `FK64oc82tkm17jn5wikjiv26bpp` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_interest`
--

LOCK TABLES `user_interest` WRITE;
/*!40000 ALTER TABLE `user_interest` DISABLE KEYS */;
INSERT INTO `user_interest` VALUES (54,1,'gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(57,1,'yLtUpaKktZWiUFv9PALw75sRCex2'),(58,5,'yLtUpaKktZWiUFv9PALw75sRCex2'),(59,8,'yLtUpaKktZWiUFv9PALw75sRCex2'),(60,9,'yLtUpaKktZWiUFv9PALw75sRCex2'),(61,15,'gcIPbK6kb1T5qEVVzN2xUlkhiL53'),(62,5,'gcIPbK6kb1T5qEVVzN2xUlkhiL53');
/*!40000 ALTER TABLE `user_interest` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-30 10:09:53
