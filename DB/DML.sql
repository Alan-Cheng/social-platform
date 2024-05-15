-- 新增使用者
INSERT INTO User (user_name, email, password, salt, cover_image, biography) 
VALUES ('JohnDoe', 'john@example.com', 'hashed_password', 'salt_value', 'image_url', 'A short bio about John.');

-- 新增post
INSERT INTO Post (user_id, content, image) 
VALUES (1, 'This is my first post!', 'post_image_url.jpg');

-- 新增評論
INSERT INTO Comment (user_id, post_id, content) 
VALUES (2, 1, 'Great post, John! Keep it up!');

-- 修改使用者資料
UPDATE User 
SET user_name = 'UpdatedName', biography = 'An updated bio.' 
WHERE user_id = 1;

-- 修改post內容
UPDATE Post 
SET content = 'Updated post content.' 
WHERE post_id = 1;

-- 刪除使用者
DELETE FROM User 
WHERE user_id = 2;

-- 刪除post及其相關的評論
DELETE FROM Post 
WHERE post_id = 1;
DELETE FROM Comment 
WHERE post_id = 1;
