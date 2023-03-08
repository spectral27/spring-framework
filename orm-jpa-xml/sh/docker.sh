mvn clean install
docker rm -f orm-jpa-xml-container
docker rmi orm-jpa-xml-image
docker build -t orm-jpa-xml-image .
docker run --rm --name orm-jpa-xml-container orm-jpa-xml-image
