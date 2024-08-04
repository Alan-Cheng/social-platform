# 社群媒體平台專案

## 專案介紹
提供用戶一個互動和分享的平台。專案前端使用Vue.js，後端則使用Spring Boot，透過RestAPI進行前後端的資料串接。資料庫為MySQL，用於儲存帳戶和貼文的資料。

## 技術
- **前端**: Vue.js
- **後端**: Spring Boot
- **API**: RestAPI
- **資料庫**: MySQL

## 功能介紹
1. **註冊**: 可以透過手機號碼註冊新帳戶。
2. **登入**: 已註冊的用戶可以登入並進入社媒主頁。
  ![image](https://github.com/Alan-Cheng/social-platform/blob/main/Login_Register.png)
4. **貼文**: 用戶可以發佈新的貼文，分享文字內容。
5. **留言**: 用戶可以於貼文下方留言，互相交流。
6. **刪除貼文或評論**: 用戶可刪除自己的貼文或留言。
  ![image](https://github.com/Alan-Cheng/social-platform/blob/main/Social_Page.png)


## 架構設計
專案採用MVC（Model-View-Controller）架構設計，以確保程式碼的可維護性和擴展性：
- **Model**: 負責數據層的處理，包括資料庫的操作。
- **View**: 前端頁面展示和使用者互動，使用Vue.js實現動態且友好的使用者界面。
- **Controller**: 負責處理業務邏輯，接收來自前端的請求並調用相應的服務。
