# DOCKER CONFIG
FROM centos:8

# 開放するポートを設定
EXPOSE 8080
EXPOSE 8005
EXPOSE 8009

# ダウンロードパス
ENV JDK_URL https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_linux-x64_bin.tar.gz
ENV TOMCAT_URL https://ftp.tsukuba.wide.ad.jp/software/apache/tomcat/tomcat-10/v10.0.0-M4/bin/apache-tomcat-10.0.0-M4.tar.gz

# 環境変数設定
ENV JAVA_HOME="/usr/local/java/current"
ENV TOMCAT_HOME="/usr/local/tomcat/current"

# wget インストール
RUN yum -y install wget

# java インストール
WORKDIR /usr/local/java
RUN wget -q $JDK_URL
RUN tar -xzf *.tar.gz
RUN rm -f *.tar.gz
RUN ln -snf * current

# tomcat インストール
WORKDIR /usr/local/tomcat
RUN wget -q $TOMCAT_URL 
RUN tar -xzf *.tar.gz
RUN rm -f *.tar.gz
RUN ln -snf * current

ENTRYPOINT [ "/usr/local/tomcat/current/bin/catalina.sh" , "run" ]