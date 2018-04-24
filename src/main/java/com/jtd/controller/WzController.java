package com.jtd.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.util.PropertiesUtil;
@Controller
public class WzController {
	
	@RequestMapping("/wz")
	@ResponseBody
	public List<String> getWz(){
		String files=PropertiesUtil.getProperty("file.name");
		String[] names=files.split(",");
		List<String> list=new ArrayList<>();
		for (String string : names) {
			File file = new File("E:/20180325_Backup/wz/"+string);
			if(!file.exists()){
				continue;
			}
			list.add(txt2String(file));
		}
		return list; 
	}
	
    public static String txt2String(File file){  
        StringBuilder result = new StringBuilder();  
        try{ 
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件  
            String s = null;  
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行  
                result.append(System.lineSeparator()+s);  
            }  
            br.close();      
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return result.toString();  
    }

}
