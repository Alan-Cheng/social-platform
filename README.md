# 社群媒體平台專案

## 專案介紹
這是一個社群媒體平台的專案，旨在提供用戶一個互動和分享的平台。專案的前端使用了Vue.js，後端則是使用Spring Boot，並透過RestAPI進行前後端的資料串接。資料庫選用了MySQL來儲存用戶和貼文的數據。

## 技術
- **前端**: Vue.js
- **後端**: Spring Boot
- **API**: RestAPI
- **資料庫**: MySQL

## 功能介紹
本專案實現了以下主要功能：
1. **註冊**: 用戶可以透過註冊頁面創建新帳戶。
2. **登入**: 已註冊的用戶可以登入並進入個人主頁。
  ![image](https://github.com/Alan-Cheng/social-platform/blob/main/Login_Register.png)
4. **貼文**: 用戶可以發佈新的貼文，分享文字內容。
5. **評論**: 用戶可以對貼文進行評論，互相交流。
  ![image](https://github.com/Alan-Cheng/social-platform/blob/main/Social_Page.png)

## 架構設計
專案採用MVC（Model-View-Controller）架構設計，以確保程式碼的可維護性和擴展性：
- **Model**: 負責數據層的處理，包括數據庫的操作。
- **View**: 前端頁面展示和用戶互動，使用Vue.js實現動態且友好的用戶界面。
- **Controller**: 負責處理業務邏輯，接收來自前端的請求並調用相應的服務。
