#!/bin/bash

containerName=todomysql
dbname=tododb
rootpw=root
port=3306

query="create user 'vertsys'@'%' identified with sha256_password by 'vertsys'; grant all privileges on tododb.* to 'vertsys'@'%';";

sudo apt-get install mysql-client-5.7


if [ "$(docker images | grep -c 'mysql')" = 0 ] 
then
	docker pull mysql;
fi
if [ "$(docker container ls -a | grep $containerName -c )" = 0 ]
then
	container="$(docker run -d --name $containerName -e MYSQL_ROOT_PASSWORD=$rootpw -e MYSQL_DATABASE=$dbname  -p $port:3306 mysql  )";
fi

docker start $containerName;

while ! (mysqladmin ping -u root -h 127.0.0.1 -P $port --protocol=TCP --password=$rootpw ) do
	echo "Waiting for database to start...";
	sleep 2;
done


docker exec todomysql bash -c "echo \"$query\" | mysql --password=\"$rootpw\"";


