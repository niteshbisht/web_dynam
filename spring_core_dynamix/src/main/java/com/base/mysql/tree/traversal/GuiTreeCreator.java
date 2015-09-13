package com.base.mysql.tree.traversal;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;

public class GuiTreeCreator {
	public static void main(String[] args) {
		try {
			GuiTreeCreator.createGuiTree("io_data_for_mysql_prob/data.json");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createGuiTree(String path)
			throws JsonProcessingException, IOException {
		File f = new File(path);
		ObjectMapper om = new ObjectMapper();
		JsonNode jnode = om.readTree(f);
		//cleanTree(jnode);
		putJsonNodeInRoot(jnode);
		//
		System.out.println(jnode);
		File f2 = new File("io_data_for_mysql_prob/outputclean.json");
		om.writeValue(f2, jnode);
		
	}

	public static void cleanTree(JsonNode rootNode) {
		Iterator<JsonNode> itr = rootNode.elements();
		while (itr.hasNext()) {
			JsonNode jnode = itr.next();
			JsonNodeType jnodeType = jnode.getNodeType();
			if (jnodeType.equals(JsonNodeType.ARRAY)) {
				putJsonNodeInRoot(jnode);
			}

			if (jnodeType.equals(JsonNodeType.OBJECT)) {
				cleanTree(jnode);
			}
		}
	}

	public static void putJsonNodeInRoot(JsonNode parent) {
		Iterator<Entry<String, JsonNode>> jnodesItr = parent.fields();
		while (jnodesItr.hasNext()) {
			Entry<String, JsonNode> ent = jnodesItr.next();
			if (ent.getKey().equals("childNodes")) {
				// ent.setValue(arrayNode);
				if (ent.getValue().size() > 0) {
					ArrayNode arrNode;
					JsonNode node = ent.getValue();
					arrNode = new ArrayNode(JsonNodeFactory.instance);
					Iterator<String> fnames = node.fieldNames();
					while (fnames.hasNext()) {
						JsonNode jnodedata = node.get(fnames.next());
						//System.out.println(jnodedata.size());
						JsonNode jnodedata2 = jnodedata.get(0);
						//System.out.println(jnodedata2);
						putJsonNodeInRoot(jnodedata2);
						arrNode.add(jnodedata2);
					}
					ent.setValue(arrNode);
				}
			}
		}
	}
}
