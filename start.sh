#!/bin/bash

# 启动XAMPP的MySQL服务器
echo "Starting XAMPP MySQL server..."
sudo /Applications/XAMPP/xamppfiles/bin/mysql.server start

# 检查MySQL服务器是否已启动
if ! pgrep mysql > /dev/null; then
    echo "Failed to start MySQL server."
    exit 1
else
    echo "MySQL server is running."
fi

# 啟動後端伺服器並在背景運行
cd backend
./gradlew bootRun&
BACKEND_PID=$!

# 啟動前端伺服器並在背景運行
cd ../frontend
npm run serve &
FRONTEND_PID=$!

sleep 10

# 等待用戶輸入任意鍵
echo "按任意鍵終止伺服器..."
read -n 1 -s

# 終止MySQL伺服器
echo "Stopping XAMPP MySQL server..."
sudo /Applications/XAMPP/xamppfiles/bin/mysql.server stop

# 終止後端伺服器
echo "Terminating backend server..."
kill $BACKEND_PID

# 終止前端伺服器
echo "Terminating frontend server..."
kill $FRONTEND_PID

echo "所有服務已停止。"
