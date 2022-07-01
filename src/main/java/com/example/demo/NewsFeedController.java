package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class NewsFeedController {
    @RequestMapping(value="/", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView show(@RequestParam(required = false) Map<String, String> allParams)throws Exception
    {
        String query = "sports";
        String topic = allParams.get("topic");
        if(topic != null)
        {
            query = topic;
        }
        String target="https://newsapi.org/v2/everything?q="+query+"&pageSize=50&apiKey=2fbfbc294434437e8818f71739b32d00";
        NewsFetcher news=new NewsFetcher();
        JSONObject feed=news.fetcher(target);
        JSONArray articles=(JSONArray) feed.get("articles");
        System.out.println("no of articles ("+query+"): "+articles.size());
        ArrayList<News> newsList = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++)
        {
           try
           {
               JSONObject new_obj = (JSONObject) articles.get(i);
               News ne = new News();
               ne.setTitle(new_obj.get("title").toString());
               ne.setDesc(new_obj.get("description").toString());
               ne.setUrl(new_obj.get("url").toString());
               ne.setImageurl(new_obj.get("urlToImage").toString());

               newsList.add(ne);
           }
           catch(Exception e)
           {
               System.out.println(e);
               continue;
           }
        }
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("news", newsList);
        mv.addObject("query", query);
        mv.addObject("batchsize",newsList.size());

        return mv;
    }
}
