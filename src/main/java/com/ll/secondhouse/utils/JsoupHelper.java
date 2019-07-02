package com.ll.secondhouse.utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JsoupHelper {

    public static Object fecthNode(String url, String xpath) throws Exception {
        String html = null;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        HtmlCleaner hc = new HtmlCleaner();
        TagNode tn = hc.clean(html);
        Document dom = new DomSerializer(new CleanerProperties()).createDOM(tn);
        XPath xPath = XPathFactory.newInstance().newXPath();
        Object result = xPath.evaluate(xpath, dom, XPathConstants.NODESET);

        return result;
    }

    public static List<String> fecthByMap(String url, String xpath) throws Exception {
        Map<String, String> nodeMap = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        Object result = fecthNode(url, xpath);

        if (result instanceof NodeList) {
            NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node == null){
                    continue;
                }
                String string = node.getTextContent().replace("关注","");
                String string1 = string.replace("加入对比","");
                String string2 = string1.replace("\n","");
                String strin3 = string2.replace("\t","");
                list.add(string2);
                nodeMap.put(node.getTextContent(), node.getAttributes().getNamedItem("href")!=null ?
                        node.getAttributes().getNamedItem("href").getTextContent() : "");
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception{
//        System.out.println(fecthByMap("https://bj.lianjia.com/ershoufang/rs%E5%93%88%E5%B7%A5%E5%A4%A7/","//div[@class='info clear']").get(1));
        //div[@class='list-info']
        System.out.println(fecthByMap("https://hrb.58.com/ershoufang/?key=%E5%93%88%E5%B7%A5%E5%A4%A7","//div[@class='list-info']").get(1));
    }
}


