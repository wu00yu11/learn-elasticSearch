package com.learn.elasticsearch.utils;

import com.learn.elasticsearch.model.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author wu00y
 */
public class HtmlParseUtil {
    public static void main(String[] args) {
        try {
           new HtmlParseUtil().parseJD("机械工业",30*1000).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  ArrayList<Content> parseJD(String keyword, int timeoutMillis) throws Exception {
        //获取请求
        String url = "https://search.jd.com/Search?keyword="+keyword;
        //解析网页(浏览器document对象)
        Document document = Jsoup.parse(new URL(url),timeoutMillis);
        Element element = document.getElementById("J_goodsList");
        //    System.out.println(element.html());
        Elements lis = element.getElementsByTag("li");
        ArrayList<Content> goodsList = new ArrayList<>();
        for (Element li : lis) {
            //关于图片比较多的网站,都是懒加载的,先默认图片,然后再渲染
            String image = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();
            String title = li.getElementsByClass("p-name").eq(0).text();

            goodsList.add(new Content(title,price,image));

//            System.out.println("================================");
//            System.out.println(image);
//            System.out.println(price);
//            System.out.println(title);
        }
        return goodsList;
    }
}
