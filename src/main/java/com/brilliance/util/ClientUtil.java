package com.brilliance.util;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientUtil {

	public static Client getInstance() {
		// Node node = nodeBuilder().clusterName("my-application").node();
		// Client client = node.client();
		// return client;

		Client client = null;
		try {
			client = TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return client;

	}
}
