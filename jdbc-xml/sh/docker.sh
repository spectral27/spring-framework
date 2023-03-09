mvn clean install
docker rm -f jdbc-xml-container
docker rmi jdbc-xml-image
docker build -t jdbc-xml-image .
docker run --rm --name jdbc-xml-container jdbc-xml-image
