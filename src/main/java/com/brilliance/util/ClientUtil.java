package com.brilliance.util;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.*;

public class ClientUtil {

	public static Client getInstance() {
		Node node = nodeBuilder().clusterName("my-application").node();
		Client client = node.client();
		return client;
	}
}
