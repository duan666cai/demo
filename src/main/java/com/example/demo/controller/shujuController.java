package com.example.demo.controller;

import com.example.demo.mapper.ShujuMapper;
import com.example.demo.model.Shuju;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class shujuController {
    @Autowired
    private ShujuMapper shujuMapper;

    @GetMapping("/zhishidian")
    @RequestMapping("/zhishidian")
    public String zhishidian() {
        return "zhishidian";
    }

    @RequestMapping("/addshuju")
    public String addshuju(HttpServletRequest request, Map<String, Object> map) {
        String biaoti = request.getParameter("biaoti");
        String leirong = request.getParameter("leirong");
        Shuju shuju = new Shuju();
        shuju.setBiaoti(biaoti);
        shuju.setLeirong(leirong);
        Shuju shuju1 = shujuMapper.getshuju(biaoti);
        if (shuju1!=null) {
            map.put("msg1", "该标题已被使用，添加知识点失败");
            return "zhishidian";
        } else {
            shujuMapper.addshuju(shuju);
            map.put("msg1","“"+ biaoti+ "”成功添加");
            return "zhishidian";
        }
    }

    @RequestMapping("/getleirong")
    public String getleirong(HttpServletRequest request, Map<String, Object> map) {
        String biaoti = request.getParameter("biaoti");
        Shuju  shuju = shujuMapper.getshuju(biaoti);
        String leirong = shujuMapper.getleirong(biaoti);
        if (shuju!= null) {
            map.put("msg3", leirong);
            return "zhishidian";
        } else {
            map.put("msg3", "查找失败，没有该标题");
            return "zhishidian";
        }
    }

    @RequestMapping("/deleteshuju")
    public String deleteshuju(HttpServletRequest request, Map<String,Object> map) {
        String biaoti = request.getParameter("biaoti");
        Shuju getshuju = shujuMapper.getshuju(biaoti);
        if (getshuju != null) {
            shujuMapper.deleteshuju(biaoti);
            map.put("msg2", "“" +biaoti+" ”删除成功！");
            return "zhishidian";
        } else {
            map.put("msg2", "不存在该标题");
            return "zhishidian";
        }
    }

    @RequestMapping("/Updateshuju")
    public String Updateshuju(HttpServletRequest request, Map<String,Object> map) {
        String biaoti = request.getParameter("biaoti");
        String leirong = request.getParameter("leirong");
        Shuju getshuju = shujuMapper.getshuju(biaoti);
 //       String leirong1 = shujuMapper.getleirong(biaoti);
        if (getshuju != null) {
            shujuMapper.updateshuju(biaoti,leirong);
            map.put("msg3", "更新"+biaoti+"成功");
            return "zhishidian";
        } else {
            map.put("msg3", "数据库无标题“"+biaoti+"”,更新失败");
            return "zhishidian";
        }
    }

 /*   @RequestMapping("/getallbiaoti")
    public String getallbiaoti(Map<String,Object> map) {
        for(int id = 1;id<38;){
            String biaoti = shujuMapper.getbiaoti(id);
            System.out.println(biaoti);
            map.put("msg",biaoti);
            id++;
        }
        return "zhishidian";
    }  */
/*    @RequestMapping("/display")
    public String display(Map<String, Object> map) {
        List<Shuju> bt = shujuMapper.display();
    //    System.out.println(bt);
        map.put("msg5", bt);
        return "zhishidian";
    }
*/
    @RequestMapping("/allbiaoti")
    public String allbiaoti(Map<String, Object> map) {
        List<String> bt = shujuMapper.allbiaoti();
    //        System.out.println(bt.get(2));
        map.put("msg6", bt);
        return "zhishidian";
    }



    @RequestMapping("/alldisplay")
    public  String alldisplay(Model model,Map<String,Object> map) {
        String headvalue;
        String datavalue;
        int idvalue = 0;
        Map<String,Shuju> allMembers = new HashMap<String,Shuju>();

        //提取当前数据表的所有标题和内容并得到当前数据库长度，
        List<String> bt = shujuMapper.allbiaoti();
        List<String> lr = shujuMapper.allleirong();
        int listSize = bt.size();
        String[] Display_Data = new String[listSize];
        String[] Display_Head = new String[listSize];
        for (int x = 1;x <= listSize; x = x +1) {
            headvalue = bt.get(x-1);
            datavalue = lr.get(x-1);
            Display_Head[idvalue] = headvalue;  //标题数组
            Display_Data[idvalue] = datavalue;  //内容数组
            idvalue++;
      //      System.out.println(Display_Head[idvalue-1]);
        }
       //            System.out.println(listSize);
      //             System.out.println(idvalue);

/*        while (datas0 != null) {
            headvalue = shujuMapper.getbt(idvalue);
            datavalue = shujuMapper.getlr(idvalue);
            Display_Head[idvalue] = headvalue;  //标题数组
            Display_Data[idvalue] = datavalue;  //内容数组
            idvalue++;
            size++;
            shuju = shujuMapper.getid(idvalue);
        }  */
        for (int t = 1;t <= idvalue; t = t +1) {
            Shuju vo = new Shuju();
            vo.setId(t);
            vo.setBiaoti(Display_Head[t-1]);
            vo.setLeirong(Display_Data[t-1]);
            allMembers.put("index"+t,vo);
       //     map.put("allDatas", vo);
       //     System.out.println(vo);
        }
     //   System.out.println(allMembers);
        map.put("allDatas", allMembers);
        return "zhishidian";
    }


/*    @RequestMapping("/alldisplay")
    public String alldisplay(Map<String, Object> map) {
        List<String> bt = shujuMapper.allbiaoti();
        List<String> lr = shujuMapper.allleirong();
        int listSize = bt.size();
   //     bt.addAll(lr);
       for(int cnt = 1;cnt<=listSize;){
            String qq = bt.get(cnt-1) + lr.get(cnt-1);
            List<String> all.add();
            cnt++;
        }
        map.put("msg7", bt);
        return "zhishidian";
    }
*/


}