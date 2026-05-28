#!/bin/bash

set -e

APP_NAME="ap-backend"
HOST_PORT=8001
CONTAINER_PORT=8080
JAR_TARGET="target"

echo "=============================="
echo "🚀 Step 1: git pull"
echo "=============================="
git pull


echo "=============================="
echo "🚀 Step 2: mvn clean package"
echo "=============================="
mvn clean package -DskipTests


echo "=============================="
echo "🚀 Step 3: docker build"
echo "=============================="
docker build -t $APP_NAME .


echo "=============================="
echo "🚀 Step 4: check port $HOST_PORT"
echo "=============================="

CONTAINER_ID=$(docker ps -q --filter "publish=$HOST_PORT")

if [ -n "$CONTAINER_ID" ]; then
    IMAGE_NAME=$(docker inspect --format='{{.Config.Image}}' $CONTAINER_ID)

    echo "⚠️ Port $HOST_PORT is used by container: $CONTAINER_ID ($IMAGE_NAME)"

    if [[ "$IMAGE_NAME" == *"$APP_NAME"* ]]; then
        echo "🟢 Container belongs to $APP_NAME, stopping..."
        docker stop $CONTAINER_ID
        docker rm $CONTAINER_ID
    else
        echo "🔴 Port is used by OTHER application ($IMAGE_NAME)"
        echo "❌ Abort deployment"
        exit 1
    fi
else
    echo "🟢 Port $HOST_PORT is free"
fi


echo "=============================="
echo "🚀 Step 5: docker run"
echo "=============================="

docker run -d \
  -p $HOST_PORT:$CONTAINER_PORT \
  $APP_NAME

echo "=============================="
echo "✅ Deploy finished!"
echo "=============================="