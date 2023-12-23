Para levantar el servicio es necesario una conexion a bd mongodb 
yo utilice el atlas o con docker con el siguiente comando :  
docker run -d --name mi-mongodb -p 27017:27017  -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password mongo:latest
