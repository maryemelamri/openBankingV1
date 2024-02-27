producer
  pull image
  docker pull postgres:14.5
  run postgres container 
  docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d ms1
