package com.brilliance.util;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.util.Date;

public class ElTest {
	public static void main(String[] args) throws Exception {
		Client client = ClientUtil.getInstance();
		/*
		 * 添加索引
		 */
		//client.prepareIndex("twitter", "tweet", "11").setSource(jsonBuilder().startObject().field("user", "kimchy").field("postDate", new Date()).field("message", "trying out 		 Elasticsearch").endObject()).get();

		/*
		 * 修改索引
		 */
		//client.prepareUpdate("twitter", "tweet", "11").setDoc(jsonBuilder().startObject().field("user", "godddoglebrain").endObject()).get();
		
		/*
		 * 删除索引
		 */
		//client.prepareDelete("twitter", "tweet", "11").get();
		
		/*
		 * 获取索引
		 */
		//GetResponse response = client.prepareGet("twitter", "tweet", "1").get();
		//System.out.println(response.getSource().get("postDate"));
		
		System.out.println(client);
		client.close();
	}
}
