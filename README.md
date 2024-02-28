** postgres **  docker pull postgres:14.5  && docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres

** rabbitmq ** docker pull rabbitmq && docker run -d --hostname rmq --name rabbit-server -p 8080:15672 -p 5672:5672 rabbitmq:3.13.0-management 

** pg admin ** docker pull dpage/pgadmin4  &&  docker run -p 80:80 -e "PGADMIN_DEFAULT_EMAIL=user@domain.com" -e "PGADMIN_DEFAULT_PASSWORD=SuperSecret" -d dpage/pgadmin4

** Consumer service ** create database transactionbd

** Producer service ** create database ms1
