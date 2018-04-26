#!/bin/bash

containerName=todomysql
dbname=tododb
rootpw=root
port=3306

query="create user 'vertsys'@'%' identified with sha256_password by 'vertsys'; grant all privileges on tododb.* to 'vertsys'@'%'; exit;";

sudo apt-get install mysql-client-5.7


if [ "$(docker images | grep -c 'mysql')" = 0 ] 
then
	docker pull mysql;
fi
if [ "$(docker container ls | grep $containerName -c )" = 0 ]
then
	container="$(docker run -d --name $containerName -e MYSQL_ROOT_PASSWORD='$rootpw' -e MYSQL_DATABASE='$dbname'  -p $port:3306 mysql --default-authentication-plugin=sha256_password )";
else
	docker start $containerName;
fi



while ! (mysqladmin ping -h 127.0.0.1 -P $port --protocol TCP --password=$rootpw > /dev/null 2> /dev/null) do
	echo "Waiting for database to start...";
	sleep 2;
done


docker exec todomysql bash -c 'mysql || echo $query | mysql --password=$rootpw';


