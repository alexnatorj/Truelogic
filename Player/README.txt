1. Download and configure Kafka and Zookeeper;
2. execute the command 'zkserver' to start Zookeeper.
3. Starting Kafka
 a. Windows user:
	Go to the folder /kafka_X.X/bin/windows and run the command: 
		kafka-server-start.bat ../../config/server.properties
 
 b. Linux user:
	Go to the folder /kafka_X.X/bin and run the command: 
		kafka-server-start.sh ../config/server.properties

4. Create the topic:
	a. Windows user:
		kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic novice-players
		
	b. Linux user:
		kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic novice-players

5. Run the application
	open the command line and execute:
	java -jar player.jar br.com.truelogic.PlayerApplication
	
6. Endpoint URL
	POST | http://localhost:8081/player/players
	body Json example:
	 {
     "players" :
		[
			{
			  "name": "Sub zero",
			  "type": "expert"
			},
			{
			  "name": "Scorpion",
			  "type": "novice"
			},
			{
			  "name": "Reptile",
			  "type": "meh"
			}
	   ]
	}