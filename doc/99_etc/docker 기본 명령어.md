# Dockre 기본 명령어

## Docker pull
Docker Hub에서 이미지 다운로드 하여 이미지 생성 (Build)
- Docker Hub에서 이미지 검색
```
docker search [이미지 이름]
```

- 이미지 다운로드
```
docker image pull [이미지 이름]
```

```
docker search nginx #nginx 이미지 Docker hub에서 검섹
docker image pull nginx #nginx 이미지 Docker hub에서 다운로드
```

- 로컬에 다운로드된 이미지 리스트 보기 
```
docker image ls
```

## Docker create
Docker 컨테이너 생성
```
docker create --name [컨테이너 이름] [이미지 이름]
```

```
docker create --name nginx-1 nginx
# nginx 이미지로 nginx-1 컨테이너 생성
```

- 생성된 docker 컨테이너 확인 (`docker ps -a`)
  - STATUS = Create
  - 컨테이너가 생성은 되었으나, 실행되지 않았으므로 `docker ps` 로는 출력되지 않음 
```
eunbi@EUNBI-KIM:~/Docker$ docker ps -a
CONTAINER ID   IMAGE         COMMAND                  CREATED              STATUS                          PORTS     NAMES
cfbb339677e9   nginx         "/docker-entrypoint.…"   About a minute ago   Created   
```

## Docker start / stop
생성한 컨테이너 실행(start) : STATUS = UP
```
docker start [이미지 이름]
```

생성한 컨테이너 종료(stop) : STATUS = Exited
```
docker stop [이미지 이름]
```


```
docker start nginx-1 #nginx-1 컨테이너 실행
docker start cfbb33 #nginx-1 container id로 컨테이너 실행

docker stop nginx-1 #nginx-1 컨테이너 종료
docker stop cfbb33 #nginx-1 container id로 컨테이너 종료
```


## Docker run 
컨테이너 생성 및 실행 
```docker run [옵션] [이미지 이름]
```
- docker run을 수행할 경우, docker create > docker start 를 수행한 것과 같음

- 많이 사용하는 옵션
  ```
  --name [컨테이너 이름] # 컨테이너 이름 지정하여 컨테이너 생성
  -it #컨테이느 내의 Bash 쉘에 접속
  -d # 컨테이너를 백그라운드에서 실행
  -p [호스트 포트]:[컨테이터 포트] #컨테이너의 네트워크 프트와 호스트 포트 매핑
  -v [호스트 경로]:[컨테이너 경로] #호스트 디렉토리를 컨테이너 내부 디렉토리로 마운트
  --rm #컨테이너 종료시 자동으로 컨테이서 삭제
  ```

```
docker run --name nginx-2 -d nginx #백그라운드에서 nginx-2 이름을 부여한 컨테이너 생성 및 실행
docker run -p 8080:80 nginx #호스트의 8080 포트를 컨테이너의 80 포트와 연결
docker run -it ubuntu /bin/bash #ubuntu 이미지로 컨테이너 생성 및 실행 후, 내부 bash에 접속
```


---
## 기타 명령어
컨테이너 목록 출력
```
docker ps #현재 실행 중인 컨네이너 목록 출력
docker ps -a #현재 존재하는 모든 컨테이너 목록 출력 (생성, 실행, 종료 상태 모두)
```

컨테이너 삭제 : `docker rm [컨테이너 이름]`
```
docker rm nginx-1
```

linux 명령어 사용 시, permission denied 에러 발생하는 경우 명령어 앞에 `sudo` 입력
  ex) `sudo docker search nginx`
