all: clean build run 

run:
	@mvn spring-boot:run

build:
	@mvn clean install 

test:
	@mvn test 

clean:
	@mvn clean 