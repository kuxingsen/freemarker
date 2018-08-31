package cn.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * Created by Kuexun on 2018/7/24.
 */
public class Helloworld {
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setDirectoryForTemplateLoading(new File("templates"));

            Template helloTemp = configuration.getTemplate("helloworld.flt");

            Map root = new HashMap<>();
            root.put("user","lisi");
            root.put("grade",new Random().nextInt(100));

            Map map = new HashMap<>();
            map.put("lisi",30);
            map.put("zhangsan",20);

            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            set.add(0);

            List list = new ArrayList();
            list.add("lisi");
            list.add("zhangsan");
//            list.add(map);

            root.put("map",map);
            root.put("lst",list);
            root.put("set",set);

            root.put("date1",new Date());
            root.put("html2","<b>html2</b>");



            Writer writer = new OutputStreamWriter(System.out);

            helloTemp.process(root,writer);
            writer.flush();
            writer.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
