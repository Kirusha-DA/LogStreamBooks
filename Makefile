postgres-up:
	docker run -d --name=postgres --rm -e POSTGRES_USER=kirill -e POSTGRES_DB=books -e POSTGRES_PASSWORD=123 -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:alpine 
postgres-down:
	docker stop postgres

server-up:
	./mvnw spring-boot:start -e
server-down:
	./mvnw spring-boot:stop