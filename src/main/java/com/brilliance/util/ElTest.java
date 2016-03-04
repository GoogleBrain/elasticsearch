package com.brilliance.util;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.util.Date;
import java.util.Map;

public class ElTest {
	public static void main(String[] args) throws Exception {
		Client client = ClientUtil.getInstance();
		/*
		 * 添加索引
		 */
		// client.prepareIndex("name", "name1",
		// "11").setSource(jsonBuilder().startObject().field("user",
		// "kimchy").field("postDate", new Date()).field("message", "trying out
		// Elasticsearch").endObject()).get();

		/*
		 * 修改索引
		 */

		// client.prepareUpdate("twitter", "tweet",
		// "11").setDoc(jsonBuilder().startObject().field("user",
		// "godddoglebrain").endObject()).get();

		/*
		 * 删除索引
		 */
		// client.prepareDelete("twitter", "tweet", "11").get();

		/*
		 * 获取索引,查询某一列上
		 */
		// GetResponse response = client.prepareGet("twitter",
		// "tweet","1").get();
		// System.out.println(response.getSource().get("postDate"));

		// SearchResponse response =
		// client.prepareSearch("twitter").setTypes("tweet").setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.termQuery("user",
		// "huzaibin")) // Query
		// .setExplain(true).execute().actionGet();

		SearchRequestBuilder srb = client.prepareSearch("student");
		srb.setTypes("huzaibin");
		srb.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
		// 查询所有的列
		srb.setQuery(QueryBuilders.termQuery("_all", "龙"));
		// srb.setQuery(QueryBuilders.termQuery("name", "lucy"));
		// srb.setQuery(QueryBuilders.termQuery("name", "龙"));
		// srb.setFrom(0);
		// srb.setSize(60);
		//
		srb.setPostFilter(QueryBuilders.rangeQuery("age").from(20).to(50));
		srb.setExplain(true);
		srb.addHighlightedField("name");
		srb.setHighlighterPreTags("<span style=\"color:red\">");
		srb.setHighlighterPostTags("</span>");
		srb.addSort("age", SortOrder.ASC);
		SearchResponse response = srb.execute().actionGet();
		SearchHits shs = response.getHits();
		for (SearchHit hit : shs) {
			Map<String, Object> map = hit.getSource();
			System.out.println(map.get("name") + " " + map.get("sex") + " " + map.get("age") + " " + map.get("address"));
		}
		client.close();
	}
}
