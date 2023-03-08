mvn clean install
docker rm -f orm-hibernate-xml-container
docker rmi orm-hibernate-xml-image
docker build -t orm-hibernate-xml-image .
docker run --rm --name orm-hibernate-xml-container orm-jpa-xml-image
