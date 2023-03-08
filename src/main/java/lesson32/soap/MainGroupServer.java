package lesson32.soap;

import jakarta.xml.ws.Endpoint;

/**
 * @author spasko
 */
// Endpoint publisher
public class MainGroupServer {

	public static void main(String[] args) {		
		Endpoint endpoint = Endpoint.create(new GroupServiceImpl());
        endpoint.publish("http://localhost:9999/group");
	}

}