-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2024-05-16 14:43:49
-- 伺服器版本： 10.4.27-MariaDB
-- PHP 版本： 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `project`
--

-- --------------------------------------------------------

--
-- 資料表結構 `comment`
--

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `post_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `comment`
--

INSERT INTO `comment` (`comment_id`, `user_id`, `post_id`, `content`, `created_at`) VALUES
(2, 12, 21, '123', '2024-05-16 20:09:05'),
(3, 12, 21, '123123123123', '2024-05-16 20:10:26'),
(4, 12, 21, '123123123123', '2024-05-16 20:10:27'),
(5, 12, 21, '123123123123', '2024-05-16 20:10:28'),
(6, 12, 21, '123', '2024-05-16 20:11:41'),
(7, 12, 21, '123', '2024-05-16 20:11:42'),
(8, 12, 21, '123', '2024-05-16 20:15:18'),
(9, 12, 21, '123', '2024-05-16 20:16:10'),
(10, 12, 21, '123123', '2024-05-16 20:17:02'),
(11, 12, 21, '123123', '2024-05-16 20:17:06'),
(12, 12, 21, '123123', '2024-05-16 20:17:07'),
(13, 12, 21, '123', '2024-05-16 20:17:32'),
(14, 12, 21, '123', '2024-05-16 20:17:46'),
(15, 12, 21, '123', '2024-05-16 20:17:55'),
(16, 12, 21, '123', '2024-05-16 20:19:07'),
(17, 12, 21, '123', '2024-05-16 20:19:09'),
(18, 12, 21, '123', '2024-05-16 20:19:10'),
(19, 12, 21, '123', '2024-05-16 20:19:25'),
(20, 12, 21, '123', '2024-05-16 20:19:30'),
(21, 12, 21, '123', '2024-05-16 20:19:45'),
(22, 12, 21, '123', '2024-05-16 20:19:48'),
(23, 12, 21, '123', '2024-05-16 20:21:21'),
(24, 12, 21, '123123', '2024-05-16 20:26:23'),
(25, 12, 20, '123123', '2024-05-16 20:26:36'),
(26, 12, 21, '123', '2024-05-16 20:29:03'),
(27, 12, 21, '123', '2024-05-16 20:29:09');

-- --------------------------------------------------------

--
-- 資料表結構 `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `content` text NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `post`
--

INSERT INTO `post` (`post_id`, `user_id`, `content`, `created_at`) VALUES
(20, 12, '第一則貼文，Good', '2024-05-16 11:23:11'),
(21, 12, '測試看看是否能用Posts下的Comment', '2024-05-16 11:37:17');

-- --------------------------------------------------------

--
-- 資料表結構 `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `user_phone` varchar(10) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `biography` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `users`
--

INSERT INTO `users` (`user_id`, `user_phone`, `user_name`, `email`, `password`, `cover_image`, `biography`) VALUES
(12, '0911223344', 'Alan', NULL, 'uiiPLq4PnuRzdhPtb08N7PnbMz+zUAU2JlxK6qkc35qQghjZ4uB4qndMIqFsqDUh', NULL, NULL);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `fk_post_id` (`post_id`),
  ADD KEY `cfk_user_id` (`user_id`);

--
-- 資料表索引 `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `fk_user_id` (`user_id`);

--
-- 資料表索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `post`
--
ALTER TABLE `post`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `cfk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `fk_post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

--
-- 資料表的限制式 `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
